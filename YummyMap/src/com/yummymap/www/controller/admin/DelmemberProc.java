package com.yummymap.www.controller.admin;
/**
 * @author 유태희
 * @since 2020.05.24
 *  이 클래스는 사용자 삭제 컨트롤러 입니다
 */
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
		
		AdminDAO adao = new AdminDAO();
		
			adao.delUser(mno);
		try {
			resp.sendRedirect("/YummyMap/admin/main.mmy?nowpage=" + nowpage);
		} catch (Exception e) {}
		String view = null;
		
		return view;
	}

}
