<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${row==1 }">
<script>
	alert("삭제가 완료되었습니다.");
	opener.location.replace("User?cmd=user_cover_letter_list");
	self.close();
</script>
</c:if>
	
<c:if test="${row==0 }">
<script>
	alert("삭제에 실패했습니다.");
	self.close();
</script>
</c:if>
