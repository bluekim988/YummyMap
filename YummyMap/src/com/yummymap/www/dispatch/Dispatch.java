package com.yummymap.www.dispatch;

/**
 * 이 클래스는 확장자가 mmy로 요청이 되는 경우 Dispatch시킬 서블릿 클래스이다.
 * 
 * @author	김종형
 * @since	2020.05.17
 * @see
 * 			com.yummymap.www.controller.MmyController
 */
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.yummymap.www.controller.MmyController;

import java.io.*;
import java.util.*;

@WebServlet("*.mmy")
public class Dispatch extends HttpServlet {

	
	public HashMap<String, MmyController> map;
	
	public void init(ServletConfig config) throws ServletException {

		Properties prop = new Properties();
		FileInputStream fin = null;
		try {
			String path = this.getClass().getResource("").getPath();
			fin = new FileInputStream(path + "../resource/mmy.properties");
			prop.load(fin);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (Exception e2) {}
		}
		
		map = new HashMap<String, MmyController>();
		
		Set keys = prop.keySet();

		Iterator itr = keys.iterator();
		while(itr.hasNext()) {
			String key = (String)itr.next();
			String sclass = (String) prop.get(key);
			try {
				Class tmp = Class.forName(sclass);
				MmyController mmy = (MmyController)tmp.newInstance();
				map.put(key, mmy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// 실제 요청 내용에 맞는 처리를 담당하는 함수
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String full = req.getRequestURI();
		String domain = req.getContextPath();
		String realPath = full.substring(domain.length());
		
		MmyController mmy = map.get(realPath);
		String view = mmy.exec(req, resp);
		if(view == null) return;
		
		// sendRedirect 시킬경우 확장자 .mmy로 요청
		String viewLast = view.substring(view.lastIndexOf('.')+1);
		if(viewLast.equals("mmy")) {
			resp.sendRedirect(view);
			return;
		}
		
		
		// forward 시킬경우 확장자 .jsp로 요청
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, resp);

	}
}
