package edu.ht.Bean;

public class CourseDescription {
	//¿Î³Ì½éÉÜ
	private int id;//id
	private String course;//ÏîÄ¿Ãû³Æ
	private String imgs;//Í¼Æ¬
	private String detail;//ÏêÇé½éÉÜ
	private int status;//×´Ì¬
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
