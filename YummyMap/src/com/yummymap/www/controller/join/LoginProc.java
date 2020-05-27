package com.yummymap.www.controller.join;
/**
 * 이 클래스는 로그인 처리 메소드를 사용하여 일치여부에 따라 맞는 페이지로 리다이렉트 시켜주는 역할을 전담한다.
 * @author 임서진
 * @since 2020.05.27
 */
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummymap.www.controller.MmyController;
import com.yummymap.www.DAO.*;
public class LoginProc implements MmyController {

   @Override
   public String exec(HttpServletRequest req, HttpServletResponse resp) {
      // id 파라미터값을 가져와서 id 변수에 담고
      String id = req.getParameter("id");
      // pw 파라미터 값을 가져와서 pw 변수에  담고
      String pw = req.getParameter("pw");

      // 가져온 DAO 객체화 시키고
      JoinDAO jDAO = new JoinDAO();
      // cnt 함수에 checkLogin 함수 실행결과를 담고
      int cnt = jDAO.checkLogin(id, pw);
      // cnt 값이 1과 같으면
      if(cnt == 1 ) {
         // HttpSession 타입의 session 변수에 getSession 함수 결과를 담고
         HttpSession session = req.getSession();
         // id 변수에 담긴 값을 sid라는 세션 속성값에 담고
         session.setAttribute("sid", id);
         try {
            // 메인 화면으로 리다이렉트
            resp.sendRedirect("/YummyMap/main.mmy");
         } catch (IOException e) {}
         // cnt 값이 0과 같으면
      } else if (cnt == 0) {
         try {
            // 회원가입 화면으로 리다이렉트
            resp.sendRedirect("/YummyMap/join/login.mmy?r=x");
         } catch (IOException e) {}
      }

      return null;
   }
}