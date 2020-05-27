package com.yummymap.www.controller.join;
/**
 * 이 클래스는 로그아웃 처리를 구현하기 위한 역할을 전담한다.
 * @author 임서진
 * @since 2020.05.27
 */
import javax.servlet.http.*;


import com.yummymap.www.controller.MmyController;

public class LogoutProc implements MmyController {

   public String exec(HttpServletRequest req, HttpServletResponse resp) {
      // HttpSession 타입의 session 변수에 getSession 함수로 HttpSession 객체 받고
      HttpSession session = req.getSession();
      // sid 변수에 sid 세션 속성 값을 담고
      String sid = (String)session.getAttribute("sid");
      // 뷰를 지정하고
      String view = "/YummyMap/main.mmy";
      // 세션에 sid가 없으면
      if(sid == null) {
         // 메인으로 돌려보낸다.
         return view;
      }
      // 세션에 아이디가 있으면 sid 값을 지우고
      session.removeAttribute("sid");
      // 메인으로 돌려보낸다.
      return view;
   }
}