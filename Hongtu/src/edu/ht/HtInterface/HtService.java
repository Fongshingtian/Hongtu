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
	//���ҿγ̽���
	public List czkcjs();
	
	//���Ҿ�ҵ����
	public List czjymx();
	
	//����ʦ������
	public List czszll();
	
	//�������Ŷ�̬
	public List czxwdt();
	
	//��������
	public News czxw(int id);
	
	//���ҹ�������
	public List czgywm();
	
	//�������԰�
	public Map czlyb();
	
	//��������
	public int getnewscount();
	
	//����Ԥ������
	public List czydbm();
	
	//��������
	public AboutUs getaboutus();
	
	//ѧУ�
	public List activitylist();
	
	//ѧУ���ͼ�鿴
	public Activity readactivity(String id);
	
	//ѧУ����
	public List environmentlist();
	
	//ѧУ������ͼ�鿴
	public Environment readenvironment(String id);
	
	//ѧ����ҵһ����
	public List graduationlist();
	
	//ѧУ���һ��
	public Activity getlastactivity(String id);
	
	//ѧУ���һ��
	public Activity getnextactivity(String id);
	
	//ѧУ������һ��
	public Environment getlastenvironment(String id);
	
	//ѧУ������һ��
	public Environment getnextenvironment(String id);
	
	//��ϵ����
	public ContactUs getcontactus();
	
	//Ԥ������
	public PlanSignUp tosignuo(String id);
	
	public List indexteachers();
	public List indexstudents();
	
}
