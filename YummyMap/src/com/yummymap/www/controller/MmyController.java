package com.yummymap.www.controller;

/**
 * 이 클래스는 디스패치 컨트롤러에서 요청을 처리할 때 사용할 클래스들의
 * 다형성 구현을 위해서 만든 인터페이스
 * 
 * fowrd 할 경우 확장자 .jsp 리턴
 * sendRedirect 할 경우 확장자 .mmy 리턴
 * 
 * @author 김종형
 * @since  2020.05.17
 */
import javax.servlet.http.*;

public interface MmyController {
	String exec(HttpServletRequest req, HttpServletResponse resp);
}
