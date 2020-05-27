package com.yummymap.www.controller.join;
/**
 * 이 클래스는 로그인 화면을 구현하기 위한 역할을 전담한다.
 * @author 임서진
 * @since 2020.05.27
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.yummymap.www.controller.MmyController;

public class Login implements MmyController {

   @Override
   public String exec(HttpServletRequest req, HttpServletResponse resp) {
      // 뷰를 지정하고
      String view = "/member/Login.jsp";
      // 로그인 유무확인
      // setAttribute 함수를 사용하여 받아온 sid 정보를 SID에 담고
      HttpSession session = req.getSession();
      String sid = (String)session.getAttribute("sid");
      // 세션에 sid가 담겨있으면
      if (sid != null ) {
         // 홈화면으로 포워딩해주고
         view = "/YummyMap/main.mmy";
      }
      return view;
   }
}