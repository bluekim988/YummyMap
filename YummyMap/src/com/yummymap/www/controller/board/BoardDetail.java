package com.yummymap.www.controller.board;

/**
 * @author	김소영
 * @since	2020.05.27
 *  이 클래스는 게시판 글 상세보기 페이지 컨트롤러 입니다
 */
import java.util.*;
import javax.servlet.http.*;

import com.yummymap.www.controller.*;
import com.yummymap.www.DAO.*;
import com.yummymap.www.vo.*;

public class BoardDetail implements MmyController {
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/boardDetail.jsp";
		// 할일
		// 파라미터 받고
		String stno = req.getParameter("txtno");
		int tno = 0;
		try {
			tno = Integer.parseInt(stno);
		} catch (Exception e) {}
		BoardDAO bdao = new BoardDAO();
		BoardVO bVO = bdao.getTextInfo(tno);
		
		Cookie[] cookieFromReq = req.getCookies();
		Cookie cookieVal = null;
		if (cookieFromReq != null && cookieFromReq.length > 0) {
			for (int i = 0; i < cookieFromReq.length; i++) {
				if (cookieFromReq[i].getName().equals("cookie" + stno)) {
					System.out.println("처음 쿠키가 없을 경우 null 생성");
					cookieVal = cookieFromReq[i];
					System.out.println();
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
