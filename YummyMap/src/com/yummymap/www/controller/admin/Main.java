package com.yummymap.www.controller.admin;
/**
 * @author 유태희
 * @since 2020.05.23
 *  이 클래스는 메인페이지(사용자 관리) 페이지 컨트롤러 입니다
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import com.yummymap.www.controller.MmyController;
import com.yummymap.www.DAO.*;
import com.yummymap.www.vo.admin.*;
import com.yummymap.www.util.*;

public class Main implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("SID");
		String view = "/admin/main.jsp";
		if(id == null || id.length() == 0) {
			view = "/YummyMap/admin/login.mmy";
		}
		
		int nowpage = 1;
		String spage = req.getParameter("nowpage");
		String sch = req.getParameter("searchs");
		String opt = req.getParameter("opts");
		
			try {
				nowpage = Integer.parseInt(spage);
			} catch (Exception e) {	}
	
		AdminDAO adao = new AdminDAO();
	
		ArrayList<MemberInfoVO> list = null;
		PageUtil page = null;
		int userCnt = 0;
		
		if(opt == null || opt.equals("nos")) {
			userCnt = adao.userCnt();
			page = new PageUtil(nowpage, userCnt, 10, 5);
			list = adao.pageUser(page.getStartCont(), page.getEndCont());
		}
		else if(opt.equals("idch")) {
			userCnt = adao.userIdCnt(sch);
			page = new PageUtil(nowpage, userCnt, 10, 5);
			list = adao.idUser(page.getStartCont(), page.getEndCont(), sch);
			req.setAttribute("SCH", sch);
			req.setAttribute("OPT", opt);
			
		}else if(opt.equals("namech")) {
			userCnt = adao.userNameCnt(sch);
			page = new PageUtil(nowpage, userCnt, 10, 5);
			list = adao.nameUser(page.getStartCont(), page.getEndCont(), sch);
			req.setAttribute("SCH", sch);
			req.setAttribute("OPT", opt);
		}

		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		
		return view;
	}

}
