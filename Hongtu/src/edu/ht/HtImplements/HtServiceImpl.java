package edu.ht.HtImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import edu.ht.Bean.AboutUs;
import edu.ht.Bean.Activity;
import edu.ht.Bean.ContactUs;
import edu.ht.Bean.CourseDescription;
import edu.ht.Bean.Environment;
import edu.ht.Bean.Graduationtable;
import edu.ht.Bean.MessageBoard;
import edu.ht.Bean.MessageReply;
import edu.ht.Bean.News;
import edu.ht.Bean.PlanSignUp;
import edu.ht.Bean.Students;
import edu.ht.Bean.Teachers;
import edu.ht.Common.JDBC;
import edu.ht.HtInterface.HtService;

public class HtServiceImpl implements HtService{
	//课程介绍
	public List czkcjs() {
		Connection con=JDBC.getConnection();
		String sql="select * from CourseDescription where status=1"; 
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CourseDescription  cd = new CourseDescription();
				cd.setId(rs.getInt("id"));
				cd.setCourse(rs.getString("course"));
				cd.setImgs(rs.getString("imgs"));
				cd.setDetail(rs.getString("detail"));
				cd.setStatus(rs.getInt("status"));
				list.add(cd);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//就业明星
	public List czjymx() {
		Connection con=JDBC.getConnection();
		String sql="select * from Students where status=1"; 
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Students  s = new Students();
				s.setId(rs.getInt("id"));				
				s.setImgs(rs.getString("imgs"));			
				s.setGraduation(rs.getString("graduation"));			
				s.setHome(rs.getString("home"));			
				s.setName(rs.getString("name"));			
				s.setTakeoffice(rs.getString("takeoffice"));
				s.setSalary(rs.getFloat("salary"));
				s.setStatus(rs.getInt("status"));
				list.add(s);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//师资力量
	public List czszll() {
		Connection con=JDBC.getConnection();
		String sql="select * from Teachers where status=1"; 
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){

				Teachers  t = new Teachers();
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setImgs(rs.getString("imgs"));
				t.setDetail(rs.getString("detail"));
				t.setStatus(rs.getInt("status"));
				list.add(t);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//关于我们
	public List czgywm() {
		// TODO Auto-generated method stub
		return null;
	}
	//新闻动态
	public List czxwdt() {
		Connection con=JDBC.getConnection();
		String sql="select * from News where status=1"; 
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){

				News  n = new News();
				n.setId(rs.getInt("id"));
				n.setTitle(rs.getString("title"));
				n.setCtime(rs.getString("ctime"));
				n.setContents(rs.getString("contents"));
				n.setStatus(rs.getInt("status"));
				list.add(n);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//留言板
	public Map czlyb() {
		Connection con=JDBC.getConnection();
		String sql="select * from messageboard where status=1 order by id desc"; 
		Map map=new LinkedHashMap();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				MessageBoard  m = new MessageBoard();
				m.setId(rs.getInt("id"));
				m.setNickname(rs.getString("nickname"));
				m.setCtime(rs.getString("ctime"));
				m.setContents(rs.getString("contents"));
				m.setTel(rs.getString("tel"));
				m.setStatus(rs.getInt("status"));
				String sql2="select * from messagereply where status=1 and rid="+m.getId();
				PreparedStatement ps2=con.prepareStatement(sql2);
				ResultSet rs2=ps2.executeQuery();
				List list=new ArrayList();
				while(rs2.next()){
					MessageReply m2=new MessageReply();
					m2.setId(rs2.getInt("id"));
					m2.setNickname(rs2.getString("nickname"));
					m2.setCtime(rs2.getString("ctime"));
					m2.setContents(rs2.getString("contents"));
					m2.setTel(rs2.getString("tel"));
					m2.setStatus(rs2.getInt("status"));
					m2.setRid(rs2.getInt("rid"));	
					list.add(m2);
				}
				map.put(m, list);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	//留言总数
	public int getnewscount() {
		int i=0;
		Connection con=JDBC.getConnection();
		String sql="select count(*) from MessageBoard where status=1"; 
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				i=rs.getInt(1);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	
	//预定报名
	public List czydbm() {
		Connection con=JDBC.getConnection();
		String sql="select * from PlanSignUp where status=1"; 
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				PlanSignUp  p = new PlanSignUp();
				p.setId(rs.getInt("id"));
				p.setTitle(rs.getString("title"));
				p.setContents(rs.getString("contents"));
				p.setPrice(rs.getFloat("price"));
				p.setImgs(rs.getString("imgs"));
				p.setStatus(rs.getInt("status"));
				list.add(p);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//学校活动
	public List activitylist() {
		Connection con=JDBC.getConnection();
		String sql="select * from activity where status=1"; 
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Activity  a = new Activity();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setImgs(rs.getString("imgs"));
				a.setStatus(rs.getInt("status"));
				list.add(a);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//关于我们
	public AboutUs getaboutus() {
		AboutUs a=new AboutUs();
		Connection con= JDBC.getConnection();
		String sql="select * from AboutUs ";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				a.setId(rs.getInt("id"));
				a.setContents(rs.getString("contents"));
				a.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	//学校活动查看大图
	public Activity readactivity(String id) {
		Activity a=new Activity();
		Connection con= JDBC.getConnection();
		String sql="select * from activity where id="+id;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				a.setId(rs.getInt("id"));
				a.setStatus(rs.getInt("status"));
				a.setImgs(rs.getString("imgs"));
				a.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	//学校环境
	public List environmentlist() {
		Connection con=JDBC.getConnection();
		String sql="select * from environment where status=1"; 
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Environment  a = new Environment();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setImgs(rs.getString("imgs"));
				a.setStatus(rs.getInt("status"));
				list.add(a);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//学校活动查看大图
	public Environment readenvironment(String id) {
		Environment a=new Environment();
		Connection con= JDBC.getConnection();
		String sql="select * from environment where id="+id;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				a.setId(rs.getInt("id"));
				a.setStatus(rs.getInt("status"));
				a.setImgs(rs.getString("imgs"));
				a.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	//学生毕业一览表
	public List graduationlist() {
		Connection con=JDBC.getConnection();
		String sql="select * from graduationtable where status=1"; 
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Graduationtable  a = new Graduationtable();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setImgs(rs.getString("imgs"));
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
	
	
	//学校活动——上一张
	public Activity getlastactivity(String id) {
		Connection con=JDBC.getConnection();
		String sql="select * from activity where id<"+id+" and status=1 order by id desc ;";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Activity a=new Activity();
				a.setId(rs.getInt("id"));
				a.setStatus(rs.getInt("status"));
				a.setImgs(rs.getString("imgs"));
				a.setTitle(rs.getString("title"));
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	//学校活动——下一张
	public Activity getnextactivity(String id) {
		Connection con=JDBC.getConnection();
		String sql="select * from activity where id>"+id+" and status=1 order by id asc ;";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Activity a=new Activity();
				a.setId(rs.getInt("id"));
				a.setStatus(rs.getInt("status"));
				a.setImgs(rs.getString("imgs"));
				a.setTitle(rs.getString("title"));
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//学校环境——上一张
	public Environment getlastenvironment(String id) {
		Connection con=JDBC.getConnection();
		String sql="select * from Environment where id<"+id+" and status=1 order by id desc ;";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Environment a=new Environment();
				a.setId(rs.getInt("id"));
				a.setStatus(rs.getInt("status"));
				a.setImgs(rs.getString("imgs"));
				a.setTitle(rs.getString("title"));
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//学校环境——下一张
	public Environment getnextenvironment(String id) {
		Connection con=JDBC.getConnection();
		String sql="select * from Environment where id>"+id+" and status=1 order by id asc";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Environment a=new Environment();
				a.setId(rs.getInt("id"));
				a.setStatus(rs.getInt("status"));
				a.setImgs(rs.getString("imgs"));
				a.setTitle(rs.getString("title"));
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public News czxw(int id) {
		Connection con=JDBC.getConnection();
		String sql="select * from News where id="+id; 
		List<News> list=new ArrayList<News>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){


				News  n = new News();
				n.setId(rs.getInt("id"));
				n.setTitle(rs.getString("title"));
				n.setCtime(rs.getString("ctime"));
				n.setContents(rs.getString("contents"));
				n.setStatus(rs.getInt("status"));
				return n;
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//联系我们
	public ContactUs getcontactus() {
		Connection con=JDBC.getConnection();
		String sql="select * from contactus"; 
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ContactUs  c = new ContactUs();
				c.setId(rs.getInt("id"));
				c.setContents(rs.getString("contents"));
				c.setMap(rs.getString("map"));
				return c;
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//预定报名
	public PlanSignUp tosignuo(String id) {
		Connection con=JDBC.getConnection();
		String sql="select * from plansignup where id="+id; 
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				PlanSignUp  c = new PlanSignUp();
				c.setId(rs.getInt("id"));
				c.setContents(rs.getString("contents"));
				c.setImgs(rs.getString("imgs"));
				c.setPrice(rs.getFloat("price"));
				c.setTitle(rs.getString("title"));
				return c;
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List indexcourse(){
		Connection con=JDBC.getConnection();
		String sql="select top 3 * from coursedescription where status=1"; 
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CourseDescription  cd = new CourseDescription();
				cd.setId(rs.getInt("id"));
				cd.setCourse(rs.getString("course"));
				cd.setImgs(rs.getString("imgs"));
				cd.setDetail(rs.getString("detail"));
				cd.setStatus(rs.getInt("status"));
				list.add(cd);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}	
	
	public List indexstudents(){
		Connection con=JDBC.getConnection();
		String sql="select top 8 * from Students where status=1"; 
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Students  s = new Students();
				s.setId(rs.getInt("id"));				
				s.setImgs(rs.getString("imgs"));			
				s.setGraduation(rs.getString("graduation"));			
				s.setHome(rs.getString("home"));			
				s.setName(rs.getString("name"));			
				s.setTakeoffice(rs.getString("takeoffice"));
				s.setSalary(rs.getFloat("salary"));
				s.setStatus(rs.getInt("status"));
				list.add(s);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}	
	
	public List indexteachers(){
		Connection con=JDBC.getConnection();
		String sql="select top 4 * from Teachers where status=1"; 
		List list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Teachers  t = new Teachers();
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setImgs(rs.getString("imgs"));
				t.setDetail(rs.getString("detail"));
				t.setStatus(rs.getInt("status"));
				list.add(t);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}	
	
}
