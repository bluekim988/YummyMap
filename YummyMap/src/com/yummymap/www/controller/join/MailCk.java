package com.yummymap.www.controller.join;
/**
 * @author 유태희
 * @since 2020.05.25
 * 	이 클래스는 회원가입 이메일인증 처리를 위한 클래스 입니다
 */
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.controller.MmyController;
import com.yummymap.www.util.MailUtil;
public class MailCk implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String mail = req.getParameter("email");
		
		
		MailUtil mailsend = new MailUtil("aktmzk117@naver.com", "yth1356yth");
		
		//인증번호 생성
		Random ran = new Random();
		StringBuffer tmp = new StringBuffer();
		for(int i=0; i<6; i++) {
			tmp.append(ran.nextInt(10));
		}
		
		String inck = tmp.toString();
		String title = "회원가입 인증 메일 입니다";
		StringBuffer mtxt = new StringBuffer();
		mtxt.append("<h2>반갑습니다. <b>YummyMap</b> 입니다.</h2> ");
		mtxt.append("<br> ");
		mtxt.append("<h3>요청 주신 인증 번호는 <b style=\"color: blue;\">"+inck+"</b> 입니다.</h3> ");
		mtxt.append("<br> ");
		mtxt.append("<h3>인증 번호 입력 란에 입력해주시고 인증 확인후 진행 부탁드립니다</h3> ");
		mtxt.append("<h3>감사합니다.</h3> ");
		
		
		mailsend.getSend(mail, title, mtxt.toString());
		StringBuffer buff = new StringBuffer();
		buff.append("{ \"emailCk\":");
		buff.append("\""+inck+"\"");
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
