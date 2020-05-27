package com.yummymap.www.controller.board;

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
					System.out.println("처음 쿠키값");
					cookieVal = cookieFromReq[i];
					System.out.println("처음 쿠기 값 입니다 : " + cookieVal.getValue());
				}
			}
		}

		if(bVO != null) {
			System.out.println("bvo 있음");
			
			if(cookieVal == null) {
				System.out.println("쿠키 없음");
				
				//쿠키 생성(이름,값)
				Cookie newCookie = new Cookie("cookie"+stno, "|"+ stno + "|");
				
				//쿠키 추가
				resp.addCookie(newCookie);
				
				int cnt = bdao.increaseTxtCount(tno);
				if(cnt == 1) {
					System.out.println("정상 증가");
				}else {
					System.out.println("조회수 증가 오류");
				}
			
			}else {
				String cookies = cookieVal.getValue();
				System.out.println("쿠키 값 :   " + cookies);
			
			}
		}
		
		
		List<BoardVO> list = bdao.getAllReplyList(tno);
		
		req.setAttribute("LIST", list);
		req.setAttribute("DATA", bVO);

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
