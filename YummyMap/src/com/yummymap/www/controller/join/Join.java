package com.yummymap.www.controller.join;
/**
 * 회원가입화면 요청기능을 컨트롤하기위해 제작되었다.
 * 
 * @author	김종형
 * 
 */
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
