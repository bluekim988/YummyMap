package com.yummymap.www.controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.MainDAO;
import com.yummymap.www.controller.MmyController;

public class ReviewProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String id = (String)req.getSession().getAttribute("sid");
		String txt = req.getParameter("t");
		String snum = req.getParameter("s");
		String resno_ = req.getParameter("r");
		int starnum;
		int resno;
		int cnt = 0;
		try {
			starnum = Integer.parseInt(snum);
			resno = Integer.parseInt(resno_);
			MainDAO dao = new MainDAO();
			cnt = dao.addReview(resno, id, txt, starnum);
			if(cnt == 1) {
				String view = "/YummyMap/main/detail.mmy?r="+resno;
				resp.sendRedirect(view);
				return null;
			}
		} catch (Exception e) {}
		
		String view = "/YummyMap/main/detail.mmy";
		return view;
	}

}
