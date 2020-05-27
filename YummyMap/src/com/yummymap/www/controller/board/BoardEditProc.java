package com.yummymap.www.controller.board;
/**
 * @author	김소영
 * @since	2020.05.27
 *  이 클래스는 게시판 글 수정페이지 컨트롤러 입니다
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.BoardDAO;
import com.yummymap.www.controller.MmyController;

public class BoardEditProc implements MmyController {
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/YummyMap/board/boardMain.mmy";
		
		req.setAttribute("isRedirect", true);
		String title = req.getParameter("title");
		String mtxt = req.getParameter("mtxt");
		String sno = req.getParameter("txtno");
//		String scat = req.getParameter("catno");
		System.out.println("proc.title : " + title);
		System.out.println("proc.mtxt : " + mtxt);
//		System.out.println("proc.scat : " + scat);
		int txtno = Integer.parseInt(sno);
//		int catno = Integer.parseInt(cat);
		
		BoardDAO bDAO = new BoardDAO();
//		int edit = bDAO.editBoard(title, mtxt, txtno);
		
		return view;
	}

}