package com.utils;
import java.io.UnsupportedEncodingException;
import java.util.Date;
//�����ʼ����͹�����
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
		//1.�������Ӷ������ӵ����������
		Properties props = new Properties();
		Session session =Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				//ͨ����������û������������ӵ��������������o�����û������ʼ�
				return new PasswordAuthentication("service@peng.com", "123");
				
			}
			
			
		});
		
		//2.�����ʼ�����
		Message message=new MimeMessage(session);
		
		try {
			//2.1���÷�����
			message.setFrom(new InternetAddress("service@peng.com"));
//			message.setFrom(new InternetAddress("2548954500@qq.com"));
			//2.2�����ռ���
			message.setRecipient(RecipientType.TO,new InternetAddress(to) );
			//2.3�����ʼ���������ʲô
			message.setSubject("�˺ż����ʼ�");
			//2.4�����ʼ�������,��һ����������ָ�����͵��������ݣ��ڶ�����������ָ�����ĵ��ı�����
//			message.setContent("<h2>����һ��xx��վ�˺�ע�ἤ���ʼ���ȷ�ϼ����������³����ӣ�</h2><h3><a href='http://localhost:8080/regist_web/ActiveServlet?code="+code+"'>http://localhost:8080/regist_web/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=utf-8");
			message.setContent("<h2>����һ��xx��վ�˺�ע�ἤ���ʼ���ȷ�ϼ����������³����ӣ�</h2><h3><a href='http://localhost:8080/regist_web/Check.jsp?code="+code+"'>http://localhost:8080/regist_web/Check.jsp?code="+code+"</a></h3>", "text/html;charset=utf-8");
			//3.�����ʼ�
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
			message.setFrom(new InternetAddress(mymail, "���Լ�", "UTF-8"));
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to, "XX�û�", "UTF-8"));
			message.setSubject("�˺ż����ʼ�");
			//2.4�����ʼ�������,��һ����������ָ�����͵��������ݣ��ڶ�����������ָ�����ĵ��ı�����
//			message.setContent("<h2>����һ��xx��վ�˺�ע�ἤ���ʼ���ȷ�ϼ����������³����ӣ�</h2><h3><a href='http://localhost:8080/regist_web/ActiveServlet?code="+code+"'>http://localhost:8080/regist_web/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=utf-8");
			message.setContent("<h2>����һ��xx��վ�˺�ע�ἤ���ʼ���ȷ�ϼ����������³����ӣ�</h2><h3><a href='http://localhost:8080/regist_web/Check.jsp?code="+code+"'>http://localhost:8080/regist_web/Check.jsp?code="+code+"</a></h3>", "text/html;charset=utf-8");
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
