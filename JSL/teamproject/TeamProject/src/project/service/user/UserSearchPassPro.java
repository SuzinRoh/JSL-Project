package project.service.user;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.user.UserDAO;
import project.util.RandomPassword;
import project.util.SHA256Util;

public class UserSearchPassPro implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String language = "";
		if (request.getHeader("accept-language") != null) {
			language = request.getHeader("accept-language");
			language = language.substring(0, 2);
		}
		String tempPass = "";
		String tempSha256 = "";
		
		String userid = request.getParameter("userid");
		String email = request.getParameter("email");

		UserDAO dao = UserDAO.getInstance();
		int row = dao.userFoundPass(userid, email);

		if (row == 1) {
			RandomPassword rp = new RandomPassword();
			tempPass = rp.getRamdomPassword(7);
			tempSha256 = SHA256Util.getEncSHA256(tempPass);
			
			dao.userPassUpdate(userid, email, tempSha256);
			
			String user = "mozambique530@gmail.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
			String password = "Qjrm7799@"; // 패스워드

			// SMTP 서버 정보를 설정한다.
			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", 465);
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.ssl.enable", "true");
			prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

			Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});

			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(user));

				// 수신자메일주소
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

				// Subject
				message.setSubject("임시 비밀번호가 발급되었습니다."); // 메일 제목을 입력

				// Text
				message.setText(userid+ "님의 임시번호는 " + tempPass + "입니다."); // 메일 내용을 입력

				// send the message
				Transport.send(message); //// 전송
				System.out.println("message sent successfully...");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		request.setAttribute("language", language);
		request.setAttribute("userid", userid);
		request.setAttribute("email", email);
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("User/User_Search_Pass_Pro.jsp");
		rd.forward(request, response);
	}

}
