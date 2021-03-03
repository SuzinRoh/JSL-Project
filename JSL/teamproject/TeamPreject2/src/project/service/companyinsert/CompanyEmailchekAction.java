package project.service.companyinsert;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;


public class CompanyEmailchekAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		/* + "<a href='" + host + "CompanyInset?cmd=company_emailchk&id=" +
	    		  vo.getCom_id() + "&code=" + new SHA256Util().getEncSHA256(to) + "'>이메일 인증하기</a>";*/
		
		   // System.out.println("company email check action");
		  	String id = request.getParameter("id");
		  
		  	
		  	// 메일 인코딩
		    String bodyEncoding = "UTF-8"; //콘텐츠 인코딩
		    
		    String subject = "메일 발송 테스트";
		    String fromEmail = "test.suuz@gmail.com";
		    String fromUsername = "LINKEDJSL";
		    String toEmail = request.getParameter("email"); // 콤마(,)로 여러개 나열
		    
		    String username = "test.suuz@gmail.com";         
		    String password = "tnwls8201test";
		    String host = "http://localhost:8081/";
		    
		    // 메일에 출력할 텍스트
		    StringBuffer sb = new StringBuffer();
		    sb.append("<h3>회원가입을 축하드립니다.</h3>\n");
		    sb.append("<h4>LINKEDJSL입니다.</h4>\n");  
		    sb.append("<h4></h4>\n");  
		    sb.append("<a href='"+host+"Company?cmd=company_emailchk_pro&id="+id+"'>이메일 인증하기</a>");   
		    String html = sb.toString();

	      
	      // 메일 옵션 설정
	      Properties props = new Properties();    
	      props.put("mail.transport.protocol", "smtp");
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.port", "465");
	      props.put("mail.smtp.auth", "true");
	   
	      props.put("mail.smtp.quitwait", "false");
	      props.put("mail.smtp.socketFactory.port", "465");
	      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	      props.put("mail.smtp.socketFactory.fallback", "false");
	      
	      try {
	        // 메일 서버  인증 계정 설정
	        Authenticator auth = new Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	          }
	        };
	        
	        // 메일 세션 생성
	        Session session = Session.getInstance(props, auth);
	        
	        // 메일 송/수신 옵션 설정
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(fromEmail, fromUsername));
	        message.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail, false));
	        message.setSubject(subject);
	        message.setSentDate(new Date());
	        
	        // 메일 콘텐츠 설정
	        Multipart mParts = new MimeMultipart();
	        MimeBodyPart mTextPart = new MimeBodyPart();
	        MimeBodyPart mFilePart = null;
	   
	        // 메일 콘텐츠 - 내용
	        mTextPart.setText(html, bodyEncoding, "html");
	        mParts.addBodyPart(mTextPart);
	              
	        // 메일 콘텐츠 설정
	        message.setContent(mParts);
	        
	        // MIME 타입 설정
	        MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
	        MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
	        MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
	        MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
	        MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
	        MailcapCmdMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
	        CommandMap.setDefaultCommandMap(MailcapCmdMap);
	   
	        // 메일 발송
	        Transport.send( message );
	        
	      } catch ( Exception e ) {
	        e.printStackTrace();
	      }
	      
		
	}

}
