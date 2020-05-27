package com.yummymap.www.controller.board;
/**
 * @author	김소영
 * @since	2020.05.27
 *  이 클래스는 게시판 메인 페이지 컨트롤러 입니다
 */
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.util.*;
import com.yummymap.www.DAO.*;
import com.yummymap.www.controller.*;
import com.yummymap.www.vo.*;

public class BoardMain implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/boardMain.jsp";
		// 파라미터 받고
		int nowPage = 1;
		String strPage = req.getParameter("nowPage");
		try {
			nowPage = Integer.parseInt(strPage);
		} catch(Exception e) {}
		
		// 총 게시물 수
		BoardDAO bDAO = new BoardDAO();
		int totalCount = bDAO.getTotal();
		
		// 페이지 정보 객체 준비
		PageUtil page = new PageUtil(nowPage, totalCount, 10, 5);
		
		// 게시글 가져오고
		ArrayList<BoardVO> list = bDAO.getAllList(page);
		
		// 데이터 뷰에 심고
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		
		// 뷰 부르고
		return view;
	}

}