package com.yummymap.www.controller.admin;
/**
 * @author 유태희
 * @since 2020.05.23
 *  이 클래스는 사용자 수정 컨트롤러 입니다
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.AdminDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.admin.MemberInfoVO;

public class RememberProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		String smno = req.getParameter("mno");
		String nowpage = req.getParameter("nowPage");
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		String tel = req.getParameter("tel");
		String mailid = req.getParameter("mail");
		String domain = req.getParameter("domain");
		String issues = req.getParameter("issue");
		String mail = mailid + "@" + domain;
		String issue="N";
		
		
		try {
			if(issues.equals("ok")){
				issue = "X";
			}
		} catch (Exception e) {	}
		
		int mno = 0;
		try {
			mno = Integer.parseInt(smno);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	 if(pw.length() != 0) {
		MemberInfoVO mvo = new MemberInfoVO();
		mvo.setMno(mno);
		mvo.setMname(name);
		mvo.setPass(pw);
		mvo.setMtel(tel);
		mvo.setMemail(mail);
		mvo.setIssue(issue);
		
		AdminDAO adao = new AdminDAO();
		adao.reMember(mvo);

	 }else {
			MemberInfoVO mvo = new MemberInfoVO();
			
			mvo.setMno(mno);
			mvo.setMname(name);
			mvo.setMtel(tel);
			mvo.setMemail(mail);
			mvo.setIssue(issue);
			
			AdminDAO adao = new AdminDAO();
			adao.reMemberNopass(mvo);

		 }
	 
		try {
			resp.sendRedirect("/YummyMap/admin/main.mmy?nowpage=" + nowpage);
		} catch (Exception e) {}
		String view = null;	
		return view;
	}

}
