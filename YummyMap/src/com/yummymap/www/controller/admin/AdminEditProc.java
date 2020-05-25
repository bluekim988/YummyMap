package com.yummymap.www.controller.admin;
/**
 * @author 유태희
 * @since 2020.05.23
 *  이 클래스는 관리자 정보 변경 컨트롤러 입니다
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummymap.www.DAO.AdminDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.admin.MemberInfoVO;

public class AdminEditProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String sid = (String) session.getAttribute("SID");
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		String tel = req.getParameter("tel");
		String mailid = req.getParameter("mail");
		String domain = req.getParameter("domain");
		String mail = mailid + "@" + domain;
		
		
		
	 if(pw.length() != 0) {
		MemberInfoVO mvo = new MemberInfoVO();
		mvo.setMid(sid);
		mvo.setMname(name);
		mvo.setPass(pw);
		mvo.setMtel(tel);
		mvo.setMemail(mail);

		
		AdminDAO adao = new AdminDAO();
		adao.reAdmin(mvo);

	 }else {
			MemberInfoVO mvo = new MemberInfoVO();
			mvo.setMid(sid);
			mvo.setMname(name);
			mvo.setMtel(tel);
			mvo.setMemail(mail);
			
			AdminDAO adao = new AdminDAO();
			adao.reAdminNopass(mvo);

		 }
	 
		try {
			resp.sendRedirect("/YummyMap/admin/main.mmy");
		} catch (Exception e) {}
		String view = null;	
		return view;
	}

}
