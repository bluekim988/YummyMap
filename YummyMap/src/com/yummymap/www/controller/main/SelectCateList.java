package com.yummymap.www.controller.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.GameDAO;
import com.yummymap.www.DAO.MainDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.ResVO;

public class SelectCateList implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String category = req.getParameter("category");
		if (category == null) {
			category = "한식";
		}
		String userID = "no";
		String userID_param = (String)req.getSession().getAttribute("sid");
		if(userID_param != null) {
			userID = userID_param;
		}
		
		MainDAO mainDao = new MainDAO();
		// 카테고리에 해당하는 식당 리스트를 가져옵니다.
		List<ResVO> resListWithCate = mainDao.getListWithCate(category, userID);
		for(int i=0; i<resListWithCate.size(); i++) {
			ResVO rvo = resListWithCate.get(i);
			int resno = rvo.getResno();
			List<String> imgList = mainDao.getResImg(resno);
			rvo.setImgList(imgList);
		}
		//카테고리 리스트를 가져옵니다.
		GameDAO gameDao = new GameDAO();
		List<String> cateList = gameDao.getAllCateList();
		
		req.setAttribute("list", resListWithCate);
		req.setAttribute("cateList", cateList);
		String view = "/main_1.jsp";
		return view;
	}
}
