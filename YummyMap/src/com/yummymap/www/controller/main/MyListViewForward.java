package com.yummymap.www.controller.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		req.setAttribute("myResList", myResList);
		String view = "/myResList.jsp";

		return view;
	}
}
