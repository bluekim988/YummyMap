package com.yummymap.www.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.AdminDAO;
import com.yummymap.www.controller.MmyController;

public class DelmemberProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String nowpage = req.getParameter("nowpage");
		System.out.println("no" + nowpage);
		String smno = req.getParameter("mno");
		int mno = 0;
		try {
			mno = Integer.parseInt(smno);
		} catch (Exception e) {	}
		
		System.out.println("mno" + mno);
		AdminDAO adao = new AdminDAO();
		
		int cnt = adao.delUser(mno);
		
		if(cnt == 1) {
			System.out.println("정상 삭제 완료");
		}else {
			System.out.println("정상 삭제 실패");
			
		}
		
		try {
			resp.sendRedirect("/YummyMap/admin/main.mmy?nowpage=" + nowpage);
		} catch (Exception e) {}
		String view = null;
		
		return view;
	}

}
