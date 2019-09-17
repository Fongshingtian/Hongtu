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
	//��¼�����˺������Ƿ���ȷ
	public Managers logining(String account,String pwd);
	//��ѯ�������ĳ�������������
	public int datacount(String tablename);
//TODO��������������������������������������������������������1��Ա������������������������������������������������������������������������������������������
	//��Ա������ó�Ա�б�
	public List managerslist(int perpage,int currentpage);
	//��Ա�����ı��Ա״̬
	public boolean managerscstatus(String id,String status);
	//��Ա����ɾ����Ա
	public boolean managersdelete(String id);
	//��Ա�����ж��˺��Ƿ����
	public boolean managersaddcheck(Managers m);
	//��Ա������ӳ�Ա
	public boolean managersadd(Managers m);
	//��Ա�������Ҫ�޸ĵĳ�Ա��ԭ����
	public Managers managersinfo(String id);
	//��Ա�����޸ĳ�Ա����
	public boolean managersalter(Managers m);
	//��Ա��������
	public List managerssearchlist(int perpage,int currentpage,String search);
//TODO ������������������������������������������������2�������ǡ�������������������������������������������������������������������������������������������������������
	//�������ǡ�����ù��������б�
	public List aboutusList();
	//�������ǡ������Ҫ�޸ĵĹ������ǵ�ԭ����
	public AboutUs aboutusinfo(String id);
	//�������ǡ����޸Ĺ�����������
	public boolean aboutusalter(AboutUs a);
//TODO ������������������������������������3�γ̽��ܡ�������������������������������������������������������������������������������������������������������������
	//�γ̽��ܡ�������б�
	public List courselist(int perpage,int currentpage);
	//�γ̽��ܡ����ı�״̬
	public boolean coursecstatus(String id,String status);
	//�γ̽��ܡ���ɾ��
	public boolean coursedelete(String id); 
	//�γ̽��ܡ������
	public boolean courseadd(CourseDescription c);
	//�γ̽��ܡ������Ҫ�޸ĵ�ԭ����
	public CourseDescription courseinfo(String id);
	//�γ̽��ܡ����޸�����
	public boolean coursealter(CourseDescription c);
//TODO ������������������������������4���Ŷ�̬��������������������������������������������������������������������������������������������������������������������
	//���Ŷ�̬��������б�
	public List newslist(int perpage,int currentpage);
	//���Ŷ�̬�����ı�״̬
	public boolean newscstatus(String id,String status);
	//���Ŷ�̬����ɾ��
	public boolean newsdelete(String id); 
	//���Ŷ�̬�������
	public boolean newsadd(News n);
	//���Ŷ�̬�������Ҫ�޸ĵ�ԭ����
	public News newsinfo(String id);
	//���Ŷ�̬�����޸�����
	public boolean newsalter(News n);
	//���Ŷ�̬�����鿴��ϸ����
	public String readnews(String id);
//��������������������������������������5��ҵ���ǡ�������������������������������������������������������������������������������������������������������
	//��ҵ���ǡ�������б�
	public List studentslist(int perpage,int currentpage);
	//��ҵ���ǡ����ı�״̬
	public boolean studentscstatus(String id,String status);
	//��ҵ���ǡ���ɾ��
	public boolean studentsdelete(String id); 
	//��ҵ���ǡ������
	public boolean studentsadd(Students s);
	//��ҵ���ǡ������Ҫ�޸ĵ�ԭ����
	public Students studentsinfo(String id);
	//��ҵ���ǡ����޸�����
	public boolean studentsalter(Students s);
//����������������������������������6ʦ������������������������������������������������������������������������������������������������������������������������������
	//ʦ��������������б�
	public List teacherslist(int perpage,int currentpage);
	//ʦ�����������ı�״̬
	public boolean teacherscstatus(String id,String status);
	//ʦ����������ɾ��
	public boolean teachersdelete(String id); 
	//ʦ�������������
	public boolean teachersadd(Teachers t);
	//ʦ�������������Ҫ�޸ĵ�ԭ����
	public Teachers teachersinfo(String id);
	//ʦ�����������޸�����
	public boolean teachersalter(Teachers t);
//TODO ������������������������������7���԰�顪������������������������������������������������������������������������������������������������������������������
	//���԰�顪�����
	public boolean messageboardadd(MessageBoard t);
	//���԰�顪������б�
	public List messageboardlist(int perpage,int currentpage);
	//���԰�顪���ı�״̬
	public boolean messageboardcstatus(String id,String status);
	//���԰�顪��ɾ��
	public boolean messageboarddelete(String id); 
	//���԰�顪�����Ҫ�޸ĵ�ԭ����
	public MessageBoard messageboardinfo(String id);
	//���԰�顪���޸�����
	public boolean messageboardalter(MessageBoard t);
//TODO ������������������������������8 ���Իظ���������������������������������������������������������������������������������������������������������������������
	//���Իظ��������
	public boolean messagereplyadd(MessageReply t);
	//���Իظ���������б�
	public List messagereplylist(int perpage,int currentpage);
	//���Իظ������ı�״̬
	public boolean messagereplycstatus(String id,String status);
	//���Իظ�����ɾ��
	public boolean messagereplydelete(String id); 
	//���Իظ��������Ҫ�޸ĵ�ԭ����
	public MessageReply messagereplyinfo(String id);
	//���Իظ������޸�����
	public boolean messagereplyalter(MessageReply t);
//TODO ������������������������������9 Ԥ��������������������������������������������������������������������������������������������������������������������������
	//Ԥ��������������б�
	public List plansignuplist(int perpage,int currentpage);
	//Ԥ�����������ı�״̬
	public boolean plansignupcstatus(String id,String status);
	//Ԥ����������ɾ��
	public boolean plansignupdelete(String id); 
	//Ԥ�������������
	public boolean plansignupadd(PlanSignUp t);
	//Ԥ�������������Ҫ�޸ĵ�ԭ����
	public PlanSignUp plansignupinfo(String id);
	//Ԥ�����������޸�����
	public boolean plansignupalter(PlanSignUp t);
//TODO ������������������������������10 ���������������������������������������������������������������������������������������������������������������������������
	//������������б�
	public List signuplist(int perpage,int currentpage);
	//��������������
	public boolean signupadd(SignUp t);
	//��������������뱨������
	public PlanSignUp tosignup(String id);
	//������������ı�״̬
	public boolean signupcstatus(String id,String status);
	//�����������ɾ��
	public boolean signupdelete(String id); 
//TODO��������������������������������������������11ѧУ�������������������������������������������������������������������������������������������������������
	//ѧУ���������б�
	public List activitylist(int perpage,int currentpage);
	//ѧУ������ı�״̬
	public boolean activitycstatus(String id,String status);
	//ѧУ�����ɾ��
	public boolean activitydelete(String id); 
	//ѧУ��������
	public boolean activityadd(Activity a);
	//ѧУ��������Ҫ�޸ĵ�ԭ����
	public Activity activityinfo(String id);
	//ѧУ������޸�����
	public boolean activityalter(Activity a);
//TODO��������������������������������������12 ѧУ��������������������������������������������������������������������������������������������������������������������
	//ѧУ������������б�
	public List environmentlist(int perpage,int currentpage);
	//ѧУ���������ı�״̬
	public boolean environmentcstatus(String id,String status);
	//ѧУ��������ɾ��
	public boolean environmentdelete(String id); 
	//ѧУ�����������
	public boolean environmentadd(Environment e);
	//ѧУ�����������Ҫ�޸ĵ�ԭ����
	public Environment environmentinfo(String id);
	//ѧУ���������޸�����
	public boolean environmentalter(Environment e);
//TODO��������������������������������������13��ҵѧ��ͼ������������������������������������������������������������������������������������������������������������
	//��ҵһ����������б�
	public List graduationlist(int perpage,int currentpage);
	//��ҵһ�������ı�״̬
	public boolean graduationcstatus(String id,String status);
	//��ҵһ������ɾ��
	public boolean graduationdelete(String id); 
	//��ҵһ���������
	public boolean graduationadd(Graduationtable e);
	//��ҵһ���������Ҫ�޸ĵ�ԭ����
	public Graduationtable graduationinfo(String id);
	//��ҵһ�������޸�����
	public boolean graduationalter(Graduationtable e);
//TODO��������������������������������������������14��ϵ���ǡ���������������������������������������������������������������������������������������������������������������
	//��ϵ���ǡ�������б�
	public List contactuslist();
	//��ϵ���ǡ������Ҫ�޸ĵ�ԭ����
	public ContactUs contactusinfo(String id);
	//��ϵ���ǡ����޸�����
	public boolean contactusalter(ContactUs c);
//TODO������������������������������������������������15������Ƶ������������������������������������������������������������������������������������
	//������Ƶ��������б�
	public List videolist(int perpage,int currentpage);
	//������Ƶ�����ı�״̬
	public boolean videocstatus(String id,String status);
	//������Ƶ����ɾ��
	public boolean videodelete(String id); 
	//������Ƶ�������
	public boolean videoadd(video e);
	//������Ƶ�������Ҫ�޸ĵ�ԭ����
	public video videoinfo(String id);
	//������Ƶ�����޸�����
	public boolean videoalter(video e);
}

