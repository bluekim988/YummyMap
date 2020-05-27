package com.yummymap.www.controller.admin;
/**
 * @author 유태희
 * @since 2020.05.24
 *  이 클래스는 게시판 관리 컨트롤러 입니다
 */
import java.util.ArrayList;

import javax.servlet.http.*;

import com.yummymap.www.DAO.AdminDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.admin.BoardInfoVO;
import com.yummymap.www.util.*;

public class BoardList implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("SID");
		String view = "/admin/board.jsp";
		if (id == null || id.length() == 0) {
			view = "/YummyMap/admin/login.mmy";
		}

		int nowpage = 1;
		String spage = req.getParameter("nowpage");
		String sch = req.getParameter("searchs");
		String opt = req.getParameter("opts");
		
		try {
			nowpage = Integer.parseInt(spage);
		} catch (Exception e) {	}
		
		ArrayList<BoardInfoVO> list = null;
		PageUtil page = null;
		int boardCnt = 0;
		AdminDAO adao = new AdminDAO();
		if ( opt == null || opt.equals("nos") ) {
			boardCnt = adao.boardCnt();
			page = new PageUtil(nowpage, boardCnt, 10, 5);
			list = adao.boardList(page.getStartCont(), page.getEndCont());
		}else if(opt.equals("titlch")) {
			
			boardCnt = adao.titlCnt(sch);
			
			page = new PageUtil(nowpage, boardCnt, 10, 5);
			list = adao.boardTitl(sch, page.getStartCont(), page.getEndCont());
			req.setAttribute("SCH", sch);
			req.setAttribute("OPT", opt);
		}else if(opt.equals("idch")) {
			boardCnt = adao.boardNameCnt(sch);
			page = new PageUtil(nowpage, boardCnt, 10, 5);
			
			list = adao.boardId(sch, page.getStartCont(), page.getEndCont());
			req.setAttribute("SCH", sch);
			req.setAttribute("OPT", opt);			
		}
		
		
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		return view;
	}

}
