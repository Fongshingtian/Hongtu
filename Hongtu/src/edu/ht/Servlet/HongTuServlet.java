package edu.ht.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sun.jmx.snmp.EnumRowStatus;

import edu.ht.Bean.AboutUs;
import edu.ht.Bean.Activity;
import edu.ht.Bean.ContactUs;
import edu.ht.Bean.CourseDescription;
import edu.ht.Bean.Environment;
import edu.ht.Bean.Graduationtable;
import edu.ht.Bean.Managers;
import edu.ht.Bean.MessageBoard;
import edu.ht.Bean.MessageReply;
import edu.ht.Bean.News;
import edu.ht.Bean.PlanSignUp;
import edu.ht.Bean.SignUp;
import edu.ht.Bean.Students;
import edu.ht.Bean.Teachers;
import edu.ht.Bean.video;
import edu.ht.HtImplements.HongTuImplements;

public class HongTuServlet extends HttpServlet {
	
	HongTuImplements hti=new HongTuImplements();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		String method=request.getParameter("method");
		HttpSession session=request.getSession();
		if(method!=null){
//TODO ����������������������������������������������������������������������ʼ��������������������������������������������������������������������������������������������
			// ��¼�����˺������Ƿ���ȷ �Ƿ񱻽���
			if(method.equals("logining")){
				String account=request.getParameter("account");
				String pwd=request.getParameter("pwd");
				Managers m=hti.logining(account, pwd);
				if(m!=null){
					if(m.getStatus()!=0){
						session.setAttribute("managers", m);
						response.sendRedirect("Fss//Houtai//main.jsp");
					}else{
						request.setAttribute("message", "�˺��ѱ�����!");
						request.getRequestDispatcher("Fss//Login//logining.jsp").forward(request, response);
					}
				}else{
					request.setAttribute("message", "�˺Ż��������!");
					request.getRequestDispatcher("Fss//Login//logining.jsp").forward(request, response);
				}
			}
//TODO ��������������������������������������������������������������������1��̨��Ա������������������������������������������������������������������������������������
			// ��Ա������Ա����
			else if(method.equals("managersshow")){
				int perpage=10;
				int currentpage=1;
				int datacount=hti.datacount("managers");
				int totalpage=1;
				if(datacount%perpage==0){
					totalpage=datacount/perpage;
					if(datacount<=perpage){
						totalpage=1;
					}
				}else{
					totalpage=datacount/perpage+1;
				}
				if(request.getParameter("currentpage")!=null){
					currentpage=Integer.parseInt(request.getParameter("currentpage"));
					if(currentpage<1){
						currentpage=1;
					}else if(currentpage>totalpage){
						currentpage=totalpage;
					}
				}
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				List list=hti.managerslist(perpage, currentpage);
				request.setAttribute("managerslist", list);
				request.setAttribute("managersperpage", perpage);
				request.setAttribute("managerscurrentpage", currentpage);
				request.setAttribute("managersdatacount", datacount);
				request.setAttribute("managerstotalpage", totalpage);
				request.setAttribute("managersshow", "managersshow");
				request.getRequestDispatcher("Fss//Houtai//managers.jsp").forward(request, response);
//				response.sendRedirect("Fss//Houtai//managers.jsp");
			}// ��Ա�����ı��Ա״̬
			else if(method.equals("managerscstatus")){
				String id=request.getParameter("id");
				String status=request.getParameter("status");
				if(hti.managerscstatus(id, status)){
					response.sendRedirect("hongtu?method=managersshow");
				}
			}// ��Ա����ɾ����Ա
			else if(method.equals("managersdelete")){
				String id=request.getParameter("id");
				if(hti.managersdelete(id)){
					response.sendRedirect("hongtu?method=managersshow");
				}
			}//��Ա������ӳ�Ա����
			else if(method.equals("managersadd")){
				SmartUpload su=new SmartUpload();
				su.initialize(getServletConfig(), request, response);
				try {
					String getface="333";
					su.upload();
					su.save("/face");
					Enumeration e=su.getFiles().getEnumeration();
					while(e.hasMoreElements()){
						File file=(File)e.nextElement();
						getface="face//"+file.getFileName(); 
					}
					String account=su.getRequest().getParameter("account");
					String pwd =su.getRequest().getParameter("pwd");
					String nickname=su.getRequest().getParameter("nickname");
					String face=getface;
					System.out.println(face);
					String sex =su.getRequest().getParameter("sex");
					Managers m=new Managers();
					m.setAccount(account);
					m.setPwd(pwd);
					m.setFace(face);
					m.setNickname(nickname);
					m.setSex(sex);
					m.setStatus(1);
					if(hti.managersaddcheck(m)){ 
						hti.managersadd(m);
						response.sendRedirect("hongtu?method=managersshow");
					}else{
						System.out.println("�˺��Ѵ��ڣ�");
					}
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
			}// ��Ա�������Ҫ�޸ĵĳ�Ա��ԭ����
			else if(method.equals("getmanagersinfo")){
				String id=request.getParameter("id");
				Managers m=hti.managersinfo(id);
				request.setAttribute("managersinfo", m);
				request.getRequestDispatcher("Fss//Houtai//alter//managersalter.jsp").forward(request, response);
//					response.sendRedirect("Fss//Houtai//alter//managersalter.jsp");
				
			}// ��Ա������Ա�����޸�
			else if(method.equals("managersalter")){
				request.setCharacterEncoding("iso-8859-1");
				SmartUpload su=new SmartUpload();
				su.initialize(getServletConfig(), request, response);
				try {
					String getface="333";
					su.upload();
					su.save("/face");
					Enumeration e=su.getFiles().getEnumeration();
					while(e.hasMoreElements()){
						File file=(File)e.nextElement();
						getface="face//"+file.getFileName(); 
					}
					String account=su.getRequest().getParameter("account");
					String pwd =su.getRequest().getParameter("pwd");
					String nickname=su.getRequest().getParameter("nickname");
					String face=getface;
					if(face.equals("face//")){
						face=su.getRequest().getParameter("face");
					}
					String id=su.getRequest().getParameter("id");
					String sex =su.getRequest().getParameter("sex");
					Managers m=new Managers();
					m.setId(Integer.parseInt(id));
					m.setAccount(account);
					m.setPwd(pwd);
					m.setFace(face);
					m.setNickname(nickname);
					m.setSex(sex);
					m.setStatus(1);
					if(hti.managersalter(m)){
						response.sendRedirect("hongtu?method=managersshow");
					}else{
						System.out.println("�޸�ʧ�ܣ�");
					}
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
				
			}//��Ա��������
			else if(method.equals("managerssearch")){
				int perpage=10;
				int currentpage=1;
				String search=request.getParameter("search");
				String searchvalue="";
				if(session.getAttribute("searchvalue")!=null){
					searchvalue=session.getAttribute("searchvalue").toString();
				}
				if(search!=null){
					session.removeAttribute("searchvalue");
				}
				if(searchvalue!=""&&search==null){
					search=session.getAttribute("searchvalue").toString();
				}
				String sql="(select * from managers where" +
				" id like '%"+search+"%' or account like '%"+search
				+"%' or nickname like '%"+search+"%' or pwd like '%"+search
				+"%' or sex like '%"+search+"%')";
				int datacount=hti.datacount(sql+"s");
				int totalpage=1;
				if(datacount%perpage==0){
					totalpage=datacount/perpage;
					if(datacount<=perpage){
						totalpage=1;
					}
				}else{
					totalpage=datacount/perpage+1;
				}
				if(request.getParameter("currentpage")!=null){
					currentpage=Integer.parseInt(request.getParameter("currentpage"));
					if(currentpage<1){
						currentpage=1;
					}else if(currentpage>totalpage){
						currentpage=totalpage;
					}
				}
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				
				List list=hti.managerssearchlist(perpage, currentpage,search);
				request.setAttribute("managerslist", list);
				request.setAttribute("managersperpage", perpage);
				request.setAttribute("managerscurrentpage", currentpage);
				request.setAttribute("managersdatacount", datacount);
				request.setAttribute("managerstotalpage", totalpage);
				session.setAttribute("searchvalue", search);
				session.setAttribute("managersshow", "managerssearchshow");
				request.getRequestDispatcher("Fss//Houtai//managers.jsp").forward(request, response);
//				response.sendRedirect("Fss//Houtai//managers.jsp");
			} //��Ա����ȫ��״̬�ı�					   
			else if(method.equals("allmanagerscstatus")){
				String ids=request.getParameter("id");
				String status =request.getParameter("status");
				String id[]=ids.split("-");
				for(int i=0;i<id.length;i++){
					 hti.managerscstatus(id[i], status);
				}
				response.sendRedirect("hongtu?method=managersshow");
			}
//TODO ��������������������������������������������������������������������2�������ǡ�������������������������������������������������������������������������������������
			// �������ǡ�������
			else if(method.equals("aboutusshow")){
				List list=hti.aboutusList();
				AboutUs a=(AboutUs) list.get(0);
				session.setAttribute("aboutuslist", a);
				response.sendRedirect("Fss//Houtai//aboutus.jsp");
			}// �������ǡ������ԭ����
			else if(method.equals("aboutusinfo")){
				String id=request.getParameter("id");
				AboutUs a=hti.aboutusinfo(id);
				request.setAttribute("aboutusinfo",a);
				request.getRequestDispatcher("Fss//Houtai//alter//aboutusalter.jsp").forward(request, response);
//				response.sendRedirect("Fss//Houtai//alter//aboutusalter.jsp");
			}//�������ǡ����޸�����
			else if(method.equals("aboutusalter")){
					AboutUs a=new AboutUs();
					String id=request.getParameter("id");
					String title=request.getParameter("title");
					String contents=request.getParameter("contents");
					a.setContents(contents);
					a.setTitle(title);
					a.setId(Integer.parseInt(id));
					if(hti.aboutusalter(a)){
						response.sendRedirect("hongtu?method=aboutusshow");
					}
			}
//TODO ��������������������������������������������������������������������3�γ̽��ܡ�������������������������������������������������������������������������������������
			// �γ̽��ܡ�������
			else if(method.equals("courseshow")){
				int perpage=10;
				int currentpage=1;
				int datacount=hti.datacount("coursedescription");
				int totalpage=1;
				if(datacount%perpage==0){
					totalpage=datacount/perpage;
					if(datacount<=perpage){
						totalpage=1;
					}
				}else{
					totalpage=datacount/perpage+1;
				}
				if(request.getParameter("currentpage")!=null){
					currentpage=Integer.parseInt(request.getParameter("currentpage"));
					if(currentpage<1){
						currentpage=1;
					}else if(currentpage>totalpage){
						currentpage=totalpage;
					}
				}
				List list=hti.courselist(perpage, currentpage);
				request.setAttribute("courselist", list);
				request.setAttribute("courseperpage", perpage);
				request.setAttribute("coursecurrentpage", currentpage);
				request.setAttribute("coursedatacount", datacount);
				request.setAttribute("coursetotalpage", totalpage);
				request.getRequestDispatcher("Fss//Houtai//course.jsp").forward(request, response);
//				response.sendRedirect("Fss//Houtai//course.jsp");
			}// �γ̽��ܡ����ı�״̬
			else if(method.equals("coursecstatus")){
				String id=request.getParameter("id");
				String status=request.getParameter("status");
				if(hti.coursecstatus(id, status)){
					response.sendRedirect("hongtu?method=courseshow");
				}
			}// �γ̽��ܡ���ɾ��
			 if(method.equals("coursedelete")){
				String id=request.getParameter("id");
				if(hti.coursedelete(id)){
					response.sendRedirect("hongtu?method=courseshow");
				}
			}//�γ̽��ܡ������
			else if(method.equals("courseadd")){
				SmartUpload su=new SmartUpload();
				su.initialize(getServletConfig(), request, response);
				try {
					String getimgs="333";
					su.upload();
					su.save("/face");
					Enumeration e=su.getFiles().getEnumeration();
					while(e.hasMoreElements()){
						File file=(File)e.nextElement();
						getimgs="face//"+file.getFileName(); 
					}
					String course=su.getRequest().getParameter("course");
					String detail =su.getRequest().getParameter("detail");
					String imgs=getimgs;
					CourseDescription c=new CourseDescription();
					c.setCourse(course);
					c.setDetail(detail);
					c.setImgs(imgs);
					c.setStatus(1);
					if(hti.courseadd(c)){ 
						response.sendRedirect("hongtu?method=courseshow");
					} else{
						System.out.println("���ʧ�ܣ�");
					}
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
			}// �γ̽��ܡ������Ҫ�޸ĵ�ԭ����
			else if(method.equals("getcourseinfo")){
				String id=request.getParameter("id");
				CourseDescription c=hti.courseinfo(id);
				request.setAttribute("courseinfo", c);
					request.getRequestDispatcher("Fss//Houtai//alter//coursealter.jsp").forward(request, response);
//					response.sendRedirect("Fss//Houtai//alter//coursealter.jsp");
				
			}// �γ̽��ܡ��������޸�
			else if(method.equals("coursealter")){
				SmartUpload su=new SmartUpload();
				su.initialize(getServletConfig(), request, response);
				try {
					String getimgs="333";
					su.upload();
					su.save("/face");
					Enumeration e=su.getFiles().getEnumeration();
					while(e.hasMoreElements()){
						File file=(File)e.nextElement();
						getimgs="face//"+file.getFileName(); 
					}
					String course=su.getRequest().getParameter("course");
					String detail =su.getRequest().getParameter("detail");
					String imgs=getimgs;
					if(imgs.equals("face//")){
						imgs=su.getRequest().getParameter("face");
					}
					String sex =su.getRequest().getParameter("sex");
					String id=su.getRequest().getParameter("id");
					CourseDescription c=new CourseDescription();
					c.setCourse(course);
					c.setDetail(detail);
					c.setImgs(imgs);
					c.setStatus(1);
					c.setId(Integer.parseInt(id));
					if(hti.coursealter(c)){
						response.sendRedirect("hongtu?method=courseshow");
					}else{
						System.out.println("�޸�ʧ�ܣ�");
					}
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
				
			}
//TODO������������������������������������������������������������������������4���Ŷ�̬����������������������������������������������������������������������������
			// ���Ŷ�̬��������
			else if(method.equals("newsshow")){
				int perpage=10;
				int currentpage=1;
				int datacount=hti.datacount("news");
				int totalpage=1;
				if(datacount%perpage==0){
					totalpage=datacount/perpage;
					if(datacount<=perpage){
						totalpage=1;
					}
				}else{
					totalpage=datacount/perpage+1;
				}
				if(request.getParameter("currentpage")!=null){
					currentpage=Integer.parseInt(request.getParameter("currentpage"));
					if(currentpage<1){
						currentpage=1;
					}else if(currentpage>totalpage){
						currentpage=totalpage;
					}
				}
				List list=hti.newslist(perpage, currentpage);
				session.setAttribute("newslist", list);
				session.setAttribute("newsperpage", perpage);
				session.setAttribute("newscurrentpage", currentpage);
				session.setAttribute("newsdatacount", datacount);
				session.setAttribute("newstotalpage", totalpage);
				response.sendRedirect("Fss//Houtai//news.jsp");
			}// ���Ŷ�̬�����ı�״̬
			else if(method.equals("newscstatus")){
				String id=request.getParameter("id");
				String status=request.getParameter("status");
				if(hti.newscstatus(id, status)){
					response.sendRedirect("hongtu?method=newsshow");
				}
			}// ���Ŷ�̬����ɾ��
			 if(method.equals("newsdelete")){
				String id=request.getParameter("id");
				if(hti.newsdelete(id)){
					response.sendRedirect("hongtu?method=newsshow");
				}
			}//���Ŷ�̬������������
			else if(method.equals("newsadd")){
					String title=request.getParameter("title");
					String contents =request.getParameter("contents");
					String ctime =request.getParameter("ctime");
					News n=new News();
					n.setContents(contents);
					n.setCtime(ctime);
					n.setTitle(title);
					n.setStatus(0);
					if(hti.newsadd(n)){ 
						response.sendRedirect("hongtu?method=newsshow");
					} else{
						System.out.println("���ʧ�ܣ�");
					}
				 
			}// ���Ŷ�̬�������Ҫ�޸ĵ�ԭ����
			else if(method.equals("getnewsinfo")){
				String id=request.getParameter("id");
				News c=hti.newsinfo(id);
					session.setAttribute("newsinfo", c);
					response.sendRedirect("Fss//Houtai//alter//newsalter.jsp");
				
			}//���Ŷ�̬���������޸�
			else if(method.equals("newsalter")){	
				String id=request.getParameter("id");
				String title=request.getParameter("title");
				String contents =request.getParameter("contents");
				String ctime =request.getParameter("ctime");
				News n=new News();
				n.setId(Integer.parseInt(id));
				n.setContents(contents);
				n.setCtime(ctime);
				n.setTitle(title);
				n.setStatus(0);
					if(hti.newsalter(n)){
						response.sendRedirect("hongtu?method=newsshow");
					}else{
						System.out.println("�޸�ʧ�ܣ�");
					}
			}//���Ŷ�̬�����鿴����
			else if(method.equals("readnews")){
				String id=request.getParameter("id");
				String readnews=hti.readnews(id);
				request.setAttribute("readnews", readnews);
				request.getRequestDispatcher("Fss//Houtai//readnews.jsp").forward(request, response);
			}
//TODO ��������������������������������������������������������������������5��ҵ���ǡ�������������������������������������������������������������������������������������
			// ��ҵ���ǡ�������
			else if(method.equals("studentsshow")){
				int perpage=10;
				int currentpage=1;
				int datacount=hti.datacount("students");
				int totalpage=1;
				if(datacount%perpage==0){
					totalpage=datacount/perpage;
					if(datacount<=perpage){
						totalpage=1;
					}
				}else{
					totalpage=datacount/perpage+1;
				}
				if(request.getParameter("currentpage")!=null){
					currentpage=Integer.parseInt(request.getParameter("currentpage"));
					if(currentpage<1){
						currentpage=1;
					}else if(currentpage>totalpage){
						currentpage=totalpage;
					}
				}
				List list=hti.studentslist(perpage, currentpage);
				session.setAttribute("studentslist", list);
				session.setAttribute("studentsperpage", perpage);
				session.setAttribute("studentscurrentpage", currentpage);
				session.setAttribute("studentsdatacount", datacount);
				session.setAttribute("studentstotalpage", totalpage);
				response.sendRedirect("Fss//Houtai//students.jsp");
			}// ��ҵ���ǡ����ı�״̬
			else if(method.equals("studentscstatus")){
				String id=request.getParameter("id");
				String status=request.getParameter("status");
				if(hti.studentscstatus(id, status)){
					response.sendRedirect("hongtu?method=studentsshow");
				}
			}// ��ҵ���ǡ���ɾ��
			 if(method.equals("studentsdelete")){
				String id=request.getParameter("id");
				if(hti.studentsdelete(id)){
					response.sendRedirect("hongtu?method=studentsshow");
				}
			}//��ҵ���ǡ�����������
			else if(method.equals("studentsadd")){
				SmartUpload su=new SmartUpload();
				su.initialize(getServletConfig(), request, response);
				try {
					String getimgs="333";
					su.upload();
					su.save("/face");
					Enumeration e=su.getFiles().getEnumeration();
					while(e.hasMoreElements()){
						File file=(File)e.nextElement();
						getimgs="face//"+file.getFileName(); 
					}
					String imgs=getimgs;
					String name=su.getRequest().getParameter("name");
					String graduation=su.getRequest().getParameter("graduation");
					String salary=su.getRequest().getParameter("salary");
					String home=su.getRequest().getParameter("home");
					String takeoffice=su.getRequest().getParameter("takeoffice");
					Students s=new Students();
					System.out.println(name);
					s.setImgs(imgs);
					s.setStatus(1);
					s.setGraduation(graduation);
					s.setHome(home);
					s.setTakeoffice(takeoffice);
					s.setSalary(Float.parseFloat(salary));
					s.setName(name);
					if(hti.studentsadd(s)){ 
						response.sendRedirect("hongtu?method=studentsshow");
					} else{
						System.out.println("���ʧ�ܣ�");
					}
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
			}// ��ҵ���ǡ������Ҫ�޸ĵ�ԭ����
			else if(method.equals("getstudentsinfo")){
				String id=request.getParameter("id");
				Students s=hti.studentsinfo(id);
					session.setAttribute("studentsinfo", s);
					response.sendRedirect("Fss//Houtai//alter//studentsalter.jsp");
				
			}//��ҵ���ǡ��������޸�
			else if(method.equals("studentsalter")){	
				SmartUpload su=new SmartUpload();
				su.initialize(getServletConfig(), request, response);
				try {
					String getimgs="333";
					su.upload();
					su.save("/face");
					Enumeration e=su.getFiles().getEnumeration();
					while(e.hasMoreElements()){
						File file=(File)e.nextElement();
						getimgs="face//"+file.getFileName(); 
					}
					String imgs=getimgs;
					if(imgs.equals("face//")){
						imgs=su.getRequest().getParameter("face");
					}
					Students s=new Students();
					String id=su.getRequest().getParameter("id");
					String graduation=su.getRequest().getParameter("graduation");
					String salary=su.getRequest().getParameter("salary");
					String home=su.getRequest().getParameter("home");
					String takeoffice=su.getRequest().getParameter("takeoffice");
					String name=su.getRequest().getParameter("name");
					s.setId(Integer.parseInt(id));
					s.setImgs(imgs);
					s.setGraduation(graduation);
					s.setHome(home);
					s.setTakeoffice(takeoffice);
					s.setSalary(Float.parseFloat(salary));
					s.setName(name);
					if(hti.studentsalter(s)){ 
						response.sendRedirect("hongtu?method=studentsshow");
					} else{
						System.out.println("���ʧ�ܣ�");
					}
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
			}
//TODO ��������������������������������������������������������������������6ʦ��������������������������������������������������������������������������������������������
				// ʦ��������������
				else if(method.equals("teachersshow")){
					int perpage=10;
					int currentpage=1;
					int datacount=hti.datacount("teachers");
					int totalpage=1;
					if(datacount%perpage==0){
						totalpage=datacount/perpage;
						if(datacount<=perpage){
							totalpage=1;
						}
					}else{
						totalpage=datacount/perpage+1;
					}
					if(request.getParameter("currentpage")!=null){
						currentpage=Integer.parseInt(request.getParameter("currentpage"));
						if(currentpage<1){
							currentpage=1;
						}else if(currentpage>totalpage){
							currentpage=totalpage;
						}
					}
					List list=hti.teacherslist(perpage, currentpage);
					session.setAttribute("teacherslist", list);
					session.setAttribute("teachersperpage", perpage);
					session.setAttribute("teacherscurrentpage", currentpage);
					session.setAttribute("teachersdatacount", datacount);
					session.setAttribute("teacherstotalpage", totalpage);
					response.sendRedirect("Fss//Houtai//teachers.jsp");
				}// ʦ�����������ı�״̬
				else if(method.equals("teacherscstatus")){
					String id=request.getParameter("id");
					String status=request.getParameter("status");
					if(hti.teacherscstatus(id, status)){
						response.sendRedirect("hongtu?method=teachersshow");
					}
				}// ʦ����������ɾ��
				 if(method.equals("teachersdelete")){
					String id=request.getParameter("id");
					if(hti.teachersdelete(id)){
						response.sendRedirect("hongtu?method=teachersshow");
					}
				}//ʦ������������������
				else if(method.equals("teachersadd")){
					SmartUpload su=new SmartUpload();
					su.initialize(getServletConfig(), request, response);
					try {
						String getimgs="333";
						su.upload();
						su.save("/face");
						Enumeration e=su.getFiles().getEnumeration();
						while(e.hasMoreElements()){
							File file=(File)e.nextElement();
							getimgs="face//"+file.getFileName(); 
						}
						String name =su.getRequest().getParameter("name");
						String detail =su.getRequest().getParameter("detail");
						String imgs=getimgs;
						Teachers t=new Teachers();
						t.setImgs(imgs);
						t.setStatus(1);
						t.setName(name);
						t.setDetail(detail);
						if(hti.teachersadd(t)){ 
							response.sendRedirect("hongtu?method=teachersshow");
						} else{
							System.out.println("���ʧ�ܣ�");
						}
					} catch (SmartUploadException e) {
						e.printStackTrace();
					}
				}// ʦ�������������Ҫ�޸ĵ�ԭ����
				else if(method.equals("getteachersinfo")){
					String id=request.getParameter("id");
					Teachers t=hti.teachersinfo(id);
						session.setAttribute("teachersinfo", t);
						response.sendRedirect("Fss//Houtai//alter//teachersalter.jsp");
					
				}//ʦ���������������޸�
				else if(method.equals("teachersalter")){	
					SmartUpload su=new SmartUpload();
					su.initialize(getServletConfig(), request, response);
					try {
						String getimgs="333";
						su.upload();
						su.save("/face");
						Enumeration e=su.getFiles().getEnumeration();
						while(e.hasMoreElements()){
							File file=(File)e.nextElement();
							getimgs="face//"+file.getFileName(); 
						}
						String name =su.getRequest().getParameter("name");
						String detail =su.getRequest().getParameter("detail");
						String imgs=getimgs;
						if(imgs.equals("face//")){
							imgs=su.getRequest().getParameter("face");
						}
						Teachers t=new Teachers();
						String id=su.getRequest().getParameter("id");
						t.setId(Integer.parseInt(id));
						t.setImgs(imgs);
						t.setStatus(1);
						t.setName(name);
						t.setDetail(detail);
						if(hti.teachersalter(t)){ 
							response.sendRedirect("hongtu?method=teachersshow");
						} else{
							System.out.println("���ʧ�ܣ�");
						}
					} catch (SmartUploadException e) {
						e.printStackTrace();
					}
				}
//TODO��������������������������������������������������������������������������7 ���԰�顪����������������������������������������������������������
					// ���԰�顪������
				else if(method.equals("messageboardshow")){
					int perpage=10;
					int currentpage=1;
					int datacount=hti.datacount("messageboard");
					int totalpage=1;
					if(datacount%perpage==0){
						totalpage=datacount/perpage;
						if(datacount<=perpage){
							totalpage=1;
						}
					}else{
						totalpage=datacount/perpage+1;
					}
					if(request.getParameter("currentpage")!=null){
						currentpage=Integer.parseInt(request.getParameter("currentpage"));
						if(currentpage<1){
							currentpage=1;
						}else if(currentpage>totalpage){
							currentpage=totalpage;
						}
					}
					List list=hti.messageboardlist(perpage, currentpage);
					session.setAttribute("messageboardlist", list);
					session.setAttribute("messageboardperpage", perpage);
					session.setAttribute("messageboardcurrentpage", currentpage);
					session.setAttribute("messageboarddatacount", datacount);
					session.setAttribute("messageboardtotalpage", totalpage);
					response.sendRedirect("Fss//Houtai//messageboard.jsp");
				}//���԰�顪���ı�״̬
				else if(method.equals("messageboardcstatus")){
					String id=request.getParameter("id");
					String status=request.getParameter("status");
					if(hti.messageboardcstatus(id, status)){
						response.sendRedirect("hongtu?method=messageboardshow");
					}
				}// ���԰�顪��ɾ��
				 if(method.equals("messageboarddelete")){
					String id=request.getParameter("id");
					if(hti.messageboarddelete(id)){
						response.sendRedirect("hongtu?method=messageboardshow");
					}
				}//���԰�顪�����
				else if(method.equals("messageboardadd")){
					MessageBoard m=new MessageBoard();
					m.setContents(request.getParameter("contents"));
					Date d=new Date();
					m.setCtime(d.toLocaleString());
					m.setEmail(request.getParameter("email"));
					m.setNickname(request.getParameter("nickname"));
					m.setStatus(0);
					m.setTel(request.getParameter("tel"));
					if(hti.messageboardadd(m)){ 
						response.sendRedirect("main.jsp");
					}else{
						System.out.println("���ʧ�ܣ�");
					}
				}// ���԰�顪�����Ҫ�޸ĵ�ԭ����
				else if(method.equals("getmessageboardinfo")){
					String id=request.getParameter("id");
					MessageBoard c=hti.messageboardinfo(id);
						session.setAttribute("messageboardinfo", c);
						response.sendRedirect("Fss//Houtai//alter//messageboardalter.jsp");
					
				}// ���԰�顪�������޸�
				else if(method.equals("messageboardalter")){
					MessageBoard m=new MessageBoard();
					m.setContents(request.getParameter("contents"));
					m.setCtime(request.getParameter("ctime"));
					m.setEmail(request.getParameter("email"));
					m.setNickname(request.getParameter("nickname"));
					m.setTel(request.getParameter("tel"));
					m.setId(Integer.parseInt(request.getParameter("id")));
					if(hti.messageboardalter(m)){ 
						response.sendRedirect("hongtu?method=messageboardshow");
					}else{
						System.out.println("�޸�ʧ�ܣ�");
					}
				}		 
//TODO��������������������������������������������������������������������������8 ���Իظ�������������������������������������������������������������
					// ���Իظ���������
				else if(method.equals("messagereplyshow")){
					int perpage=10;
					int currentpage=1;
					int datacount=hti.datacount("messagereply");
					int totalpage=1;
					if(datacount%perpage==0){
						totalpage=datacount/perpage;
						if(datacount<=perpage){
							totalpage=1;
						}
					}else{
						totalpage=datacount/perpage+1;
					}
					if(request.getParameter("currentpage")!=null){
						currentpage=Integer.parseInt(request.getParameter("currentpage"));
						if(currentpage<1){
							currentpage=1;
						}else if(currentpage>totalpage){
							currentpage=totalpage;
						}
					}
					List list=hti.messagereplylist(perpage, currentpage);
					session.setAttribute("messagereplylist", list);
					session.setAttribute("messagereplyperpage", perpage);
					session.setAttribute("messagereplycurrentpage", currentpage);
					session.setAttribute("messagereplydatacount", datacount);
					session.setAttribute("messagereplytotalpage", totalpage);
					response.sendRedirect("Fss//Houtai//messagereply.jsp");
				}//���Իظ������ı�״̬
				else if(method.equals("messagereplycstatus")){
					String id=request.getParameter("id");
					String status=request.getParameter("status");
					if(hti.messagereplycstatus(id, status)){
						response.sendRedirect("hongtu?method=messagereplyshow");
					}
				}// ���Իظ�����ɾ��
				 if(method.equals("messagereplydelete")){
					String id=request.getParameter("id");
					if(hti.messagereplydelete(id)){
						response.sendRedirect("hongtu?method=messagereplyshow");
					}
				}//���Իظ���
					else if(method.equals("messagereplyadd")){
						String rid=request.getParameter("rid");
						 request.setAttribute("rid", rid);
						 request.getRequestDispatcher("Fss//Houtai//add//messagereplyadd.jsp").forward(request, response);
					}//���Իظ��������
				else if(method.equals("messagereplyadded")){
					MessageReply m=new MessageReply();
					m.setContents(request.getParameter("contents"));
					Date d=new Date();
					m.setCtime(d.toLocaleString());
					m.setStatus(1); 
					Managers ma=(Managers)session.getAttribute("managers");
					m.setNickname(ma.getNickname());
					m.setRid(Integer.parseInt(request.getParameter("rid")));
					m.setEmail("��");
					m.setTel("��");
					if(hti.messagereplyadd(m)){ 
						response.sendRedirect("hongtu?method=messagereplyshow");
					}else{
						System.out.println("���ʧ�ܣ�");
					}
				}// ���Իظ��������Ҫ�޸ĵ�ԭ����
				else if(method.equals("getmessagereplyinfo")){
					String id=request.getParameter("id");
					MessageReply c=hti.messagereplyinfo(id);
						session.setAttribute("messagereplyinfo", c);
						response.sendRedirect("Fss//Houtai//alter//messagereplyalter.jsp");
				}// ���Իظ����������޸�
				else if(method.equals("messagereplyalter")){
					MessageReply m=new MessageReply();
					m.setContents(request.getParameter("contents"));
					m.setCtime(request.getParameter("ctime"));
					m.setEmail(request.getParameter("email"));
					m.setNickname(request.getParameter("nickname"));
					m.setRid(Integer.parseInt(request.getParameter("rid")));
					m.setTel(request.getParameter("nickname"));
					m.setId(Integer.parseInt(request.getParameter("id")));
					if(hti.messagereplyalter(m)){ 
						response.sendRedirect("hongtu?method=messagereplyshow");
					}else{
						System.out.println("�޸�ʧ�ܣ�");
					}
				}		 
//TODO��������������������������������������������������������������������������9 Ԥ������������������������������������������������������������������
				// Ԥ��������������
				else if(method.equals("plansignupshow")){
					int perpage=10;
					int currentpage=1;
					int datacount=hti.datacount("plansignup");
					int totalpage=1;
					if(datacount%perpage==0){
						totalpage=datacount/perpage;
						if(datacount<=perpage){
							totalpage=1;
						}
					}else{
						totalpage=datacount/perpage+1;
					}
					if(request.getParameter("currentpage")!=null){
						currentpage=Integer.parseInt(request.getParameter("currentpage"));
						if(currentpage<1){
							currentpage=1;
						}else if(currentpage>totalpage){
							currentpage=totalpage;
						}
					}
					List list=hti.plansignuplist(perpage, currentpage);
					session.setAttribute("plansignuplist", list);
					session.setAttribute("plansignupperpage", perpage);
					session.setAttribute("plansignupcurrentpage", currentpage);
					session.setAttribute("plansignupdatacount", datacount);
					session.setAttribute("plansignuptotalpage", totalpage);
					response.sendRedirect("Fss//Houtai//plansignup.jsp");
				}// Ԥ�����������ı�״̬
				else if(method.equals("plansignupcstatus")){
					String id=request.getParameter("id");
					String status=request.getParameter("status");
					if(hti.plansignupcstatus(id, status)){
						response.sendRedirect("hongtu?method=plansignupshow");
					}
				}// Ԥ����������ɾ��
				 if(method.equals("plansignupdelete")){
					String id=request.getParameter("id");
					if(hti.plansignupdelete(id)){
						response.sendRedirect("hongtu?method=plansignupshow");
					}
				}//Ԥ�������������
				else if(method.equals("plansignupadd")){
					SmartUpload su=new SmartUpload();
					su.initialize(getServletConfig(), request, response);
					try {
						String getimgs="333";
						su.upload();
						su.save("/face");
						Enumeration e=su.getFiles().getEnumeration();
						while(e.hasMoreElements()){
							File file=(File)e.nextElement();
							getimgs="face//"+file.getFileName(); 
						}
						String contents=su.getRequest().getParameter("contents");
						String price =su.getRequest().getParameter("price");
						String title =su.getRequest().getParameter("title");
						String imgs=getimgs;
						PlanSignUp c=new PlanSignUp();
						c.setContents(contents);
						c.setPrice(Float.parseFloat(price));
						c.setTitle(title);
						c.setImgs(imgs);
						c.setStatus(1);
						if(hti.plansignupadd(c)){ 
							response.sendRedirect("hongtu?method=plansignupshow");
						} else{
							System.out.println("���ʧ�ܣ�");
						}
					} catch (SmartUploadException e) {
						e.printStackTrace();
					}
				}//Ԥ�������������Ҫ�޸ĵ�ԭ����
				else if(method.equals("getplansignupinfo")){
					String id=request.getParameter("id");
					PlanSignUp c=hti.plansignupinfo(id);
						session.setAttribute("plansignupinfo", c);
						response.sendRedirect("Fss//Houtai//alter//plansignupalter.jsp");
				}// Ԥ���������������޸�
				else if(method.equals("plansignupalter")){
					SmartUpload su=new SmartUpload();
					su.initialize(getServletConfig(), request, response);
					try {
						String getimgs="333";
						su.upload();
						su.save("/face");
						Enumeration e=su.getFiles().getEnumeration();
						while(e.hasMoreElements()){
							File file=(File)e.nextElement();
							getimgs="face//"+file.getFileName(); 
						}
						String contents=su.getRequest().getParameter("contents");
						String id=su.getRequest().getParameter("id");
						String price =su.getRequest().getParameter("price");
						String title =su.getRequest().getParameter("title");
						String imgs=getimgs;
						if(imgs.equals("face//")){
							imgs=su.getRequest().getParameter("face");
						}
						PlanSignUp c=new PlanSignUp();
						c.setContents(contents);
						c.setPrice(Float.parseFloat(price));
						c.setTitle(title);
						c.setId(Integer.parseInt(id));
						c.setImgs(imgs);
						c.setStatus(1);
						if(hti.plansignupalter(c)){
							response.sendRedirect("hongtu?method=plansignupshow");
						}else{
							System.out.println("�޸�ʧ�ܣ�");
						}
					} catch (SmartUploadException e) {
						e.printStackTrace();
					}
					
				}	 
//TODO��������������������������������������������������������������������������10 �������������������������������������������������������������������
				// ���������������
				else if(method.equals("signupshow")){
					int perpage=10;
					int currentpage=1;
					int datacount=hti.datacount("signup");
					int totalpage=1;
					if(datacount%perpage==0){
						totalpage=datacount/perpage;
						if(datacount<=perpage){
							totalpage=1;
						}
					}else{
						totalpage=datacount/perpage+1;
					}
					if(request.getParameter("currentpage")!=null){
						currentpage=Integer.parseInt(request.getParameter("currentpage"));
						if(currentpage<1){
							currentpage=1;
						}else if(currentpage>totalpage){
							currentpage=totalpage;
						}
					}
					List list=hti.signuplist(perpage, currentpage);
					session.setAttribute("signuplist", list);
					session.setAttribute("signupperpage", perpage);
					session.setAttribute("signupcurrentpage", currentpage);
					session.setAttribute("signupdatacount", datacount);
					session.setAttribute("signuptotalpage", totalpage);
					response.sendRedirect("Fss//Houtai//signup.jsp");
				}//����Ԥ����������
				else if(method.equals("signup")){
					String id=request.getParameter("id");
					PlanSignUp p=hti.tosignup(id);
					request.setAttribute("list", p);
					request.getRequestDispatcher("signup.jsp").forward(request, response);
				}//��������������
				else if(method.equals("signupadd")){
						String tel =request.getParameter("tel");
						String name =request.getParameter("name");
						String pid =request.getParameter("id");
						SignUp c=new SignUp();
						Date d=new Date();
						String ctime=d.toLocaleString();
						c.setCtime(ctime);
						c.setName(name);
						c.setTel(tel);
						c.setStatus(1);
						c.setPid(Integer.parseInt(pid));
						if(hti.signupadd(c)){
							request.setAttribute("reply", "�������ύ�������ĵȺ�");
							request.getRequestDispatcher("qt?method=czydbm").forward(request, response);	
						}else{
							System.out.println("ʧ��");
						}
				} //������������ı�״̬
				else if(method.equals("signupcstatus")){
					String id=request.getParameter("id");
					String status=request.getParameter("status");
					if(hti.signupcstatus(id, status)){
						response.sendRedirect("hongtu?method=signupshow");
					}
				}// �����������ɾ��
				 if(method.equals("signupdelete")){
					String id=request.getParameter("id");
					if(hti.signupdelete(id)){
						response.sendRedirect("hongtu?method=signupshow");
					}
				}
//TODO ������������������������������������������������������������������������11ѧУ�������������������������������������������������������������������������������
					// ѧУ���������
					else if(method.equals("activityshow")){
						int perpage=10;
						int currentpage=1;
						int datacount=hti.datacount("activity");
						int totalpage=1;
						if(datacount%perpage==0){
							totalpage=datacount/perpage;
							if(datacount<=perpage){
								totalpage=1;
							}
						}else{
							totalpage=datacount/perpage+1;
						}
						if(request.getParameter("currentpage")!=null){
							currentpage=Integer.parseInt(request.getParameter("currentpage"));
							if(currentpage<1){
								currentpage=1;
							}else if(currentpage>totalpage){
								currentpage=totalpage;
							}
						}
						List list=hti.activitylist(perpage, currentpage);
						request.setAttribute("activitylist", list);
						request.setAttribute("activityperpage", perpage);
						request.setAttribute("activitycurrentpage", currentpage);
						request.setAttribute("activitydatacount", datacount);
						request.setAttribute("activitytotalpage", totalpage);
						request.getRequestDispatcher("Fss//Houtai//activity.jsp").forward(request, response);
					}// ѧУ������ı�״̬
					else if(method.equals("activitycstatus")){
						String id=request.getParameter("id");
						String status=request.getParameter("status");
						if(hti.activitycstatus(id, status)){
							response.sendRedirect("hongtu?method=activityshow");
						}
					}// ѧУ�����ɾ��
					 if(method.equals("nactivitydelete")){
						String id=request.getParameter("id");
						if(hti.activitydelete(id)){
							response.sendRedirect("hongtu?method=activityshow");
						}
					}//ѧУ�������������
					else if(method.equals("activityadd")){
						SmartUpload su=new SmartUpload();
						su.initialize(getServletConfig(), request, response);
						try {
							String getimgs="333";
							su.upload();
							su.save("/face");
							Enumeration e=su.getFiles().getEnumeration();
							while(e.hasMoreElements()){
								File file=(File)e.nextElement();
								getimgs="face//"+file.getFileName(); 
							}
							String title =su.getRequest().getParameter("title");
							String imgs=getimgs;
							
							Activity a=new Activity();
							a.setImgs(imgs);
							a.setStatus(1);
							a.setTitle(title);
							if(hti.activityadd(a)){ 
								response.sendRedirect("hongtu?method=activityshow");
							} else{
								System.out.println("���ʧ�ܣ�");
							}
						} catch (SmartUploadException e) {
							e.printStackTrace();
						}
					}// ѧУ��������Ҫ�޸ĵ�ԭ����
					else if(method.equals("getactivityinfo")){
						String id=request.getParameter("id");
						Activity a=hti.activityinfo(id);
							session.setAttribute("activityinfo", a);
							response.sendRedirect("Fss//Houtai//alter//activityalter.jsp");
						
					}//ѧУ����������޸�
					else if(method.equals("activityalter")){	
						SmartUpload su=new SmartUpload();
						su.initialize(getServletConfig(), request, response);
						try {
							String getimgs="333";
							su.upload();
							su.save("/face");
							Enumeration e=su.getFiles().getEnumeration();
							while(e.hasMoreElements()){
								File file=(File)e.nextElement();
								getimgs="face//"+file.getFileName(); 
							}
							String title =su.getRequest().getParameter("title");
							String imgs=getimgs;
							if(imgs.equals("face//")){
								imgs=su.getRequest().getParameter("face");
							}
							Activity a=new Activity();
							String id=su.getRequest().getParameter("id");
							a.setId(Integer.parseInt(id));
							a.setImgs(imgs);
							a.setStatus(1);
							a.setTitle(title);
							if(hti.activityalter(a)){ 
								response.sendRedirect("hongtu?method=activityshow");
							} else{
								System.out.println("���ʧ�ܣ�");
							}
						} catch (SmartUploadException e) {
							e.printStackTrace();
						}
					} 
//TODO������������������������������������������������������������������������12ѧУ��������������������������������������������������������������������������������
						// ѧУ������������
					else if(method.equals("environmentshow")){
						int perpage=10;
						int currentpage=1;
						int datacount=hti.datacount("environment");
						int totalpage=1;
						if(datacount%perpage==0){
							totalpage=datacount/perpage;
							if(datacount<=perpage){
								totalpage=1;
							}
						}else{
							totalpage=datacount/perpage+1;
						}
						if(request.getParameter("currentpage")!=null){
							currentpage=Integer.parseInt(request.getParameter("currentpage"));
							if(currentpage<1){
								currentpage=1;
							}else if(currentpage>totalpage){
								currentpage=totalpage;
							}
						}
						List list=hti.environmentlist(perpage, currentpage);
						session.setAttribute("environmentlist", list);
						session.setAttribute("environmentperpage", perpage);
						session.setAttribute("environmentcurrentpage", currentpage);
						session.setAttribute("environmentdatacount", datacount);
						session.setAttribute("environmenttotalpage", totalpage);
						response.sendRedirect("Fss//Houtai//environment.jsp");
					}// ѧУ���������ı�״̬
					else if(method.equals("environmentcstatus")){
						String id=request.getParameter("id");
						String status=request.getParameter("status");
						if(hti.environmentcstatus(id, status)){
							response.sendRedirect("hongtu?method=environmentshow");
						}
					}// ѧУ��������ɾ��
					 if(method.equals("environmentdelete")){
						String id=request.getParameter("id");
						if(hti.environmentdelete(id)){
							response.sendRedirect("hongtu?method=environmentshow");
						}
					}//ѧУ����������������
					else if(method.equals("environmentadd")){
						SmartUpload su=new SmartUpload();
						su.initialize(getServletConfig(), request, response);
						try {
							String getimgs="333";
							su.upload();
							su.save("/face");
							Enumeration e=su.getFiles().getEnumeration();
							while(e.hasMoreElements()){
								File file=(File)e.nextElement();
								getimgs="face//"+file.getFileName(); 
							}
							String title =su.getRequest().getParameter("title");
							String imgs=getimgs;
							Environment a=new Environment();
							a.setImgs(imgs);
							a.setStatus(1);
							a.setTitle(title);
							if(hti.environmentadd(a)){ 
								response.sendRedirect("hongtu?method=environmentshow");
							} else{
								System.out.println("���ʧ�ܣ�");
							}
						} catch (SmartUploadException e) {
							e.printStackTrace();
						}
					}// ѧУ�����������Ҫ�޸ĵ�ԭ����
					else if(method.equals("getenvironmentinfo")){
						String id=request.getParameter("id");
						Environment a=hti.environmentinfo(id);
							session.setAttribute("environmentinfo", a);
							response.sendRedirect("Fss//Houtai//alter//environmentalter.jsp");
						
					}//ѧУ�������������޸�
					else if(method.equals("environmentalter")){	
						SmartUpload su=new SmartUpload();
						su.initialize(getServletConfig(), request, response);
						try {
							String getimgs="333";
							su.upload();
							su.save("/face");
							Enumeration e=su.getFiles().getEnumeration();
							while(e.hasMoreElements()){
								File file=(File)e.nextElement();
								getimgs="face//"+file.getFileName(); 
							}
							String title =su.getRequest().getParameter("title");
							String imgs=getimgs;
							if(imgs.equals("face//")){
								imgs=su.getRequest().getParameter("face");
							}
							Environment a=new Environment();
							String id=su.getRequest().getParameter("id");
							a.setId(Integer.parseInt(id));
							a.setImgs(imgs);
							a.setStatus(1);
							a.setTitle(title);
							if(hti.environmentalter(a)){ 
								response.sendRedirect("hongtu?method=environmentshow");
							} else{
								System.out.println("���ʧ�ܣ�");
							}
						} catch (SmartUploadException e) {
							e.printStackTrace();
						}
					}
//TODO��������������������������������������������������������������������13��ҵѧ����ͼ����������������������������������������������������������������
						// ��ҵѧ����������
					else if(method.equals("graduationshow")){
						int perpage=10;
						int currentpage=1;
						int datacount=hti.datacount("graduationtable");
						int totalpage=1;
						if(datacount%perpage==0){
							totalpage=datacount/perpage;
							if(datacount<=perpage){
								totalpage=1;
							}
						}else{
							totalpage=datacount/perpage+1;
						}
						if(request.getParameter("currentpage")!=null){
							currentpage=Integer.parseInt(request.getParameter("currentpage"));
							if(currentpage<1){
								currentpage=1;
							}else if(currentpage>totalpage){
								currentpage=totalpage;
							}
						}
						List list=hti.graduationlist(perpage, currentpage);
						session.setAttribute("graduationlist", list);
						session.setAttribute("graduationperpage", perpage);
						session.setAttribute("graduationcurrentpage", currentpage);
						session.setAttribute("graduationdatacount", datacount);
						session.setAttribute("graduationtotalpage", totalpage);
						response.sendRedirect("Fss//Houtai//graduationtable.jsp");
					}// ��ҵѧ�������ı�״̬
					else if(method.equals("graduationcstatus")){
						String id=request.getParameter("id");
						String status=request.getParameter("status");
						if(hti.graduationcstatus(id, status)){
							response.sendRedirect("hongtu?method=graduationshow");
						}
					}// ��ҵѧ������ɾ��
					 if(method.equals("graduationdelete")){
						String id=request.getParameter("id");
						if(hti.graduationdelete(id)){
							response.sendRedirect("hongtu?method=graduationshow");
						}
					}//��ҵѧ��������������
					else if(method.equals("graduationadd")){
						SmartUpload su=new SmartUpload();
						su.initialize(getServletConfig(), request, response);
						try {
							String getimgs="333";
							su.upload();
							su.save("/face");
							Enumeration e=su.getFiles().getEnumeration();
							while(e.hasMoreElements()){
								File file=(File)e.nextElement();
								getimgs="face//"+file.getFileName(); 
							}
							String title =su.getRequest().getParameter("title");
							String imgs=getimgs;
							Graduationtable a=new Graduationtable();
							a.setImgs(imgs);
							a.setStatus(1);
							a.setTitle(title);
							if(hti.graduationadd(a)){ 
								response.sendRedirect("hongtu?method=graduationshow");
							} else{
								System.out.println("���ʧ�ܣ�");
							}
						} catch (SmartUploadException e) {
							e.printStackTrace();
						}
					}// ��ҵѧ���������Ҫ�޸ĵ�ԭ����
					else if(method.equals("getgraduationinfo")){
						String id=request.getParameter("id");
						Graduationtable a=hti.graduationinfo(id);
							session.setAttribute("graduationinfo", a);
							response.sendRedirect("Fss//Houtai//alter//graduationalter.jsp");
					}//��ҵѧ�����������޸�
					else if(method.equals("graduationalter")){	
						SmartUpload su=new SmartUpload();
						su.initialize(getServletConfig(), request, response);
						try {
							String getimgs="333";
							su.upload();
							su.save("/face");
							Enumeration e=su.getFiles().getEnumeration();
							while(e.hasMoreElements()){
								File file=(File)e.nextElement();
								getimgs="face//"+file.getFileName(); 
							}
							String title =su.getRequest().getParameter("title");
							String imgs=getimgs;
							if(imgs.equals("face//")){
								imgs=su.getRequest().getParameter("face");
							}
							Graduationtable a=new Graduationtable();
							String id=su.getRequest().getParameter("id");
							a.setId(Integer.parseInt(id));
							a.setImgs(imgs);
							a.setStatus(1);
							a.setTitle(title);
							if(hti.graduationalter(a)){ 
								response.sendRedirect("hongtu?method=graduationshow");
							} else{
								System.out.println("���ʧ�ܣ�");
							}
						} catch (SmartUploadException e) {
							e.printStackTrace();
						}
					} 
//TODO��������������������������������������������������������������������������14��ϵ���ǡ�����������������������������������������������������������
						// ��ϵ���ǡ�������
					else if(method.equals("contactusshow")){
						List list=hti.contactuslist();
						ContactUs a=(ContactUs) list.get(0);
						session.setAttribute("contactuslist", a);
						response.sendRedirect("Fss//Houtai//contactus.jsp");
					}// ��ϵ���ǡ������ԭ����
					else if(method.equals("getcontactusinfo")){
						String id=request.getParameter("id");
						ContactUs a=hti.contactusinfo(id);
						session.setAttribute("contactusinfo",a);
						response.sendRedirect("Fss//Houtai//alter//contactusalter.jsp");
					}//��ϵ���ǡ����޸�����
					else if(method.equals("contactusalter")){
						ContactUs a=new ContactUs();
							String id=request.getParameter("id");
							String map=request.getParameter("map");
							String contents=request.getParameter("contents");
							a.setContents(contents);
							a.setMap(map);
							a.setId(Integer.parseInt(id));
							if(hti.contactusalter(a)){
								response.sendRedirect("hongtu?method=contactusshow");
							}
					}
//TODO ��������������������������������������������������������������������������������Ƶ��������������������������������������������������������������������
					 // ������Ƶ��������
					else if(method.equals("videoshow")){
						int perpage=10;
						int currentpage=1;
						int datacount=hti.datacount("video");
						int totalpage=1;
						if(datacount%perpage==0){
							totalpage=datacount/perpage;
							if(datacount<=perpage){
								totalpage=1;
							}
						}else{
							totalpage=datacount/perpage+1;
						}
						if(request.getParameter("currentpage")!=null){
							currentpage=Integer.parseInt(request.getParameter("currentpage"));
							if(currentpage<1){
								currentpage=1;
							}else if(currentpage>totalpage){
								currentpage=totalpage;
							}
						}
						List list=hti.videolist(perpage, currentpage);
						session.setAttribute("videolist", list);
						session.setAttribute("videoperpage", perpage);
						session.setAttribute("videocurrentpage", currentpage);
						session.setAttribute("videodatacount", datacount);
						session.setAttribute("videototalpage", totalpage);
						response.sendRedirect("Fss//Houtai//video.jsp");
					}// ������Ƶ�����ı�״̬
					else if(method.equals("videocstatus")){
						String id=request.getParameter("id");
						String status=request.getParameter("status");
						if(hti.videocstatus(id, status)){
							response.sendRedirect("hongtu?method=videoshow");
						}
					}// ������Ƶ����ɾ��
					 if(method.equals("videodelete")){
						String id=request.getParameter("id");
						if(hti.videodelete(id)){
							response.sendRedirect("hongtu?method=videoshow");
						}
					}//������Ƶ�������
					else if(method.equals("videoadd")){
						SmartUpload su=new SmartUpload();
						su.initialize(getServletConfig(), request, response);
						try {
							String getimgs="333";
							su.upload();
							su.save("/face");
							Enumeration e=su.getFiles().getEnumeration();
							while(e.hasMoreElements()){
								File file=(File)e.nextElement();
								getimgs="face//"+file.getFileName(); 
							}
							String title=su.getRequest().getParameter("title");
							String video=getimgs;
							Date d=new Date();
							String ctime=d.toLocaleString();
							edu.ht.Bean.video c=new video();
							c.setTitle(title);
							c.setVideo(video);
							c.setStatus(1);
							c.setCtime(ctime);
							if(hti.videoadd(c)){ 
								response.sendRedirect("hongtu?method=videoshow");
							} else{
								System.out.println("���ʧ�ܣ�");
							}
						} catch (SmartUploadException e) {
							e.printStackTrace();
						}
					}// ������Ƶ�������Ҫ�޸ĵ�ԭ����
					else if(method.equals("getvideoinfo")){
						String id=request.getParameter("id");
						video c=hti.videoinfo(id);
							session.setAttribute("videoinfo", c);
							response.sendRedirect("Fss//Houtai//alter//videoalter.jsp");
						
					}// ������Ƶ���������޸�
					else if(method.equals("videoalter")){
						SmartUpload su=new SmartUpload();
						su.initialize(getServletConfig(), request, response);
						try {
							String getimgs="333";
							su.upload();
							su.save("/face");
							Enumeration e=su.getFiles().getEnumeration();
							while(e.hasMoreElements()){
								File file=(File)e.nextElement();
								getimgs="face//"+file.getFileName(); 
							}
							String title=su.getRequest().getParameter("title");
							String ctime=su.getRequest().getParameter("ctime");
							String video=getimgs;
							String id=su.getRequest().getParameter("id");
							edu.ht.Bean.video c=new video();
							c.setTitle(title);
							c.setVideo(video);
							c.setId(Integer.parseInt(id));
							c.setStatus(1);
							c.setCtime(ctime);
							if(hti.videoalter(c)){ 
								response.sendRedirect("hongtu?method=videoshow");
							} else{
								System.out.println("���ʧ�ܣ�");
							}
						} catch (SmartUploadException e) {
							e.printStackTrace();
						}
					}
		}
	}
}
