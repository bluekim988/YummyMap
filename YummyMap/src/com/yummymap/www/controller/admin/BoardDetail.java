package com.yummymap.www.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.AdminDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.admin.BoardInfoVO;

public class BoardDetail implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String stxtno = req.getParameter("nos");
		int txtno = 0;
		try {
			txtno = Integer.parseInt(stxtno);
		} catch (Exception e) {	}
		
		AdminDAO adao = new AdminDAO();
		BoardInfoVO bvo = adao.boardDetail(txtno);
		
		req.setAttribute("BVO", bvo);
		String view = "/admin/boardDetail.jsp";
		
		return view;
	}

}
