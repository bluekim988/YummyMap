package com.yummymap.www.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.controller.MmyController;

public class BoardDetail implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		
		
		String view = "/admin/boardDetail.jsp";
		
		return view;
	}

}
