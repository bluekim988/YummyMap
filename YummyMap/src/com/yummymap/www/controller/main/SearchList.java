package com.yummymap.www.controller.main;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.GameDAO;
import com.yummymap.www.DAO.MainDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.*;

public class SearchList implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String str = req.getParameter("q");
		String userID = "no";
		String userID_param = (String)req.getSession().getAttribute("sid");
		if(userID_param != null) {
			userID = userID_param;
		}
		MainDAO dao = new MainDAO();
		List<ResVO> list = dao.getList(str, userID);
		for(int i=0; i<list.size(); i++) {
			ResVO rvo = list.get(i);
			int resno = rvo.getResno();
			List<String> imgList = dao.getResImg(resno);
			rvo.setImgList(imgList);
		}
		
		//카테고리 리스트를 가져옵니다.
		GameDAO gameDao = new GameDAO();
		List<String> cateList = gameDao.getAllCateList();
		
		req.setAttribute("list", list);
		req.setAttribute("cateList", cateList);
		String view = "/main_1.jsp";

		return view;
	}

}
