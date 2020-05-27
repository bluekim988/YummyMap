package com.yummymap.www.controller.member;

import java.io.Console;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummymap.www.DAO.ChangeDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.member.*;;

public class DropUser implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/YummyMap/main.mmy";
		String mid = (String)req.getSession().getAttribute("sid");
		ChangeDAO cDAO = new ChangeDAO();
		int cnt = 0;
		cnt = cDAO.DropUser(mid);
		HttpSession session = req.getSession();
		if(cnt == 1) {
			session.removeAttribute("sid");
		} else {
			view = "/YummyMap/member/member.mmy";
		}
		
			
		return view;
	}

}
