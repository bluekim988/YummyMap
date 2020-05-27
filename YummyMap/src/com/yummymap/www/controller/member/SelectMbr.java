package com.yummymap.www.controller.member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yummymap.www.DAO.ChangeDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.member.*;;

public class SelectMbr implements MmyController {

	public String exec(HttpServletRequest req, HttpServletResponse resp) {
			String view ="/member/member.jsp";
			//로그인 사용자 정보조회
			ChangeDAO gDAO = new ChangeDAO();
			String mid = (String) req.getSession().getAttribute("sid");
			ChangeVO memberInfo = gDAO.getMemberInfo(mid);

			req.setAttribute("memberInfo", memberInfo);
			
			return view;
	}

}
