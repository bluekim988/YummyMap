package com.yummymap.www.controller.board;
/**
 * @author	김소영
 * @since	2020.05.27
 *  이 클래스는 게시판 글 작성페이지 컨트롤러 입니다
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.controller.MmyController;

public class BoardWrite implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/boardWrite.jsp";
		if((String) req.getSession().getAttribute("sid") == null) {
			req.setAttribute("isRedirect", true);
			view = "/YummyMap/join/login.mmy";
		}
		return view;
	}

}