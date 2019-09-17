package edu.ht.Bean;

public class Students {
	//¾ÍÒµÃ÷ÐÇ 
	private int id;
	private String imgs;//Í¼Æ¬
	private int status  ;
	private float salary;
	private String home;
	private String name;
	private String takeoffice;
	private String graduation;
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getTakeoffice() {
		return takeoffice;
	}
	public void setTakeoffice(String takeoffice) {
		this.takeoffice = takeoffice;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
