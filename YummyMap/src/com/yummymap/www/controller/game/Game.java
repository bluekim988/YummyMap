package com.yummymap.www.controller.game;
/**
 * 이 클래스는 게임페이지 요청시 포워딩하기위해 제작되었다.
 * 
 * @author	김종형
 * @see		com.yummymap.www.DAO.GameDAO
 */
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
