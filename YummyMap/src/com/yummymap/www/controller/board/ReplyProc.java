package com.yummymap.www.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.BoardDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.BoardVO;

public class ReplyProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		String sid = (String) req.getSession().getAttribute("sid");
		String stxtno = req.getParameter("tno");
		String reply = req.getParameter("reply");
		
		
		
		int txtno=0;
		try {
			txtno = Integer.parseInt(stxtno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		BoardVO bvo = new BoardVO();
		bvo.setRtxt(reply);
		bvo.setMid(sid);
		bvo.setTxtno(txtno);
		BoardDAO bdao = new BoardDAO();
		int cnt = bdao.addReply(bvo);
		try {
			
		resp.sendRedirect("/YummyMap/board/boardDetail.mmy?txtno="+txtno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String view = null;
		return view;
	}

}
