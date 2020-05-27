package com.yummymap.www.controller.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummymap.www.DAO.ChangeDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.member.*;;

public class UpdateUserProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 로그인 사용자 정보조회
		ChangeDAO cDAO = new ChangeDAO();
		String nowPW = req.getParameter("nowPW");
		HttpSession session = req.getSession();
		String mid = (String) req.getSession().getAttribute("sid");

		int cnt = cDAO.SEL_PW(nowPW, mid);

		if (mid == null) {
			return "/YummyMap/main.mmy";
		}

		// db테이블 현재 비밀번호와 일치하는지 확인
		if (cnt != 1) {
			// 현재 비밀번호와 다른경우
			try {
				resp.sendRedirect("/YummyMap/member/member.mmy?ck=x");
			} catch (Exception e) {
				e.printStackTrace();
			}
			String view = null;
			return view;
		}
		// 비밀번호 변경 작업
		// 현재 비밀번호와 바꿀 비밀번호값 검사
		String newPW = req.getParameter("changePW_V");
		if (newPW.equals(nowPW)) {
			return "/YummyMap/member/member.mmy";

		}

		cnt = cDAO.updateUserPW(newPW, mid);
		String view = "";
		if (cnt == 0) {
			// cnt가 0일때 비밀번호 업데이트가 안되었을때

			view = "/YummyMap/member/member.mmy";
		} else {
			// cnt가 1일때 비밀번호가 변경되었을때
			session.getAttribute(mid);
			view = "/YummyMap/main.mmy";
		}
		return view;
	}
}
