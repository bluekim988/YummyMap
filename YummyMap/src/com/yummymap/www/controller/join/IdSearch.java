package com.yummymap.www.controller.join;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.JoinDAO;
import com.yummymap.www.controller.MmyController;

public class IdSearch implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		JoinDAO jdao = new JoinDAO();
		String id = jdao.searchId(name, mail);
		System.out.println(id);
		StringBuffer buff = new StringBuffer();
		buff.append("{ \"result\": ");
		if(id.length() != 0) {
			buff.append("\"ok\", ");
			buff.append("\"id\": \"" + id +"\"");
		} else {
			buff.append("\"no\"");			
		}
		buff.append("}");
		
		System.out.println(buff.toString());
		try {
			resp.getWriter().write(buff.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String view = null;
		return view;
	}

}
