package com.yummymap.www.controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.controller.MmyController;

public class Main implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/main_1.jsp";
		return view;
	}

}
