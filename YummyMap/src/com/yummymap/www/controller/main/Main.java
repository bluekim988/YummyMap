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

import com.yummymap.www.DAO.MainDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.ResVO;

public class Main implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		MainDAO mainDao = new MainDAO();
		List<ResVO> topResList = mainDao.getAvgTopResList();
		for(int i=0; i<topResList.size(); i++) {
			ResVO rvo = topResList.get(i);
			int resno = rvo.getResno();
			List<String> imgList = mainDao.getResImg(resno);
			rvo.setImgList(imgList);
		}
		req.setAttribute("avgTopResList", topResList);
		String view = "/main_0.jsp";
		return view;
	}

}
