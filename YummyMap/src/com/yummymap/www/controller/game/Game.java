package com.yummymap.www.controller.game;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.GameDAO;
import com.yummymap.www.controller.MmyController;

public class Game implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		GameDAO dao = new GameDAO();
		List<String> list = dao.getAllCateList();
		req.setAttribute("list", list);
		String view = "/game/game.jsp";
		return view;
	}


}
