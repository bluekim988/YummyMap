package com.yummymap.www.vo;

import java.util.*;
import java.util.StringTokenizer;

public class ResVO {
	private int resno, catno, subno;
	private String resname, addr, tel, menu;
	private List<String> menuList;
	public int getResno() {
		return resno;
	}
	public void setResno(int resno) {
		this.resno = resno;
	}
	public int getCatno() {
		return catno;
	}
	public void setCatno(int catno) {
		this.catno = catno;
	}
	public int getSubno() {
		return subno;
	}
	public void setSubno(int subno) {
		this.subno = subno;
	}
	public String getResname() {
		return resname;
	}
	public void setResname(String resname) {
		this.resname = resname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public List<String> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<String> menuList) {
		this.menuList = menuList;
	}
	public void setMenuList() {
		this.menuList = new ArrayList<String>();
		StringTokenizer token = new StringTokenizer(menu,"#");
		while (token.hasMoreElements()) {
			menuList.add(token.nextToken());			
		}
	}	
}
