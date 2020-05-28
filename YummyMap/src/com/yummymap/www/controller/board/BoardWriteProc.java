package com.yummymap.www.controller.board;
/**
 * @author	김소영
 * @since	2020.05.27
 *  이 클래스는 게시판 글 작성페이지 컨트롤러 입니다
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.BoardDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.BoardVO;

public class BoardWriteProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/YummyMap/board/boardMain.mmy";
		req.setAttribute("isRedirect", true);
		// 할일
		// 세션에 기록된 아이디를 가져온다.
		String mid = (String) req.getSession().getAttribute("sid");
		String catno_param = req.getParameter("catno");
		int catno = 0;
		
		try {
			
			 catno = Integer.parseInt(catno_param);
		} catch (Exception e) {}
		
		// 데이터 꺼내고
		String title_param = req.getParameter("title");
		String mtxt_param = req.getParameter("mtxt");
		
		BoardVO bvo = new BoardVO();
		bvo.setMid(mid);
		bvo.setTitle(title_param);
		bvo.setMtxt(mtxt_param);
		bvo.setCatno(catno);
		BoardDAO bdao =  new BoardDAO();
		int cnt = bdao.addBoard(bvo);

		// 디비작업하고
		
		if (cnt != 1) {
			view = "/YummyMap/board/boardMain.mmy";
			req.setAttribute("isRedirect", true);
			return view;
		}
		return view;

	}
}