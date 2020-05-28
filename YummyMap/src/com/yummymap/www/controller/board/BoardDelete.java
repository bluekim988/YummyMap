package com.yummymap.www.controller.board;
/**
 * @author	김소영
 * @since	2020.05.27
 *  이 클래스는 게시판 글 삭제 컨트롤러 입니다
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.BoardDAO;
import com.yummymap.www.controller.MmyController;

public class BoardDelete implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/YummyMap/board/boardMain.mmy";
		req.setAttribute("isRedirect", true);
		String txtno = (String)req.getParameter("txtno");
		int sno = Integer.parseInt(txtno);
		BoardDAO bDAO = new BoardDAO();
		bDAO.delBoard(sno);
		return view;
	}

}
