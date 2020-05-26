package com.yummymap.www.controller.admin;
/**
 * @author 유태희
 * @since 2020.05.24
 *  이 클래스는 게시물 삭제 컨트롤러 입니다
 */
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.AdminDAO;
import com.yummymap.www.controller.MmyController;

public class CheckDel implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String nowpage = req.getParameter("nowpage");
		String opt = req.getParameter("opts");
		String sch = req.getParameter("searchs");
		
		//체크드된 번호 가져오기
		String alltxtno = req.getParameter("nos");
		//"," 를 기준으로 자르기 
		String[] stxtno = alltxtno.split(",");
		//자른값 저장할 list 생성
		ArrayList<Integer> txtno = new ArrayList<Integer>();
		// list에 넣기 
		for(String tmp : stxtno) {
			txtno.add(Integer.parseInt(tmp));
		}
		
		AdminDAO adao = new AdminDAO();
		
		for(int txtnos : txtno) {
			adao.delBoard(txtnos);
		}
		

		
		String view = null;
		try {
			resp.sendRedirect("/YummyMap/admin/boardList.mmy?nowpage="+nowpage+"&opts="+opt+"&searchs="+sch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return view;
	}

}
