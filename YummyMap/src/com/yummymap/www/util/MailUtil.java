package com.yummymap.www.util;
/**
 * @author 유태희
 * @since 2020.05.25
 *  이 클래스는 메일 발송 담당 클래스 입니다
 */

import java.util.*;
import java.io.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class MailUtil {
	Session session;
	String user;
	String pass;

	public MailUtil(String id , String pw) {
		String host = "smtp.naver.com";
		 user= id;
		 pass= pw;
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host",host);
		prop.put("mail.smtp.port",465);
		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.ssl.enable","true");
		prop.put("mail.smtp.starttls.enable","true");
		prop.put("mail.debug","true");
		session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
	}
	
	public int getSend(String from) {
		int cnt = 0;
		String getFrom = from;
		
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(user));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(getFrom));
	
			msg.setSubject("호로로로로"); //메일 제목
			msg.setText("정상 발송 테스트 메일"); //메일 본문
			
			Transport.send(msg);
			cnt = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	
}
