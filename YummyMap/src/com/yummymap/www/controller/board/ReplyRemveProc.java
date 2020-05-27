package com.yummymap.www.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.BoardDAO;
import com.yummymap.www.controller.MmyController;

public class ReplyRemveProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String srno = req.getParameter("rno");
		String stxtno = req.getParameter("txtno");
		
		int rno = 0;
		try {
			rno = Integer.parseInt(srno);
		} catch (Exception e) {}

		
		BoardDAO bdao = new BoardDAO();
		int cnt = bdao.removeReply(rno);
		
		if(cnt == 1) {
			System.out.println("정상 삭제");
		}else {
			System.out.println("삭제 못함");
		}
		
		try {
			resp.sendRedirect("/YummyMap/board/boardDetail.mmy?txtno="+stxtno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String view = null;
		return view;
	}

}
