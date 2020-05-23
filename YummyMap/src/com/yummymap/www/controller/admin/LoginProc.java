package com.yummymap.www.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummymap.www.controller.MmyController;
import com.yummymap.www.DAO.*;

public class LoginProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "main.mmy";
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		AdminDAO adao = new AdminDAO();
		
		int cnt = adao.selAdmin(id, pw);
		
		if(cnt == 0) {
//			req.setAttribute("CNT", cnt);
			
			char noad = 'b';
			try {
				resp.sendRedirect("login.mmy?noad="+noad);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			view = null;
			return view;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("SID", id);
		
		return view;
	}

}
