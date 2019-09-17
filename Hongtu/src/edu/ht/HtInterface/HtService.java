package edu.ht.HtInterface;

import java.util.List;
import java.util.Map;

import edu.ht.Bean.AboutUs;
import edu.ht.Bean.Activity;
import edu.ht.Bean.ContactUs;
import edu.ht.Bean.Environment;
import edu.ht.Bean.News;
import edu.ht.Bean.PlanSignUp;

public interface HtService {
	//查找课程介绍
	public List czkcjs();
	
	//查找就业明星
	public List czjymx();
	
	//查找师资力量
	public List czszll();
	
	//查找新闻动态
	public List czxwdt();
	
	//查找新闻
	public News czxw(int id);
	
	//查找关于我们
	public List czgywm();
	
	//查找留言板
	public Map czlyb();
	
	//留言总数
	public int getnewscount();
	
	//查找预定报名
	public List czydbm();
	
	//关于我们
	public AboutUs getaboutus();
	
	//学校活动
	public List activitylist();
	
	//学校活动大图查看
	public Activity readactivity(String id);
	
	//学校环境
	public List environmentlist();
	
	//学校环境大图查看
	public Environment readenvironment(String id);
	
	//学生毕业一览表
	public List graduationlist();
	
	//学校活动上一张
	public Activity getlastactivity(String id);
	
	//学校活动下一张
	public Activity getnextactivity(String id);
	
	//学校环境上一张
	public Environment getlastenvironment(String id);
	
	//学校环境下一张
	public Environment getnextenvironment(String id);
	
	//联系我们
	public ContactUs getcontactus();
	
	//预定报名
	public PlanSignUp tosignuo(String id);
	
	public List indexteachers();
	public List indexstudents();
	
}
