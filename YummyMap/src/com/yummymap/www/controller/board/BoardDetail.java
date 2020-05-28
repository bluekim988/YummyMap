package com.yummymap.www.controller.board;
/**
 * 이 클래스는 게시판 상세페이지로 포워딩하기위해 제작되었다.
 * 
 * @author	유태희
 * @since	2020/05/28
 * @see		com.yummymap.www.DAO.BoardDAO
 */
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.BoardDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.BoardVO;

public class BoardDetail implements MmyController {
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String userID = "no";
		String userID_session = (String)req.getSession().getAttribute("sid");
		if(userID_session != null) {
			userID = userID_session;
		}
		String view = "/board/boardDetail.jsp";
		// 할일
		// 파라미터 받고
		String stno = req.getParameter("txtno");
		int tno = 0;
		try {
			tno = Integer.parseInt(stno);
		} catch (Exception e) {}
		BoardDAO bdao = new BoardDAO();
		
		BoardVO bVO = bdao.getTextInfo(tno,userID);
		
		Cookie[] cookieFromReq = req.getCookies();
		Cookie cookieVal = null;
		if (cookieFromReq != null && cookieFromReq.length > 0) {
			for (int i = 0; i < cookieFromReq.length; i++) {
				if (cookieFromReq[i].getName().equals("cookie" + stno)) {
					cookieVal = cookieFromReq[i];
				}
			}
		}

		if(bVO != null) {
			
			if(cookieVal == null) {
				
				//쿠키 생성(이름,값)
				Cookie newCookie = new Cookie("cookie"+stno, "|"+ stno + "|");
				
				//쿠키 추가
				resp.addCookie(newCookie);
				
				int cnt = bdao.increaseTxtCount(tno);
			}else {
				String cookies = cookieVal.getValue();
			
			}
		}
		
		
		List<BoardVO> list = bdao.getAllReplyList(tno);
		int replyCount = 0;
		if(list.size() > 0 ) {
			replyCount = list.get(0).getCount();
		}
		
		req.setAttribute("LIST", list);
		req.setAttribute("DATA", bVO);
		req.setAttribute("replyCount", replyCount);

//		bVO.setBdate(req.getParameter("bdate"));
//		bVO.setMid(req.getParameter("mid"));
//		bVO.setLv(Integer.parseInt(req.getParameter("lv")));
//		bVO.setRnum(Integer.parseInt(req.getParameter("rnum")));
//		bVO.setCatno(Integer.parseInt(req.getParameter("catno")));
		req.setAttribute("nowPage", req.getParameter("nowPage"));
//		
		
		return view;
	}

}
