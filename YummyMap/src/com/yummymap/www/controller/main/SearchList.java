package com.yummymap.www.controller.main;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.MainDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.*;

public class SearchList implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String str = req.getParameter("q");
		MainDAO dao = new MainDAO();
		List<ResVO> list = dao.getList(str);
		for(int i=0; i<list.size(); i++) {
			ResVO rvo = list.get(i);
			int resno = rvo.getResno();
			List<String> imgList = dao.getResImg(resno);
			rvo.setImgList(imgList);
		}
		req.setAttribute("list", list);
		String view = "/main_1.jsp";
		return view;
	}

}
