package com.yummymap.www.controller.main;

/**
 * 이 클래스는 YummyMap 프로젝트의 main_0.jsp 페이지 포워딩을 담당한다.
 * 
 * @author	김종형
 * @since	2020/05/26
 * @see		com.yummymap.www.DAO.MainDAO
 * 			com.yummymap.www.SQL.MainSQL
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.GameDAO;
import com.yummymap.www.DAO.MainDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.ResVO;

public class Main implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String str = req.getParameter("q");
		String userID = "no";
		String userID_param = (String)req.getSession().getAttribute("sid");
		if(userID_param != null) {
			userID = userID_param;
		}
		
		MainDAO mainDao = new MainDAO();
		// 평균점수 탑3 리스트를 가져옵니다.
		List<ResVO> topAvgResList = mainDao.getAvgTopResList(userID);
		for(int i=0; i<topAvgResList.size(); i++) {
			ResVO rvo = topAvgResList.get(i);
			int resno = rvo.getResno();
			List<String> imgList = mainDao.getResImg(resno);
			rvo.setImgList(imgList);
		}
		//리뷰 탑3 리스트를 가져옵니다.
		List<ResVO> topReviewResList = mainDao.getTopReviewResList(userID);
		for(int i=0; i<topReviewResList.size(); i++) {
			ResVO rvo = topReviewResList.get(i);
			int resno = rvo.getResno();
			List<String> imgList = mainDao.getResImg(resno);
			rvo.setImgList(imgList);
		}
		
		//카테고리 리스트를 가져옵니다.
		GameDAO gameDao = new GameDAO();
		List<String> cateList = gameDao.getAllCateList();
		
		req.setAttribute("avgTopResList", topAvgResList);
		req.setAttribute("topReviewResList", topReviewResList);
		req.setAttribute("cateList", cateList);
		String view = "/main_0.jsp";
		return view;
	}

}
