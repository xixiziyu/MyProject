package com.utils;
import java.io.UnsupportedEncodingException;
import java.util.Date;
//激活邮件发送工具类
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {
	public static void sendMail(String to,String code) {
		//1.创建链接对象，链接到邮箱服务器
		Properties props = new Properties();
		Session session =Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				//通过下面这个用户名和密码链接到服务器，由他給其他用户发送邮件
				return new PasswordAuthentication("service@peng.com", "123");
				
			}
			
			
		});
		
		//2.创建邮件对象
		Message message=new MimeMessage(session);
		
		try {
			//2.1设置发件人
			message.setFrom(new InternetAddress("service@peng.com"));
//			message.setFrom(new InternetAddress("2548954500@qq.com"));
			//2.2设置收件人
			message.setRecipient(RecipientType.TO,new InternetAddress(to) );
			//2.3设置邮件的主题是什么
			message.setSubject("账号激活邮件");
			//2.4设置邮件的正文,第一个参数用于指定发送的正文内容，第二个参数用于指定正文的文本类型
//			message.setContent("<h2>这是一封xx网站账号注册激活邮件，确认激活请点击以下超链接：</h2><h3><a href='http://localhost:8080/regist_web/ActiveServlet?code="+code+"'>http://localhost:8080/regist_web/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=utf-8");
			message.setContent("<h2>这是一封xx网站账号注册激活邮件，确认激活请点击以下超链接：</h2><h3><a href='http://localhost:8080/regist_web/Check.jsp?code="+code+"'>http://localhost:8080/regist_web/Check.jsp?code="+code+"</a></h3>", "text/html;charset=utf-8");
			//3.发送邮件
			Transport.send(message);
 
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	/*	Properties props =new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", "smtp.qq.com");
		props.setProperty("mail.smtp.auth", "true");
		
		final String smtpPort="465";
		props.setProperty("mail.smtp.port", smtpPort);
		props.setProperty("mail.smtp.scoketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);

        Session session = Session.getInstance(props);
        session.setDebug(true);       
        MimeMessage message = createMimeMessage(session, "2548954500@qq.com", to,code);
        Transport transport;
		try {
			transport = session.getTransport();
			transport.connect("2548954500@qq.com", "zp11142400160019");
			 transport.sendMessage(message, message.getAllRecipients());
		        transport.close();
		} catch (NoSuchProviderException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
      
       

	}

/*	private static MimeMessage createMimeMessage(Session session, String mymail, String to, String code) {
		// TODO Auto-generated method stub
		 MimeMessage message = new MimeMessage(session);
		 try {
			message.setFrom(new InternetAddress(mymail, "我自己", "UTF-8"));
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to, "XX用户", "UTF-8"));
			message.setSubject("账号激活邮件");
			//2.4设置邮件的正文,第一个参数用于指定发送的正文内容，第二个参数用于指定正文的文本类型
//			message.setContent("<h2>这是一封xx网站账号注册激活邮件，确认激活请点击以下超链接：</h2><h3><a href='http://localhost:8080/regist_web/ActiveServlet?code="+code+"'>http://localhost:8080/regist_web/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=utf-8");
			message.setContent("<h2>这是一封xx网站账号注册激活邮件，确认激活请点击以下超链接：</h2><h3><a href='http://localhost:8080/regist_web/Check.jsp?code="+code+"'>http://localhost:8080/regist_web/Check.jsp?code="+code+"</a></h3>", "text/html;charset=utf-8");
			message.setSentDate(new Date());
			message.saveChanges();
			Transport.send(message);

			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return message;
	}*/

}
