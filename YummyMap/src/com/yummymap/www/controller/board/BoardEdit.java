package com.yummymap.www.controller.board;
/**
 * @author	김소영
 * @since	2020.05.27
 *  이 클래스는 게시판 글 수정페이지 컨트롤러 입니다
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.BoardDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.BoardVO;

public class BoardEdit implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/boardEdit.jsp";
//		String catno = req.getParameter("catno");
		String txtno = req.getParameter("txtno");
		System.out.println("edit.txtno : " + txtno);
		int sno = 0;
		int cat = 0;
		try {
			sno = Integer.parseInt(txtno);
//			cat = Integer.parseInt(catno);
		} catch (Exception e) {
		}
		System.out.println("edit.sno : " + sno);

		String title = req.getParameter("title");
		String mtxt = req.getParameter("mtxt");
//		System.out.println("edit.cat : " + cat);
		System.out.println("edit.title : " + title);
		System.out.println("edit.mtxt : " + mtxt);
//		req.setAttribute("txtno", txtno);
//		req.setAttribute("title", title);
//		req.setAttribute("mtxt", mtxt);

		BoardDAO bDAO = new BoardDAO();
//		BoardVO bVO = bDAO.getConnect(sno);
//		req.setAttribute("bVO", bVO);
		return view;
	}

}