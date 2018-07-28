package com.nt.command;

public class StudentCommand {
	private String sname;
	private String sadd;
	private String course;
	private  Float  percentage;
	private String vflag="no";
	
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
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public String getVflag() {
		return vflag;
	}

	public void setVflag(String vflag) {
		this.vflag = vflag;
	}

}
