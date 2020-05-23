package com.yummymap.www.controller.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.controller.MmyController;

public class Join implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/Register.jsp";
		return view;
	}

}
