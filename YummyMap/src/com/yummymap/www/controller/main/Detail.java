package com.yummymap.www.controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.controller.MmyController;

public class Detail implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String resno_ = req.getParameter("r");
		System.out.println("########################");
		System.out.println(resno_);
		return null;
	}

}
