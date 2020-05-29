package com.yummymap.www.controller.main;
/**
 * 메인페이지 검색엔진에 검색을 요청했을때
 * 컨트롤하기위해 제작된 클래스입니다.
 * 
 * @author	김종형
 * @see		com.yummymap.www.DAO.MainDAO
 */
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.GameDAO;
import com.yummymap.www.DAO.MainDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.vo.*;

public class SearchList implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String str = req.getParameter("q");
		// 유저가 해당식당을 픽했는지 여부를 찾기위해 사용될값입니다.
		String userID = "no";
		String userID_param = (String)req.getSession().getAttribute("sid");
		if(userID_param != null) {
			userID = userID_param;
		}
		MainDAO dao = new MainDAO();
		// 검색어를 메뉴컬럼에서 조회한 리스트입니다
		List<ResVO> list = dao.getList(str, userID);
		// 검색어를 식당이름컬럼에서 조회한 리스트입니다
		List<ResVO> listUseResName = dao.getListUseName(str, userID);
		
		if(list.size() == 0) {
			list = listUseResName;
		} else {
			for(int i = 0; i<list.size(); i++) {
				for(int j = 0; j<listUseResName.size(); j++) {
					if(list.get(i).getResno() == listUseResName.get(j).getResno()) {
						listUseResName.remove(j);
						break;
					}
				}
			}
			for(int i=0; i<listUseResName.size(); i++) {
				list.add(listUseResName.get(i));
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			ResVO rvo = list.get(i);
			int resno = rvo.getResno();
			List<String> imgList = dao.getResImg(resno);
			rvo.setImgList(imgList);
		}
		
		//카테고리 리스트를 가져옵니다.
		GameDAO gameDao = new GameDAO();
		List<String> cateList = gameDao.getAllCateList();
		
		
		req.setAttribute("list", list);
		req.setAttribute("cateList", cateList);
		String view = "/main_1.jsp";

		return view;
	}

}
