package com.yummymap.www.controller.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.GameDAO;
import com.yummymap.www.DAO.MainDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.ResVO;

public class MyListViewForward implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String userID = (String)req.getSession().getAttribute("sid");
		if(userID == null) {
			return "/YummyMap/main.mmy";
		}
		MainDAO mainDao = new MainDAO();
		List<ResVO> myResList = mainDao.getMyPickList(userID);
		for(int i=0; i<myResList.size(); i++) {
			ResVO resVo = myResList.get(i);
			int resNo = resVo.getResno();
			List<String> imgList = mainDao.getResImg(resNo);
			resVo.setImgList(imgList);
		}
		//카테고리 리스트를 가져옵니다.
		GameDAO gameDao = new GameDAO();
		List<String> cateList = gameDao.getAllCateList();
		
		req.setAttribute("myResList", myResList);
		req.setAttribute("cateList", cateList);
		String view = "/myResList.jsp";

		return view;
	}
}
