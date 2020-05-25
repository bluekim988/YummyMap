package com.yummymap.www.controller.admin;
/**
 * @author 유태희
 * @since 2020.05.23
 *  이 클래스는 로그인 페이지 컨트롤러 입니다
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.controller.MmyController;

public class Login implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/admin/adminLogin.jsp";
		return view;
	}

}
