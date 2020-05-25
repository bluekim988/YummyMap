package com.yummymap.www.controller.main;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.MainDAO;
import com.yummymap.www.controller.MmyController;

public class RemoveReviewProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String revno_ = req.getParameter("revno");
		String resno_ = req.getParameter("resno");
		int revno = -1;
		int resno = -1;
		try {
			revno = Integer.parseInt(revno_);
			resno = Integer.parseInt(resno_);
		} catch (Exception e) {}
		if(revno == -1 || resno == -1) {
			try {
				resp.sendRedirect("/YummyMap/main/detail.mmy?r="+resno);
				return null;
			} catch (IOException e) {}
		}
		MainDAO mainDao = new MainDAO();
		mainDao.removeReview(revno);
		try {
			resp.sendRedirect("/YummyMap/main/detail.mmy?r="+resno);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
