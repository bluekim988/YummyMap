package com.yummymap.www.controller.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummymap.www.DAO.TxtDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.util.PageUtil;
import com.yummymap.www.vo.member.TxtVO;

public class TxtList implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
				String view = "/member/text.jsp";
				int nowPage = 1;
				String mid = (String)req.getSession().getAttribute("sid");
				String strPage = req.getParameter("nowPage");
				try {
					nowPage = Integer.parseInt(strPage);
				} catch(Exception e) {}
				TxtDAO tDAO = new TxtDAO();
				int totalCount = tDAO.getTotal(mid);
				
				PageUtil page = new PageUtil(nowPage, totalCount, 5,5);
				
				ArrayList<TxtVO> list = tDAO.getTXTLIST(page,mid);
				
				req.setAttribute("LIST", list);
				req.setAttribute("PAGE", page);
				return view;
			}

}

