

package com.scehdulesystem.domain;

import java.util.Date;

public class Appointment {
	//self id
	//private int a_id;
	private int c_Id;
	private int p_id;
	private Date starttime;
	private Date endtime;
	
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public int getC_Id() {
		return c_Id;
	}
	public void setC_Id(int c_Id) {
		this.c_Id = c_Id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {	
		
		this.endtime = endtime;
	}
}

