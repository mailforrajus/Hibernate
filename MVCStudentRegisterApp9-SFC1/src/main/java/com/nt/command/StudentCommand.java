package com.nt.command;

public class StudentCommand {
	private String sname;
	private String sadd;
	private String course;
	private  float percentage;
	
	public StudentCommand() {
		System.out.println("StudentCommand:0-param constructor");
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

}
