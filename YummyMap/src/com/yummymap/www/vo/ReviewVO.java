package com.yummymap.www.vo;
/**
 * 
 * @author	김종형
 */
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ReviewVO {

	private int revno, resno, starnum, reviewCount;
	private String id, 	txt, sdate;
	private Date crdate;
	public int getRevno() {
		return revno;
	}
	public void setRevno(int revno) {
		this.revno = revno;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public int getResno() {
		return resno;
	}
	public void setResno(int resno) {
		this.resno = resno;
	}
	public int getStarnum() {
		return starnum;
	}
	public void setStarnum(int starnum) {
		this.starnum = starnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public void setSdate() {
		SimpleDateFormat f1 = new SimpleDateFormat("yyyy/MM/dd");
		this.sdate = f1.format(crdate);
	}
	public Date getCrdate() {
		return crdate;
	}
	public void setCrdate(Date crdate) {
		this.crdate = crdate;
	}
	
	
}
