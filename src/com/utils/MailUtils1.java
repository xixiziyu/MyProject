package com.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.handlers.message_rfc822;

public class MailUtils1 {
	/*public static void main(String[] args) throws Exception*/ public static void sendMail(String to,String code) throws Exception {
		
	/*	String to="";
		String code="icudiuciubeiubvkjernvkomrionvioneirv";*/
		
		Properties props=new Properties();
		props.setProperty("mail.host", "smtp.sohu.com");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		//1����session
		Session session = Session.getInstance(props);
		session.setDebug(true);
		Transport ts = session.getTransport();
		ts.connect("smtp.sohu.com","zengzhipeng0958","zengzhipeng12");
		Message message=createsimplemail(session,to,code);
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
		
	}

	private static Message createsimplemail(Session session,String to,String code) throws Exception, MessagingException {
		// TODO Auto-generated method stub
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("zengzhipeng0958@sohu.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("�˺ż����ʼ�");
		//2.4�����ʼ�������,��һ����������ָ�����͵��������ݣ��ڶ�����������ָ�����ĵ��ı�����
//		message.setContent("<h2>����һ��xx��վ�˺�ע�ἤ���ʼ���ȷ�ϼ����������³����ӣ�</h2><h3><a href='http://localhost:8080/regist_web/ActiveServlet?code="+code+"'>http://localhost:8080/regist_web/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=utf-8");
		message.setContent("<h2>����һ��xx��վ�˺�ע�ἤ���ʼ���ȷ�ϼ����������³����ӣ�</h2><h3><a href='http://172.16.29.245:8080/regist_web/Check.jsp?code="+code+"'>http://172.16.29.245:8080/regist_web/Check.jsp?code="+code+"</a></h3>", "text/html;charset=utf-8");
		
		
		return message;
	}

}
