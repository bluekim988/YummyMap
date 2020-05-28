package com.yummymap.www.vo;


import java.sql.Date;
import java.text.SimpleDateFormat;

public class BoardVO {
	private int rno, txtno, mno, count, rnum, catno, lv;
	private String title, mid, mname, mtxt, bdate, rtxt, category, isrec;
	private Date cDate;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getTxtno() {
		return txtno;
	}
	public void setTxtno(int txtno) {
		this.txtno = txtno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIsrec() {
		return isrec;
	}
	public void setIsrec(String isrec) {
		this.isrec = isrec;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMtxt() {
		return mtxt;
	}
	public void setMtxt(String mtxt) {
		this.mtxt = mtxt;
		this.mtxt = mtxt.replaceAll("\r\n", "<br>");
	}
	
	public void setMtxt() {
		this.mtxt = mtxt.replaceAll("<br>", "\r\n");
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate() {
		SimpleDateFormat f1 = new SimpleDateFormat("yyyy/MM/dd");
		this.bdate = f1.format(cDate);
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public String getRtxt() {
		return rtxt;
	}
	public void setRtxt(String rtxt) {
		this.rtxt = rtxt;
	}
	
	
	
}