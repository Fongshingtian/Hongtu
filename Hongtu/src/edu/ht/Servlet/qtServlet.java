package edu.ht.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ht.Bean.AboutUs;
import edu.ht.Bean.Activity;
import edu.ht.Bean.ContactUs;
import edu.ht.Bean.Environment;
import edu.ht.Bean.News;
import edu.ht.Bean.PlanSignUp;
import edu.ht.HtImplements.HtServiceImpl;
import edu.ht.HtInterface.HtService;


public class qtServlet extends HttpServlet{
	
	HtService hi = new HtServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		HttpSession session=request.getSession();
		if(method!=null){
			if(method.equals("main")){
				AboutUs aboutus =hi.getaboutus();
				List courselist=hi.czkcjs();
				List activitylist=hi.activitylist();
				List environmentlist=hi.environmentlist();
				List graduationlist=hi.graduationlist();
				List studentslist=hi.indexstudents();
				List teacherslist=hi.indexteachers();
				request.setAttribute("aboutus",aboutus);
				request.setAttribute("studentslist",studentslist);
				request.setAttribute("teacherslist",teacherslist );
				request.setAttribute("course1",courselist.get(0) );
				request.setAttribute("course2",courselist.get(1) );
				request.setAttribute("course3",courselist.get(2) );
				request.setAttribute("activitylist",activitylist );
				request.setAttribute("environmentlist",environmentlist );
				request.setAttribute("graduationlist",graduationlist );
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else if(method.equals("czkcjs")){ //�γ̽���
				List list=hi.czkcjs();
				request.setAttribute("courselist", list);
				request.getRequestDispatcher("kcjs.jsp").forward(request, response);
			}else if(method.equals("czjymx")){ //��ҵ����
				List list=hi.czjymx();
				request.setAttribute("courselist", list);
				request.getRequestDispatcher("jymx.jsp").forward(request, response);
			}else if(method.equals("czszll")){ //ʦ������
				List list=hi.czszll();
				request.setAttribute("courselist", list);
				request.getRequestDispatcher("szll.jsp").forward(request, response);
			}else if(method.equals("czxwdt")){ //���Ŷ�̬
				List list=hi.czxwdt();
				request.setAttribute("courselist", list);
				request.getRequestDispatcher("xwdt.jsp").forward(request, response);
			}else if(method.equals("czgywm")){ //��������
				AboutUs a=hi.getaboutus();
				request.setAttribute("AboutUs", a);
				request.getRequestDispatcher("gywm.jsp").forward(request, response);
			}else if(method.equals("czlyb")){ //���԰�
				Map map=hi.czlyb();
				int i=hi.getnewscount();
				request.setAttribute("message", map);
				request.setAttribute("count", i);
				request.getRequestDispatcher("lyb.jsp").forward(request, response);
			}else if(method.equals("czydbm")){ //Ԥ������
				List list=hi.czydbm();
				request.setAttribute("courselist", list);
				request.getRequestDispatcher("ydbm.jsp").forward(request, response);
			}else if(method.equals("readactivity")){ //ѧУ��鿴��ͼ
				String id=request.getParameter("id");
				Activity a=hi.readactivity(id);
				request.setAttribute("read", a);
				request.getRequestDispatcher("readactivity.jsp").forward(request, response);
			}else if(method.equals("readenvironment")){ //ѧУ�����鿴��ͼ
				String id=request.getParameter("id");
				Environment a=hi.readenvironment(id);
				request.setAttribute("read", a);
				request.getRequestDispatcher("readenvironment.jsp").forward(request, response);
			}else if(method.equals("lastactivity")){//ѧУ� ��һ��
				String id=request.getParameter("id");
				Activity a=hi.getlastactivity(id);
				if(a==null){
					Activity s=hi.readactivity(id);
					request.setAttribute("read", s);
					request.getRequestDispatcher("readactivity.jsp").forward(request, response);
					return;
				}
				request.setAttribute("read", a);
				request.getRequestDispatcher("readactivity.jsp").forward(request, response);
			}else if(method.equals("nextactivity")){//ѧУ� ��һ��
				String id=request.getParameter("id");
				Activity a=hi.getnextactivity(id);
				if(a==null){
					Activity s=hi.readactivity(id);
					request.setAttribute("read", s);
					request.getRequestDispatcher("readactivity.jsp").forward(request, response);
					return;
				}
				request.setAttribute("read", a);
				request.getRequestDispatcher("readactivity.jsp").forward(request, response);
			}else if(method.equals("lastenvironment")){//ѧУ���� ��һ��
				String id=request.getParameter("id");
				Environment a=hi.getlastenvironment(id);
				if(a==null){
					Environment s=hi.readenvironment(id);
					request.setAttribute("read", s);
					request.getRequestDispatcher("readenvironment.jsp").forward(request, response);
					return;
				}
				request.setAttribute("read", a);
				request.getRequestDispatcher("readenvironment.jsp").forward(request, response);
			}else if(method.equals("nextenvironment")){//ѧУ���� ��һ��
				String id=request.getParameter("id");
				Environment a=hi.getnextenvironment(id);
				if(a==null){
					Environment s=hi.readenvironment(id);
					request.setAttribute("read", s);
					request.getRequestDispatcher("readenvironment.jsp").forward(request, response);
					return;
				}
				request.setAttribute("read", a);
				request.getRequestDispatcher("readenvironment.jsp").forward(request, response);
			}else if(method.equals("czxw")){ //����
				String strid = request.getParameter("id");
				News news=hi.czxw(Integer.parseInt(strid));	
				request.setAttribute("news", news);
				request.getRequestDispatcher("xw1.jsp").forward(request, response);
			}else if(method.equals("czlxwm")){ //����
				ContactUs c=hi.getcontactus();	
				request.setAttribute("list", c);
				request.getRequestDispatcher("lxwm.jsp").forward(request, response);
			}else if(method.equals("tosignup")){
				String id=request.getParameter("id");
				PlanSignUp c=hi.tosignuo(id);
				request.setAttribute("c", c);
				request.getRequestDispatcher("signupadd.jsp").forward(request, response);
			}
		}
	}
}