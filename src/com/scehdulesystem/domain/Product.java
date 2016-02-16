package com.scehdulesystem.domain;


public class Product {
 private String pname;
 //service time in this code do timing unit in minutes
 private int service_time;
 private int p_id;
 
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getP_id() {
	return p_id;
}
public void setP_id(int p_id) {
	this.p_id = p_id;
}
public int getService_time() {
	return service_time;
}
public void setService_time(int service_time) {
	this.service_time = service_time;
}

}
