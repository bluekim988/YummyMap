package com.yummymap.www.controller.admin;
/**
 * @author 유태희
 * @since 2020.05.24
 *  이 클래스는 관리자 정보 수정 페이지 컨트롤러 입니다
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummymap.www.DAO.*;
import com.yummymap.www.vo.admin.*;

import com.yummymap.www.controller.MmyController;

public class AdminEdit implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/admin/adminreview.jsp";
		
		HttpSession session = req.getSession();
		String sid = (String) session.getAttribute("SID");
		AdminDAO adao = new AdminDAO();
		MemberInfoVO mvo = adao.adminInfo(sid);
		
		req.setAttribute("MVO", mvo);
		return view;
	}

}
