package com.yummymap.www.controller.admin;
/**
 * @author 유태희
 * @since 2020.05.23
 *  이 클래스는 사용자 정보 상세보기 컨트롤러 입니다
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import com.yummymap.www.controller.MmyController;
import com.yummymap.www.DAO.*;
import com.yummymap.www.vo.admin.*;
public class RememberView implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/admin/remember.jsp";
		
		String smno = req.getParameter("mno");
		int mno = 0;
		try {
			mno = Integer.parseInt(smno);
		} catch (Exception e) {	}
		
		AdminDAO adao = new AdminDAO();
		MemberInfoVO mvo = adao.reUser(mno);
		
		req.setAttribute("MVO", mvo);
		req.setAttribute("MNO", mno);
		
		return view;
	}

}
