package com.yummymap.www.controller.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.MainDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.ResVO;
import com.yummymap.www.vo.ReviewVO;

public class Detail implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String resno_ = req.getParameter("r");
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
		ResVO vo = dao.getResInfo(resno);
		List<String> imgList = dao.getResImg(resno);
		vo.setImgList(imgList);
		List<ReviewVO> list = dao.getReviewList(resno);
		req.setAttribute("vo", vo);
		req.setAttribute("list", list);
		String view = "/main_2.jsp";
		return view;
	}

}
