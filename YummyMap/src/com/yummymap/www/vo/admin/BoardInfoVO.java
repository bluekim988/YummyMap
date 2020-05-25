package com.yummymap.www.vo.admin;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class BoardInfoVO {
 private int txtno , count , rnum , catno , lv;
 private String title , mid , sdate , mtxt , isshow;
 private Date cdate;
 private Time ctime;
public int getTxtno() {
	return txtno;
}
public void setTxtno(int txtno) {
	this.txtno = txtno;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getRnum() {
	return rnum;
}
public void setRnum(int rnum) {
	this.rnum = rnum;
}
public int getCatno() {
	return catno;
}
public void setCatno(int catno) {
	this.catno = catno;
}
public int getLv() {
	return lv;
}
public void setLv(int lv) {
	this.lv = lv;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}
public String getSdate() {
	return sdate;
}
public void setSdate() {
	SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd");
	SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
	this.sdate = form1.format(cdate) + " " + form2.format(ctime);
}
public void setSdate(String sdate) {
	this.sdate = sdate;
}
public String getMtxt() {
	return mtxt;
}
public void setMtxt(String mtxt) {
	this.mtxt = mtxt;
}
public void setMtxt() {
	this.mtxt = mtxt.replaceAll("\r\n", "<br>");
}
public String getIsshow() {
	return isshow;
}
public void setIsshow(String isshow) {
	this.isshow = isshow;
}
public Date getCdate() {
	return cdate;
}
public void setCdate(Date cdate) {
	this.cdate = cdate;
}
public Time getCtime() {
	return ctime;
}
public void setCtime(Time ctime) {
	this.ctime = ctime;
}
 
 
 
 
}
