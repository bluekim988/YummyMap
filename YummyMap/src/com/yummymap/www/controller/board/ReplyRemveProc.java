package com.yummymap.www.controller.board;
/**
 * 게시판의 댓글삭제기능을 컨트롤하기위해 작성되었다.
 * 
 * @author	유태희
 * @since	2020/05/28
 * @see		com.yummymap.www.DAO.BoardDAO
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.BoardDAO;
import com.yummymap.www.controller.MmyController;

public class ReplyRemveProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String srno = req.getParameter("rno");
		String stxtno = req.getParameter("tno");
		
		int rno = 0;
		try {
			rno = Integer.parseInt(srno);
		} catch (Exception e) {}

		BoardDAO bdao = new BoardDAO();
		int cnt = bdao.removeReply(rno);
		
		
		try {
			resp.sendRedirect("/YummyMap/board/boardDetail.mmy?txtno="+stxtno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String view = null;
		return view;
	}

}
