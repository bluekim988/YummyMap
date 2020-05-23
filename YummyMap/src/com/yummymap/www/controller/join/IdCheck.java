package com.yummymap.www.controller.join;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.JoinDAO;
import com.yummymap.www.controller.MmyController;

public class IdCheck implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		int cnt = new JoinDAO().idCheck(id);
		StringBuffer buff = new StringBuffer();
		buff.append("{ \"result\":");
		if(cnt != 1) {
			buff.append("\"ok\"");
		} else {
			buff.append("\"no\"");			
		}
		buff.append("}");
		
		try {
			resp.getWriter().write(buff.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
