package com.yummymap.www.controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.controller.MmyController;

public class SelectCateList implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String category = req.getParameter("category");
		System.out.println(category);
		return null;
	}
}
