package com.yummymap.www.controller.main;
/**
 * 	이 클래스는 식당 찜 기능의 컨트롤을 담당하는 클래스입니다.
 * 
 * 	@author	김종형
 *  @since	2020/05/25
 *  @see	com.yummymap.www.DAO.MainDAO
 */

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.MainDAO;
import com.yummymap.www.controller.MmyController;

public class PickMyRes implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String userID = (String)req.getSession().getAttribute("sid");
		String resno_str = req.getParameter("resNo");
		int resno = 0;
		try {
			resno = Integer.parseInt(resno_str);
		} catch (Exception e) {}
		// 파싱에 실패시 인덱스화면으로 강제 이동합니다.
		if (resno == 0) {
			return "/YummyMap/main.mmy";
		}
		MainDAO mainDao = new MainDAO();
		int isPicked = mainDao.isPickedMyRes(userID, resno);

		if(isPicked == 1) {
			mainDao.removeMyRes(userID, resno);
		} else {
			mainDao.addMyRes(userID, resno);
		}
		try {
			resp.getWriter().write("{ \"result\":\"ok\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
