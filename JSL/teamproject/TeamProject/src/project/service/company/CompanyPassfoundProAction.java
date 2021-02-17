package project.service.company;

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
import project.domain.company.CompanyDAO;
import project.util.SHA256Util;
import project.util.pass_random;

public class CompanyPassfoundProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String com_id = request.getParameter("com_id");
		String com_email = request.getParameter("com_email");
		CompanyDAO dao = CompanyDAO.getInstanceof();
		int samerow = dao.CompanyPassFound(com_id, com_email);

		String tempPass = ""; // 임시비밀번호 선언
		String tempShaPass = ""; // 암호화비밀번호 선언
		//여기는 윤홍철의 메일입니다.
		String myuser = "organicferrum@gmail.com";
		String mypassword = "tjrhenwhrkr1!A";
		// --------------렝귀지관련시작-----
		String language = "";
		if(request.getHeader("accept-language")!=null) {
			language = request.getHeader("accept-language");
		}
		language = language.substring(0,2);
		request.setAttribute("language", language);
		//---------------랭귀지관련끝-------
		pass_random pr = new pass_random(); // util에 있는 랜덤함수 객체선언
		if(samerow == 1) {
			//비밀번호 시작-----
			tempPass = pr.MakeRandomPass(7); // 랜덤비밀번호 생성
			tempShaPass = SHA256Util.getEncSHA256(tempPass); //랜덤비밀번호암호화
			dao.CompanyPassUpdate(com_id, com_email, tempShaPass); //비밀번호 재설정
			//비밀번호 끝-----
			//이메일 보내기 시작-----------------------

			Properties prop = new Properties(); // java util의 properties
			prop.put("mail.smtp.host","smtp.gmail.com");
			prop.put("mail.smtp.port",465);
			prop.put("mail.smtp.auth","true");
			//prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.ssl.enable","true");
			prop.put("mail.smtp.ssl.trust","smtp.gmail.com");

			Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myuser, mypassword);
				}
			});
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(myuser));
				//수신자메일주소
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(com_email));
				//Subject
				message.setSubject("안녕하세요"); // 메일 제목을 입력
				//Contents
				message.setText("귀하의 비밀번호는"+tempPass+"입니다.");

				//send the message
				Transport.send(message);
				System.out.println("message sent successsss");



			}catch(AddressException e) {
				e.printStackTrace();
			}catch(MessagingException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("com_id", com_id);
		request.setAttribute("com_email", com_email);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Company/company_passfound_pro.jsp");
		rd.forward(request, response);
	}

}
