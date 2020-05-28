package com.yummymap.www.controller.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.BoardDAO;
import com.yummymap.www.controller.MmyController;

public class RecommendProc implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String userID = (String)req.getSession().getAttribute("sid");
		String req_param = req.getParameter("r");
		String txtno_param = req.getParameter("txtno");
		int txtno = 0;
		if(txtno_param != null) {
			txtno = Integer.parseInt(txtno_param);
		}
		if(txtno == 0) {
			return "/YummyMap/board/boardMain.mmy";
		}
		BoardDAO boardDao = new BoardDAO();
		if(req_param.equals("Y")) {
			boardDao.decreaseTextRnum(txtno);
			boardDao.removeRecommendData(txtno, userID);
		} else {
			boardDao.increaseTextRnum(txtno);
			boardDao.addRecommendData(userID, txtno);
		}
		try {
			resp.sendRedirect("/YummyMap/board/boardDetail.mmy?txtno="+txtno);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
