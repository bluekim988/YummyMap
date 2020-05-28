/**
 * @author 유태희
 * @since 2020.05.26
 * 	이클래스는 회원 ID 찾기 컨트롤러 입니다 (비동기)
 */
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
		StringBuffer buff = new StringBuffer();
		buff.append("{ \"result\": ");
		if(id.length() != 0) {
			buff.append("\"ok\", ");
			buff.append("\"id\": \"" + id +"\"");
		} else {
			buff.append("\"no\"");			
		}
		buff.append("}");
		try {
			resp.getWriter().write(buff.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String view = null;
		return view;
	}

}
