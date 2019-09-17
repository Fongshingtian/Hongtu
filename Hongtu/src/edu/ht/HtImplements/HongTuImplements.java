package edu.ht.HtImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

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
import edu.ht.Common.JDBC;
import edu.ht.HtInterface.HongTuInterface;

public class HongTuImplements implements HongTuInterface{
//TODO ��ʼ��������������������������������������������������������������������������������������������������������������������������������������������������������������������
	// ��¼�����˺������Ƿ���ȷ
	public Managers logining(String account, String pwd) {
		Connection con=JDBC.getConnection();
		String sql="select * from managers where account=? and pwd=?"; 
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Managers m=new Managers();
				m.setAccount(rs.getString("account"));
				m.setFace(rs.getString("face"));
				m.setId(rs.getInt("id"));
				m.setNickname(rs.getString("nickname"));
				m.setPwd(rs.getString("pwd"));
				m.setSex(rs.getString("sex"));
				m.setStatus(rs.getInt("status"));
				rs.close();
				ps.close();
				con.close();
				return m;
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// ��ѯ�������ĳ�������������
	public int datacount(String tablename) {
		Connection con=JDBC.getConnection();
		String sql="select count(*) from "+tablename;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int i=rs.getInt(1);
				rs.close();
				ps.close();
				con.close();
				return i;
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
//TODO����������������������������������������������������������������������1��̨��Ա����������������������������������������������������������������������������������
	
	

	// ��Ա��������б�
	public List managerslist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from managers where id not in(select top "
		+(currentpage-1)*perpage+ " id from managers) and id !=1";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Managers m=new Managers();
				m.setAccount(rs.getString("account"));
				m.setPwd(rs.getString("pwd"));
				m.setId(rs.getInt("id"));
				m.setStatus(rs.getInt("status"));
				m.setFace(rs.getString("face"));
				m.setNickname(rs.getString("nickname"));
				m.setSex(rs.getString("sex"));
				list.add(m);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// ��Ա�����ı�״̬
	public boolean managerscstatus(String id,String status) {
		Connection con=JDBC.getConnection();
		String sql="update managers set status=? where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ��Ա����ɾ��
	public boolean managersdelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from managers where id="+id;
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ��Ա�����ж��˺��Ƿ����
	public boolean managersaddcheck(Managers m) {
		Connection con=JDBC.getConnection();
		String sql="select * from managers where account="+m.getAccount();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 rs.close();
				 ps.close();
				 con.close();
				 return false;
			 }
			 rs.close();
			 ps.close();
			 con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return true;
	}
	// ��Ա��������
	public boolean managersadd(Managers m) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into managers values(?,?,?,?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, m.getAccount());
			 ps.setString(2, m.getPwd());
			 ps.setString(3, m.getNickname());
			 ps.setString(4, m.getFace());
			 ps.setString(5, m.getSex());
			 ps.setInt(6, m.getStatus()); 
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//��Ա�������Ҫ�޸ĵ�ԭ����
	public Managers managersinfo(String id) {
		Managers m=new Managers();
		Connection con=JDBC.getConnection();
		 String sql="select * from managers where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 m.setId(rs.getInt("id"));
				 m.setStatus(rs.getInt("status"));
				 m.setAccount(rs.getString("account"));
				 m.setFace(rs.getString("face"));
				 m.setNickname(rs.getString("nickname"));
				 m.setPwd(rs.getString("pwd"));
				 m.setSex(rs.getString("sex"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	//��Ա�����޸�����
	public boolean managersalter(Managers m) {
		Connection con=JDBC.getConnection();
		 String sql="update managers set account=?,nickname=?,sex=?,face=?,pwd=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,m.getAccount());
			 ps.setString(2,m.getNickname());
			 ps.setString(3,m.getSex());
			 ps.setString(4,m.getFace());
			 ps.setString(5,m.getPwd());
			 ps.setInt(6,m.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ��Ա��������
	public List managerssearchlist(int perpage, int currentpage,String search) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from managers where" +
				" (id like '%"+search+"%' or account like '%"+search
				+"%' or nickname like '%"+search+"%' or pwd like '%"+search
				+"%' or sex like '%"+search+"%')"
				+" and (id not in(select top "+(currentpage-1)*perpage+
				" id from managers where id like '%"+search+"%' or account like '%"+search
				+"%' or nickname like '%"+search+"%' or pwd like '%"+search
				+"%' or sex like '%"+search+"%'))";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getInt("id")!=1){
					Managers m=new Managers();
					m.setAccount(rs.getString("account"));
					m.setPwd(rs.getString("pwd"));
					m.setId(rs.getInt("id"));
					m.setStatus(rs.getInt("status"));
					m.setFace(rs.getString("face"));
					m.setNickname(rs.getString("nickname"));
					m.setSex(rs.getString("sex"));
					list.add(m);
				}
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
//TODO������������������������������������������������������������������2�������ǡ���������������������������������������������������������������������������������

	
	
	// �������ǡ�������б�
	public List aboutusList() {
		Connection con=JDBC.getConnection();
		String sql="select * from aboutus ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				AboutUs a=new AboutUs();
				a.setId(rs.getInt("id"));
				a.setContents(rs.getString("contents"));
				a.setTitle(rs.getString("title"));
				list.add(a);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//�������ǡ������Ҫ�޸ĵ�ԭ����
	public AboutUs aboutusinfo(String id) {
		AboutUs a=new AboutUs();
		Connection con=JDBC.getConnection();
		 String sql="select * from aboutus where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				a.setId(rs.getInt("id"));
				a.setContents(rs.getString("contents"));
				a.setTitle(rs.getString("title"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	// �������ǡ����޸�����
	public boolean aboutusalter(AboutUs a) {
		 Connection con=JDBC.getConnection();
		 String sql="update aboutus set contents=?,title=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, a.getContents());
			ps.setString(2, a.getTitle());
			ps.setInt(3, a.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
//TODO����������������������������������������������������������������3�γ̽��ܡ���������������������������������������������������������������������������������
	// �γ̽��ܡ�������б�
	public List courselist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from CourseDescription where id not in(select top "+(currentpage-1)*perpage+ " id from coursedescription)";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CourseDescription c=new CourseDescription();
				c.setDetail(rs.getString("detail"));
				c.setId(rs.getInt("id"));
				c.setStatus(rs.getInt("status"));
				c.setImgs(rs.getString("imgs"));
				c.setCourse(rs.getString("course"));
				list.add(c);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//�γ̽��ܡ����ı�״̬
	public boolean coursecstatus(String id, String status) {
		Connection con=JDBC.getConnection();
		String sql="update coursedescription set status=? where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//�γ̽��ܡ�������
	public boolean courseadd(CourseDescription c) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into coursedescription values(?,?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, c.getCourse());
			 ps.setString(2, c.getImgs());
			 ps.setString(3, c.getDetail());
			 ps.setInt(4, c.getStatus()); 
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// �γ̽��ܡ������Ҫ�޸ĵ�ԭ����
	public CourseDescription courseinfo(String id) {
		CourseDescription c=new CourseDescription();
		Connection con=JDBC.getConnection();
		 String sql="select * from coursedescription where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 c.setId(rs.getInt("id"));
				 c.setStatus(rs.getInt("status"));
				 c.setCourse(rs.getString("course"));
				 c.setDetail(rs.getString("detail"));
				 c.setImgs(rs.getString("imgs"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	//�γ̽��ܡ����޸�
	public boolean coursealter(CourseDescription c) {
		 Connection con=JDBC.getConnection();
		 String sql="update coursedescription set course=?,imgs=?,detail=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,c.getCourse());
			 ps.setString(2,c.getImgs());
			 ps.setString(3,c.getDetail());
			 ps.setInt(4,c.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// �γ̽��ܡ���ɾ��
	public boolean coursedelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from coursedescription where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//TODO����������������������������������������������������������������������4���Ŷ�̬����������������������������������������������������������������������������
	//���Ŷ�̬�����б�
	public List newslist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from news where id not in(select top "+(currentpage-1)*perpage+ " id from news)";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				News n=new News();
				n.setTitle(rs.getString("title"));
				n.setId(rs.getInt("id"));
				n.setStatus(rs.getInt("status"));
				n.setContents(rs.getString("contents"));
				n.setCtime(rs.getString("ctime"));
				list.add(n);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//���Ŷ�̬��������
	public boolean newsadd(News n) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into news values(?,?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, n.getTitle());
			 ps.setString(2, n.getCtime());
			 ps.setString(3, n.getContents());
			 ps.setInt(4, n.getStatus()); 
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//���Ŷ�̬�����ı�״̬
	public boolean newscstatus(String id, String status) {
		Connection con=JDBC.getConnection();
		String sql="update news set status=? where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//���Ŷ�̬�������Ҫ�޸ĵ�ԭ����
	public News newsinfo(String id) {
		News n=new News();
		Connection con=JDBC.getConnection();
		 String sql="select * from news where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 n.setId(rs.getInt("id"));
				 n.setStatus(rs.getInt("status"));
				 n.setTitle(rs.getString("title"));
				 n.setContents(rs.getString("contents"));
				 n.setCtime(rs.getString("ctime"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	//���Ŷ�̬�����޸�
	public boolean newsalter(News n) {
		 Connection con=JDBC.getConnection();
		 String sql="update news set title=?,ctime=?,contents=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,n.getTitle());
			 ps.setString(2,n.getCtime());
			 ps.setString(3,n.getContents());
			 ps.setInt(4,n.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//���Ŷ�̬����ɾ��
	public boolean newsdelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from news where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//���Ŷ�̬�����鿴��ϸ����
	public String readnews(String id) {
		Connection con=JDBC.getConnection();
		String sql="select contents from news where id="+id;
		String readnews="";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				readnews=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readnews;
	}
//TODO������������������������������������������������������������5��ҵ���ǡ���������������������������������������������������������������������������
	//��ҵ���ǡ������б�
	public List studentslist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from students where id not in(select top "+(currentpage-1)*perpage+ " id from students)";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Students s=new Students();
				s.setName(rs.getString("name"));
				s.setImgs(rs.getString("imgs"));
				s.setId(rs.getInt("id"));
				s.setStatus(rs.getInt("status"));
				s.setGraduation(rs.getString("graduation"));
			    s.setHome(rs.getString("home"));
			    s.setTakeoffice(rs.getString("takeoffice"));
			    s.setSalary(rs.getFloat("salary"));	
			 	list.add(s);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//��ҵ���ǡ�������
	public boolean studentsadd(Students s) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into students values(?,?,?,?,?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, s.getName()); 
			 ps.setString(2, s.getImgs()); 
			 ps.setFloat(3, s.getSalary());
			 ps.setString(4, s.getGraduation());
			 ps.setString(5, s.getHome());
			 ps.setString(6, s.getTakeoffice());
			 ps.setInt(7, s.getStatus()); 
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//��ҵ���ǡ����ı�״̬
	public boolean studentscstatus(String id, String status) {
		Connection con=JDBC.getConnection();
		String sql="update students set status=? where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//��ҵ���ǡ������Ҫ�޸ĵ�ԭ����
	public Students studentsinfo(String id) {
		Students s=new Students();
		Connection con=JDBC.getConnection();
		 String sql="select * from Students where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 s.setId(rs.getInt("id"));
				 s.setStatus(rs.getInt("status"));
				 s.setImgs(rs.getString("imgs"));
				 s.setGraduation(rs.getString("graduation"));
				 s.setHome(rs.getString("home"));
				 s.setTakeoffice(rs.getString("takeoffice"));
				 s.setSalary(rs.getFloat("salary"));
				 s.setName(rs.getString("name"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	//��ҵ���ǡ����޸�
	public boolean studentsalter(Students s) {
		 Connection con=JDBC.getConnection();
		 String sql="update students set imgs=?,salary=?,name=?,graduation=?,takeoffice=?,home=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,s.getImgs());
			 ps.setFloat(2,s.getSalary());
			 ps.setString(3,s.getName());
			 ps.setString(4,s.getGraduation());
			 ps.setString(5,s.getTakeoffice());
			 ps.setString(6,s.getHome());
			 ps.setInt(7,s.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//��ҵ���ǡ���ɾ��
	public boolean studentsdelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from students where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//TODO������������������������������������������������������������6ʦ����������������������������������������������������������������������������������������
	//ʦ�����������б�
	public List teacherslist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from teachers where id not in(select top "+(currentpage-1)*perpage+ " id from teachers)";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Teachers t=new Teachers();
				t.setDetail(rs.getString("detail"));
				t.setId(rs.getInt("id"));
				t.setStatus(rs.getInt("status"));
				t.setImgs(rs.getString("imgs"));
				t.setName(rs.getString("name"));
				list.add(t);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//ʦ��������������
	public boolean teachersadd(Teachers t) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into teachers values(?,?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, t.getName());
			 ps.setString(2, t.getImgs());
			 ps.setString(3, t.getDetail());
			 ps.setInt(4, t.getStatus()); 
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//ʦ�����������ı�״̬
	public boolean teacherscstatus(String id, String status) {
		Connection con=JDBC.getConnection();
		String sql="update teachers set status=? where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//ʦ�������������Ҫ�޸ĵ�ԭ����
	public Teachers teachersinfo(String id) {
		Teachers t=new Teachers();
		Connection con=JDBC.getConnection();
		 String sql="select * from teachers where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 t.setId(rs.getInt("id"));
				 t.setStatus(rs.getInt("status"));
				 t.setDetail(rs.getString("detail"));
				 t.setImgs(rs.getString("imgs"));
				 t.setName(rs.getString("name"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	//ʦ�����������޸�
	public boolean teachersalter(Teachers t) {
		 Connection con=JDBC.getConnection();
		 String sql="update teachers set name=?,imgs=?,detail=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,t.getName());
			 ps.setString(2,t.getImgs());
			 ps.setString(3,t.getDetail());
			 ps.setInt(4,t.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//ʦ����������ɾ��
	public boolean teachersdelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from teachers where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//TODO������������������������������������������������������������7 ���԰�� ������������������������������������������������������������������������
	//���԰�� ����
	public boolean messageboardadd(MessageBoard t) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into messageboard values(?,?,?,?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, t.getNickname());
			 ps.setString(2, t.getEmail());
			 ps.setString(3, t.getTel());
			 ps.setString(4, t.getContents());
			 ps.setString(5, t.getCtime());
			 ps.setInt(6, t.getStatus()); 
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//���԰�顪���б�
	public List messageboardlist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from messageboard where id not in(select top "+(currentpage-1)*perpage+ " id from messageboard)";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				MessageBoard t=new MessageBoard();
				t.setContents(rs.getString("contents"));
				t.setId(rs.getInt("id"));
				t.setStatus(rs.getInt("status"));
				t.setCtime(rs.getString("ctime"));
				t.setNickname(rs.getString("nickname"));
				t.setEmail(rs.getString("email"));
				t.setTel(rs.getString("tel"));
				list.add(t);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// ���԰�顪���ı�״̬
	public boolean messageboardcstatus(String id, String status) {
		Connection con=JDBC.getConnection();
		String sql="update messageboard set status=? where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ���԰�顪�����Ҫ�޸ĵ�ԭ����
	public MessageBoard messageboardinfo(String id) {
		MessageBoard t=new MessageBoard();
		Connection con=JDBC.getConnection();
		 String sql="select * from messageboard where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 t.setContents(rs.getString("contents"));
					t.setId(rs.getInt("id"));
					t.setStatus(rs.getInt("status"));
					t.setCtime(rs.getString("ctime"));
					t.setNickname(rs.getString("nickname"));
					t.setEmail(rs.getString("email"));
					t.setTel(rs.getString("tel"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	// ���԰�顪���޸�
	public boolean messageboardalter(MessageBoard t) {
		 Connection con=JDBC.getConnection();
		 String sql="update messageboard set nickname=?,contents=?,email=?,tel=?,ctime=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,t.getNickname());
			 ps.setString(2,t.getContents());
			 ps.setString(3,t.getEmail());
			 ps.setString(4,t.getTel());
			 ps.setString(5,t.getCtime());
			 ps.setInt(6,t.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ���԰�顪��ɾ��
	public boolean messageboarddelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from messageboard where id=? ";
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//TODO������������������������������������������������������������8 ���Իظ�������������������������������������������������������������������������
	//���Իظ� ����
	public boolean messagereplyadd(MessageReply t) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into messagereply values(?,?,?,?,?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setInt(1, t.getRid()); 
			 ps.setString(2, t.getNickname());
			 ps.setString(3, t.getEmail());
			 ps.setString(4, t.getTel());
			 ps.setString(5, t.getContents());
			 ps.setString(6, t.getCtime());
			 ps.setInt(7, t.getStatus()); 
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//���Իظ������б�
	public List messagereplylist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from messagereply where id not in(select top "+(currentpage-1)*perpage+ " id from messagereply)";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				MessageReply t=new MessageReply();
				t.setContents(rs.getString("contents"));
				t.setId(rs.getInt("id"));
				t.setRid(rs.getInt("rid"));
				t.setStatus(rs.getInt("status"));
				t.setCtime(rs.getString("ctime"));
				t.setNickname(rs.getString("nickname"));
				t.setEmail(rs.getString("email"));
				t.setTel(rs.getString("tel"));
				list.add(t);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//���Իظ������ı�״̬
	public boolean messagereplycstatus(String id, String status) {
		Connection con=JDBC.getConnection();
		String sql="update messagereply set status=? where id=? ";
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//���Իظ��������Ҫ�޸ĵ�ԭ����
	public MessageReply messagereplyinfo(String id) {
		MessageReply t=new MessageReply();
		Connection con=JDBC.getConnection();
		 String sql="select * from messagereply where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 t.setContents(rs.getString("contents"));
					t.setId(rs.getInt("id"));
					t.setRid(rs.getInt("rid"));
					t.setStatus(rs.getInt("status"));
					t.setCtime(rs.getString("ctime"));
					t.setNickname(rs.getString("nickname"));
					t.setEmail(rs.getString("email"));
					t.setTel(rs.getString("tel"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	// ���Իظ������޸�
	public boolean messagereplyalter(MessageReply t) {
		 Connection con=JDBC.getConnection();
		 String sql="update messagereply set nickname=?,contents=?,email=?,tel=?,rid=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,t.getNickname());
			 ps.setString(2,t.getContents());
			 ps.setString(3,t.getEmail());
			 ps.setString(4,t.getTel());
			 ps.setInt(5,t.getRid());
			 ps.setInt(6,t.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ���Իظ�����ɾ��
	public boolean messagereplydelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from messagereply where id=? ";
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//TODO������������������������������������������������������������9 Ԥ������������������������������������������������������������������������������
	// Ԥ��������������б�
	public List plansignuplist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from plansignup where id not in(select top "
		+(currentpage-1)*perpage+ " id from plansignup)";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				PlanSignUp c=new PlanSignUp();
				c.setContents(rs.getString("contents"));
				c.setId(rs.getInt("id"));
				c.setStatus(rs.getInt("status"));
				c.setImgs(rs.getString("imgs"));
				c.setTitle(rs.getString("title"));
				c.setPrice(rs.getFloat("price"));
				list.add(c);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//Ԥ�����������ı�״̬
	public boolean plansignupcstatus(String id, String status) {
		Connection con=JDBC.getConnection();
		String sql="update plansignup set status=? where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//Ԥ��������������
	public boolean plansignupadd(PlanSignUp c) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into plansignup values(?,?,?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, c.getTitle());
			 ps.setString(2, c.getContents());
			 ps.setFloat(3, c.getPrice());
			 ps.setString(4, c.getImgs());
			 ps.setInt(5, c.getStatus()); 
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// Ԥ�������������Ҫ�޸ĵ�ԭ����
	public PlanSignUp plansignupinfo(String id) {
		PlanSignUp c=new PlanSignUp();
		Connection con=JDBC.getConnection();
		 String sql="select * from plansignup where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 c.setId(rs.getInt("id"));
				 c.setStatus(rs.getInt("status"));
				 c.setContents(rs.getString("contents"));
				 c.setTitle(rs.getString("title"));
				 c.setPrice(Float.parseFloat(rs.getString("price")));
				 c.setImgs(rs.getString("imgs"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	//Ԥ�����������޸�
	public boolean plansignupalter(PlanSignUp c) {
		 Connection con=JDBC.getConnection();
		 String sql="update plansignup set contents=?,imgs=?,price=?,title=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,c.getContents());
			 ps.setString(2,c.getImgs());
			 ps.setFloat(3,c.getPrice());
			 ps.setString(4,c.getTitle());
			 ps.setInt(5,c.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// Ԥ����������ɾ��
	public boolean plansignupdelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from plansignup where id=? ";
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//TODO������������������������������������������������������������10 �������������������������������������������������������������������������������
	// ���������������б�
	public List signuplist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from signup where id not in(select top "+(currentpage-1)*perpage+ " id from signup)";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SignUp a=new SignUp();
				a.setCtime(rs.getString("ctime"));
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setPid(rs.getInt("pid"));
				a.setTel(rs.getString("tel"));
				a.setStatus(rs.getInt("status"));
				list.add(a);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//���������������
	public boolean signupadd(SignUp a) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into signup values(?,?,?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setInt(1, a.getPid());
			 ps.setString(2, a.getName());
			 ps.setString(3, a.getTel());
			 ps.setString(4, a.getCtime()); 
			 ps.setInt(5, a.getStatus());
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//���뱨������
	public PlanSignUp tosignup(String id) {
		Connection con=JDBC.getConnection();
		String sql="select * from plansignup where id=? ";
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				PlanSignUp p=new PlanSignUp();
				p.setId(rs.getInt("id"));
				p.setContents(rs.getString("contents"));
				p.setImgs(rs.getString("imgs"));
				p.setPrice(rs.getFloat("price"));
				p.setTitle(rs.getString("title"));
				ps.close();
				con.close();
				return p;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// �����������ɾ��
	public boolean signupdelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from signup where id=? ";
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//������������ı�״̬
	public boolean signupcstatus(String id, String status) {
		Connection con=JDBC.getConnection();
		String sql="update signup set status=? where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//TODO������������������������������������������������������������11ѧУ�����������������������������������������������������������������������	
	// ѧУ���������б�
	public List activitylist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from activity where id not in(select top "+(currentpage-1)*perpage+ " id from activity)";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Activity a=new Activity();
				a.setImgs(rs.getString("imgs"));
				a.setId(rs.getInt("id"));
				a.setStatus(rs.getInt("status"));
				a.setTitle(rs.getString("title"));
				list.add(a);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//ѧУ������ı�״̬
	public boolean activitycstatus(String id, String status) {
		Connection con=JDBC.getConnection();
		String sql="update activity set status=? where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//ѧУ���������
	public boolean activityadd(Activity a) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into activity values(?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, a.getTitle());
			 ps.setString(2, a.getImgs());
			 ps.setInt(3, a.getStatus()); 
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ѧУ��������Ҫ�޸ĵ�ԭ����
	public Activity activityinfo(String id) {
		Activity a=new Activity();
		Connection con=JDBC.getConnection();
		 String sql="select * from activity where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 a.setId(rs.getInt("id"));
				 a.setStatus(rs.getInt("status"));
				 a.setTitle(rs.getString("title"));
				 a.setImgs(rs.getString("imgs"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	//ѧУ������޸�
	public boolean activityalter(Activity a) {
		 Connection con=JDBC.getConnection();
		 String sql="update activity set title=?,imgs=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,a.getTitle());
			 ps.setString(2,a.getImgs());
			 ps.setInt(3,a.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ѧУ�����ɾ��
	public boolean activitydelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from activity where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//TODO������������������������������������������������������������12ѧУ����������������������������������������������������������������������������������������������������������	
	//ѧУ������������б�
	public List environmentlist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from environment where id not in(select top "+(currentpage-1)*perpage+ " id from environment)";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Environment e=new Environment();
				e.setImgs(rs.getString("imgs"));
				e.setId(rs.getInt("id"));
				e.setStatus(rs.getInt("status"));
				e.setTitle(rs.getString("title"));
				list.add(e);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//ѧУ���������ı�״̬
	public boolean environmentcstatus(String id, String status) {
		Connection con=JDBC.getConnection();
		String sql="update environment set status=? where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//ѧУ������������
	public boolean environmentadd(Environment e) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into environment values(?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, e.getTitle());
			 ps.setString(2, e.getImgs());
			 ps.setInt(3, e.getStatus()); 
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException ae) {
			ae.printStackTrace();
		}
		return false;
	}
	// ѧУ�����������Ҫ�޸ĵ�ԭ����
	public Environment environmentinfo(String id) {
		Environment e=new Environment();
		Connection con=JDBC.getConnection();
		 String sql="select * from environment where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 e.setId(rs.getInt("id"));
				 e.setStatus(rs.getInt("status"));
				 e.setTitle(rs.getString("title"));
				 e.setImgs(rs.getString("imgs"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;
	}
	//ѧУ���������޸�
	public boolean environmentalter(Environment e) {
		 Connection con=JDBC.getConnection();
		 String sql="update environment set title=?,imgs=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,e.getTitle());
			 ps.setString(2,e.getImgs());
			 ps.setInt(3,e.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException ae) {
			ae.printStackTrace();
		}
		return false;
	}
	// ѧУ��������ɾ��
	public boolean environmentdelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from environment where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//TODO����������������������������������������������������������������13ѧ����ҵ��ͼ������������������������������������������������������������������������
	//��ҵ��ͼ��������б�
	public List graduationlist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from graduationtable where id not in(select top "+(currentpage-1)*perpage+ " id from graduationtable)";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Graduationtable g=new Graduationtable();
				g.setImgs(rs.getString("imgs"));
				g.setId(rs.getInt("id"));
				g.setStatus(rs.getInt("status"));
				g.setTitle(rs.getString("title"));
				list.add(g);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//��ҵ��ͼ�����ı�״̬
	public boolean graduationcstatus(String id, String status) {
		Connection con=JDBC.getConnection();
		String sql="update graduationtable set status=? where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//��ҵ��ͼ��������
	public boolean graduationadd(Graduationtable e) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into graduationtable values(?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, e.getTitle());
			 ps.setString(2, e.getImgs());
			 ps.setInt(3, e.getStatus()); 
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException ae) {
			ae.printStackTrace();
		}
		return false;
	}
	// ��ҵ��ͼ�������Ҫ�޸ĵ�ԭ����
	public Graduationtable graduationinfo(String id) {
		Graduationtable e=new Graduationtable();
		Connection con=JDBC.getConnection();
		 String sql="select * from graduationtable where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 e.setId(rs.getInt("id"));
				 e.setStatus(rs.getInt("status"));
				 e.setTitle(rs.getString("title"));
				 e.setImgs(rs.getString("imgs"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;
	}
	//��ҵ��ͼ�����޸�
	public boolean graduationalter(Graduationtable e) {
		 Connection con=JDBC.getConnection();
		 String sql="update graduationtable set title=?,imgs=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,e.getTitle());
			 ps.setString(2,e.getImgs());
			 ps.setInt(3,e.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException ae) {
			ae.printStackTrace();
		}
		return false;
	}
	// ��ҵ��ͼ����ɾ��
	public boolean graduationdelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from graduationtable where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//TODO������������������������������������������������������������14��ϵ���ǡ�����������������������������������������������������������������������
	//��ϵ���ǡ�������б�
	public List contactuslist() {
		Connection con=JDBC.getConnection();
		String sql="select * from contactus ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ContactUs g=new ContactUs();
				g.setContents(rs.getString("contents"));
				g.setId(rs.getInt("id"));
				g.setMap(rs.getString("map"));
				list.add(g);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// ��ϵ���ǡ������Ҫ�޸ĵ�ԭ����
	public ContactUs contactusinfo(String id) {
		ContactUs e=new ContactUs();
		Connection con=JDBC.getConnection();
		 String sql="select * from contactus where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 e.setId(rs.getInt("id"));
				 e.setContents(rs.getString("contents"));
				 e.setMap(rs.getString("map"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;
	}
	//��ϵ���ǡ����޸�
	public boolean contactusalter(ContactUs e) {
		 Connection con=JDBC.getConnection();
		 String sql="update contactus set contents=?,map=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,e.getContents());
			 ps.setString(2,e.getMap());
			 ps.setInt(3,e.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException ae) {
			ae.printStackTrace();
		}
		return false;
	}
//TODO��������������������������������������������������������������������������Ƶ����������������������������������������������������������������-
	// ������Ƶ��������б�
	public List videolist(int perpage, int currentpage) {
		Connection con=JDBC.getConnection();
		String sql="select top "+perpage+" * from video where id not in(select top "
		+(currentpage-1)*perpage+ " id from video)";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				video c=new video();
				c.setCtime(rs.getString("ctime"));
				c.setId(rs.getInt("id"));
				c.setStatus(rs.getInt("status"));
				c.setTitle(rs.getString("title"));
				c.setVideo(rs.getString("video"));
				list.add(c);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//������Ƶ�����ı�״̬
	public boolean videocstatus(String id, String status) {
		Connection con=JDBC.getConnection();
		String sql="update video set status=? where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, status);
			ps.setString(2, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//������Ƶ��������
	public boolean videoadd(video c) {
		 Connection con=JDBC.getConnection();
		 String sql="insert into video values(?,?,?,?) ";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, c.getTitle());
			 ps.setString(2, c.getVideo());
			 ps.setInt(3, c.getStatus()); 
			 ps.setString(4, c.getCtime());
			 int i=ps.executeUpdate();
			 if(i>0){
				 ps.close();
				 con.close();
				 return true;
			 }
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ������Ƶ�������Ҫ�޸ĵ�ԭ����
	public video videoinfo(String id) {
		video c=new video();
		Connection con=JDBC.getConnection();
		 String sql="select * from video where id="+id;
		 try {
			PreparedStatement ps=con.prepareStatement(sql); 
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 c.setId(rs.getInt("id"));
				 c.setStatus(rs.getInt("status"));
				 c.setCtime(rs.getString("ctime"));
				 c.setTitle(rs.getString("title"));
				 c.setVideo(rs.getString("video"));
			 }
				rs.close();
				ps.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	//������Ƶ�����޸�
	public boolean videoalter(video c) {
		 Connection con=JDBC.getConnection();
		 String sql="update video set title=?,video=?,ctime=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,c.getTitle());
			 ps.setString(2,c.getVideo());
			 ps.setString(3,c.getCtime());
			 ps.setInt(4,c.getId());
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//������Ƶ����ɾ��
	public boolean videodelete(String id) {
		Connection con=JDBC.getConnection();
		String sql="delete from video where id=? ";
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				ps.close();
				con.close();
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
