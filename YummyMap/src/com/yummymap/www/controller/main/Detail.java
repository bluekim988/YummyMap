package com.yummymap.www.controller.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.GameDAO;
import com.yummymap.www.DAO.MainDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.ResVO;
import com.yummymap.www.vo.ReviewVO;

public class Detail implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String resno_ = req.getParameter("r");
		String query_str = req.getParameter("q");
		String userID = "no";
		String userID_param = (String)req.getSession().getAttribute("sid");
		if(userID_param != null) {
			userID = userID_param;
		}
		int resno = 0;
		try {
			resno = Integer.parseInt(resno_);
		} catch (Exception e) {}
		if(resno == 0) {
			try {
				resp.sendRedirect("/YummyMap/main.mmy");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		MainDAO dao = new MainDAO();

		ResVO vo = dao.getResInfo(resno, userID);
		List<String> imgList = dao.getResImg(resno);
		vo.setImgList(imgList);
		List<ReviewVO> reviewList = dao.getReviewList(resno);
		if(reviewList.size() != 0) {
			int reviewCount = reviewList.get(0).getReviewCount();
			req.setAttribute("reviewCount", reviewCount);
		}
		
		//카테고리 리스트를 가져옵니다.
		GameDAO gameDao = new GameDAO();
		List<String> cateList = gameDao.getAllCateList();
		
		req.setAttribute("vo", vo);
		req.setAttribute("list", reviewList);
		req.setAttribute("cateList", cateList);

		String view = "/main_2.jsp";
		return view;
	}

}
