package com.yummymap.www.controller.game;
/**
 * 이 클래스는 게임페이지에서 필요한 아이템들을 비동기로 전달하기위해 제작되었다.
 * 
 * @author	김종형
 * @see		com.yummymap.www.DAO.GameDAO
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.GameDAO;
import com.yummymap.www.controller.MmyController;

public class GameItem implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		String cate = req.getParameter("cate");
		GameDAO dao = new GameDAO();
		List<String> list = dao.getAllMenuListInCate(cate);
		String str = setJSONString(list);
		try {
			resp.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String setJSONString(List<String> list) {
		StringBuffer buff = new StringBuffer();
		buff.append("{\"items\":[");
		for(int i=0; i<list.size(); i++) {
			buff.append("\"");
			buff.append(list.get(i));
			if(i == list.size()-1) {
				buff.append("\"");
				break;
			}
			buff.append("\",");
		}
		buff.append("]}");
		return buff.toString();
	}
}
