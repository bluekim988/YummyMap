/**
 * @author 유태희
 * @since 2020.05.26
 * 	이클래스는 회원 패스워드 찾기 컨트롤러 입니다 (비동기)
 */
package com.yummymap.www.controller.join;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummymap.www.DAO.JoinDAO;
import com.yummymap.www.controller.MmyController;
import com.yummymap.www.util.MailUtil;

public class PassSearch implements MmyController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String mail = req.getParameter("mail");
		
		int cnt = 0;
		JoinDAO jdao = new JoinDAO();
		//해당 계정이 있는지 확인
		cnt = jdao.searchPass(id, mail);
		StringBuffer buff = new StringBuffer();
		if(cnt == 0) {
			buff.append("{ \"result\": ");
			buff.append("\"no\"");
			buff.append("}");
			try {
				resp.getWriter().write(buff.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//임시 패스워드 생성 
		String pass = setPassword(8);
		
		//임시 패스워드를 db에 저장하자 
		jdao.getTmpPass(pass, id);
		
		//사용자에게 메일로 임시 패스워드 전달
		MailUtil mailsend = new MailUtil("aktmzk117@naver.com", "yth1356yth");
		
		String title = "고객님의 계정 임시 패스워드 발송 안내 입니다.";
		StringBuffer mtxt = new StringBuffer();
		mtxt.append("<h2>반갑습니다. <b>YummyMap</b> 입니다.</h2> ");
		mtxt.append("<br> ");
		mtxt.append("<h3>고객님의 임시 비밀번호는 : <b style=\"color: blue;\">"+pass+"</b> 입니다.</h3> ");
		mtxt.append("<br> ");
		mtxt.append("<h3>로그인후 반드시 패스워드 변경 부탁드립니다. </h3> ");
		mtxt.append("<h3>감사합니다.</h3> ");
		
		mailsend.getSend(mail, title, mtxt.toString());
		
		buff.append("{ \"result\": ");
		buff.append("\"ok\"");
		buff.append("}");
		try {
			resp.getWriter().write(buff.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		String view = null;
		return view;
	}

	//임시 패스워드 생성 함수
	public String setPassword(int length) {
		int index = 0;
		char[] charArr = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' ,'!','@','-','_','$','*'};
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < length; i++) {
			index = (int) (charArr.length * Math.random());
			sb.append(charArr[index]);
		}
		
		return sb.toString();
	}

}
