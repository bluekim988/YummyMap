package com.yummymap.www.vo.member;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javafx.scene.chart.PieChart.Data;

public class TxtVO {
	private int txtno, count, rnum;
	private String mid, title, cdate;
	private Date tdate;
	private Time ttime;
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
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public void setCdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd/");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		this.cdate = form1.format(tdate) + " " + form2.format(ttime);
	}

	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	public Time getTtime() {
		return ttime;
	}
	public void setTtime(Time ttime) {
		this.ttime = ttime;
	}
	
	
	}
	
	

