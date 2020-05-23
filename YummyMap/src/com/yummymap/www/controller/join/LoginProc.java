package com.yummymap.www.controller.join;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.JoinDAO;
import com.yummymap.www.controller.MmyController;

public class LoginProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String userId = req.getParameter("id");
		String userPw = req.getParameter("pw");
		int cnt = new JoinDAO().checkLogin(userId, userPw);
		String view = "";
		if(cnt != 1) {
			view = "/YummyMap/join/login.mmy?r=x";
			try {
				resp.sendRedirect(view);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		} else {
			req.getSession().setAttribute("sid", userId);
			view = "/YummyMap/main.mmy";
			return view;
		}
	}

}
