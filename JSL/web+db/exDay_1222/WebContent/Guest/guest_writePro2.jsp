<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");

	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String myUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String myId = "jslhrd46";
	String myPass = "1234";
%>

<%
	// DB 연동 테스트
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	try {
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myUrl, myId, myPass);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	
	String query = "insert into tbl_guest2(idx,name,pass,subject,contents) "+
			"values(tbl_guest_seq_idx2.nextval,?,?,?,?) ";
	psmt = conn.prepareStatement(query);
	psmt.setString(1, name);
	psmt.setString(2, password);
	psmt.setString(3, subject);
	psmt.setString(4, contents);
	
	int row = psmt.executeUpdate();
	if (row == 1) {
%>
<script>
	alert("작성이 완료되었습니다.");
	location.href="guest_list.jsp";
</script>
<%
	} else {
%>
<script>
	alert("요청하신 작업에 실패하였습니다.");
	history.back();
</script>
<%
	}
%>