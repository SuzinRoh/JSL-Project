/**
 * 
 */
package project.service.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.util.Gmail;
import project.util.SHA256Mail;

/**
 * @author gktjs
 *
 */
public class UserEmailAuth implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		
		int row = 1;
		String host = "http://localhost:8089/User?";		
		String from = "k2n2a4last@gmail.com";
		String to = request.getParameter("useremail");
		String code = SHA256Mail.getEncrypt(to, "cos");

		//����ڿ��� ���� �޽���
		String subject = "LINKEDJSL 사이트의 이메일 인증입니다.";
		String content = "LINKEDJSL에 회원가입을 해주셔서 감사합니다. " 
		        + "<a href='" + host + "cmd=user_gmailCheck&code=" + code
				+ "'를 눌러주세요.</a>";

		Properties p = new Properties();
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.host", "smtp.googlemail.com");
		p.put("mail.smtp.port", "465"); //TLS 587, SSL 465
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465"); 
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.sockerFactory.fallback", "false");

		try {
			Authenticator auth = new Gmail();
			Session ses = Session.getInstance(p, auth);
			ses.setDebug(true);
			MimeMessage msg = new MimeMessage(ses);
			msg.setSubject(subject);
			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content, "text/html; charset=UTF8");
			Transport.send(msg);
		} catch (Exception e) {
			row = 0;
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('�̸��� ���� ����')");
			script.println("history.back();");
			script.println("</script>");
		}
		
		request.setAttribute("row", row);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/User/user_email_pro.jsp");
		dispatcher.forward(request, response);
		
	}

}
