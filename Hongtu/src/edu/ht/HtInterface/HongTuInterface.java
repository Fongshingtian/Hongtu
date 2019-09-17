package edu.ht.HtInterface;

import java.util.List;

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

public interface HongTuInterface {
	//登录——账号密码是否正确
	public Managers logining(String account,String pwd);
	//查询——获得某个表的列数数量
	public int datacount(String tablename);
//TODO————————————————————————————1成员—————————————————————————————————————————————
	//成员——获得成员列表
	public List managerslist(int perpage,int currentpage);
	//成员——改变成员状态
	public boolean managerscstatus(String id,String status);
	//成员——删除成员
	public boolean managersdelete(String id);
	//成员——判断账号是否存在
	public boolean managersaddcheck(Managers m);
	//成员——添加成员
	public boolean managersadd(Managers m);
	//成员——获得要修改的成员的原资料
	public Managers managersinfo(String id);
	//成员——修改成员资料
	public boolean managersalter(Managers m);
	//成员——搜索
	public List managerssearchlist(int perpage,int currentpage,String search);
//TODO ————————————————————————2关于我们————————————————————————————————————————————————————
	//关于我们——获得关于我们列表
	public List aboutusList();
	//关于我们——获得要修改的关于我们的原内容
	public AboutUs aboutusinfo(String id);
	//关于我们——修改关于我们内容
	public boolean aboutusalter(AboutUs a);
//TODO ——————————————————3课程介绍———————————————————————————————————————————————————————
	//课程介绍——获得列表
	public List courselist(int perpage,int currentpage);
	//课程介绍——改变状态
	public boolean coursecstatus(String id,String status);
	//课程介绍——删除
	public boolean coursedelete(String id); 
	//课程介绍——添加
	public boolean courseadd(CourseDescription c);
	//课程介绍——获得要修改的原资料
	public CourseDescription courseinfo(String id);
	//课程介绍——修改资料
	public boolean coursealter(CourseDescription c);
//TODO ———————————————4新闻动态——————————————————————————————————————————————————————————
	//新闻动态——获得列表
	public List newslist(int perpage,int currentpage);
	//新闻动态——改变状态
	public boolean newscstatus(String id,String status);
	//新闻动态——删除
	public boolean newsdelete(String id); 
	//新闻动态——添加
	public boolean newsadd(News n);
	//新闻动态——获得要修改的原资料
	public News newsinfo(String id);
	//新闻动态——修改资料
	public boolean newsalter(News n);
	//新闻动态——查看详细内容
	public String readnews(String id);
//———————————————————5就业明星————————————————————————————————————————————————————
	//就业明星——获得列表
	public List studentslist(int perpage,int currentpage);
	//就业明星——改变状态
	public boolean studentscstatus(String id,String status);
	//就业明星——删除
	public boolean studentsdelete(String id); 
	//就业明星——添加
	public boolean studentsadd(Students s);
	//就业明星——获得要修改的原资料
	public Students studentsinfo(String id);
	//就业明星——修改资料
	public boolean studentsalter(Students s);
//—————————————————6师资力量————————————————————————————————————————————————————————————
	//师资力量——获得列表
	public List teacherslist(int perpage,int currentpage);
	//师资力量——改变状态
	public boolean teacherscstatus(String id,String status);
	//师资力量——删除
	public boolean teachersdelete(String id); 
	//师资力量——添加
	public boolean teachersadd(Teachers t);
	//师资力量——获得要修改的原资料
	public Teachers teachersinfo(String id);
	//师资力量——修改资料
	public boolean teachersalter(Teachers t);
//TODO ———————————————7留言板块——————————————————————————————————————————————————————————
	//留言板块——添加
	public boolean messageboardadd(MessageBoard t);
	//留言板块——获得列表
	public List messageboardlist(int perpage,int currentpage);
	//留言板块——改变状态
	public boolean messageboardcstatus(String id,String status);
	//留言板块——删除
	public boolean messageboarddelete(String id); 
	//留言板块——获得要修改的原内容
	public MessageBoard messageboardinfo(String id);
	//留言板块——修改内容
	public boolean messageboardalter(MessageBoard t);
//TODO ———————————————8 留言回复——————————————————————————————————————————————————————————
	//留言回复——添加
	public boolean messagereplyadd(MessageReply t);
	//留言回复——获得列表
	public List messagereplylist(int perpage,int currentpage);
	//留言回复——改变状态
	public boolean messagereplycstatus(String id,String status);
	//留言回复——删除
	public boolean messagereplydelete(String id); 
	//留言回复——获得要修改的原内容
	public MessageReply messagereplyinfo(String id);
	//留言回复——修改内容
	public boolean messagereplyalter(MessageReply t);
//TODO ———————————————9 预定报名——————————————————————————————————————————————————————————
	//预定报名——获得列表
	public List plansignuplist(int perpage,int currentpage);
	//预定报名——改变状态
	public boolean plansignupcstatus(String id,String status);
	//预定报名——删除
	public boolean plansignupdelete(String id); 
	//预定报名——添加
	public boolean plansignupadd(PlanSignUp t);
	//预定报名——获得要修改的原资料
	public PlanSignUp plansignupinfo(String id);
	//预定报名——修改资料
	public boolean plansignupalter(PlanSignUp t);
//TODO ———————————————10 报名情况——————————————————————————————————————————————————————————
	//报名情况——列表
	public List signuplist(int perpage,int currentpage);
	//报名情况——添加
	public boolean signupadd(SignUp t);
	//报名情况——进入报名界面
	public PlanSignUp tosignup(String id);
	//报名情况——改变状态
	public boolean signupcstatus(String id,String status);
	//报名情况——删除
	public boolean signupdelete(String id); 
//TODO——————————————————————11学校活动———————————————————————————————————————————————————
	//学校活动——获得列表
	public List activitylist(int perpage,int currentpage);
	//学校活动——改变状态
	public boolean activitycstatus(String id,String status);
	//学校活动——删除
	public boolean activitydelete(String id); 
	//学校活动——添加
	public boolean activityadd(Activity a);
	//学校活动——获得要修改的原资料
	public Activity activityinfo(String id);
	//学校活动——修改资料
	public boolean activityalter(Activity a);
//TODO———————————————————12 学校环境————————————————————————————————————————————————————————
	//学校环境——获得列表
	public List environmentlist(int perpage,int currentpage);
	//学校环境——改变状态
	public boolean environmentcstatus(String id,String status);
	//学校环境——删除
	public boolean environmentdelete(String id); 
	//学校环境——添加
	public boolean environmentadd(Environment e);
	//学校环境——获得要修改的原资料
	public Environment environmentinfo(String id);
	//学校环境——修改资料
	public boolean environmentalter(Environment e);
//TODO———————————————————13毕业学生图——————————————————————————————————————————————————————
	//毕业一览表——获得列表
	public List graduationlist(int perpage,int currentpage);
	//毕业一览表——改变状态
	public boolean graduationcstatus(String id,String status);
	//毕业一览表——删除
	public boolean graduationdelete(String id); 
	//毕业一览表——添加
	public boolean graduationadd(Graduationtable e);
	//毕业一览表——获得要修改的原资料
	public Graduationtable graduationinfo(String id);
	//毕业一览表——修改资料
	public boolean graduationalter(Graduationtable e);
//TODO——————————————————————14联系我们————————————————————————————————————————————————————————
	//联系我们——获得列表
	public List contactuslist();
	//联系我们——获得要修改的原资料
	public ContactUs contactusinfo(String id);
	//联系我们——修改资料
	public boolean contactusalter(ContactUs c);
//TODO————————————————————————15在线视频——————————————————————————————————————————
	//在线视频——获得列表
	public List videolist(int perpage,int currentpage);
	//在线视频——改变状态
	public boolean videocstatus(String id,String status);
	//在线视频——删除
	public boolean videodelete(String id); 
	//在线视频——添加
	public boolean videoadd(video e);
	//在线视频——获得要修改的原资料
	public video videoinfo(String id);
	//在线视频——修改资料
	public boolean videoalter(video e);
}

