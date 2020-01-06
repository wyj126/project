package com.d.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Jf {

	private Integer jfid;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate time;
	private String isjf;
	public int getJfid() {
		return jfid;
	}
	public void setJfid(int jfid) {
		this.jfid = jfid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getTime() {
		return time;
	}
	public void setTime(LocalDate time) {
		this.time = time;
	}
	public String getIsjf() {
		return isjf;
	}
	public void setIsjf(String isjf) {
		this.isjf = isjf;
	}
	@Override
	public String toString() {
		return this.jfid+","+this.name+","+this.time+","+this.isjf;
	}

	
	
}
