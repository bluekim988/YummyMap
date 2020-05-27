package com.yummymap.www.controller.join;
/**
 * 이 클래스는 회원가입 처리 유청을 컨트롤하는 클래스입니다.
 * 
 * @author	김종형
 * @see		com.yummymap.www.DAO.JoinDAO
 */
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.JoinDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.MemberVO;

public class JoinProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 파라미터값을 가져옵니다.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String teltop = req.getParameter("teltop");
		String telmid = req.getParameter("telmid");
		String telend = req.getParameter("telend");
		String tel = teltop + '-' + telmid + '-' + telend;
		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");
		String mail = email1 + email2;
		String name = req.getParameter("name");
		
		// VO를 이용하여 db작업을 합니다.
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setTel(tel);
		vo.setMail(mail);
		vo.setName(name);
		int cnt = new JoinDAO().joinNewMember(vo);
		String view = "";
		if(cnt != 1) {
			view = "/YummyMap/join/login.mmy?r=e";
			try {
				resp.sendRedirect(view);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		} else {
			req.getSession().setAttribute("sid", id);
			view = "/YummyMap/main.mmy";
			return view;
		}
	}

}
