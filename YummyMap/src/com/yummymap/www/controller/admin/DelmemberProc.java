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
		
			adao.delUser(mno);
		

		
		try {
			resp.sendRedirect("/YummyMap/admin/main.mmy?nowpage=" + nowpage);
		} catch (Exception e) {}
		String view = null;
		
		return view;
	}

}
