package com.yummymap.www.controller.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.AdminDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.admin.BoardInfoVO;

public class BoardList implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/admin/board.jsp";
		
		AdminDAO adao = new AdminDAO();
		ArrayList<BoardInfoVO> list = adao.boardList();
		
		req.setAttribute("LIST", list);
		
		return view;
	}

}
