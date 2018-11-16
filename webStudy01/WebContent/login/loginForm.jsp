<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Objects"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String faildId = request.getParameter("mem_id");
	String message = (String)session.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login/loginForm.jsp</title>
<script type="text/javascript">
<%
if(StringUtils.isNotBlank(message)){
	
// 추가주석

// 추가주석 11111
%>
	alert("<%=message%>");
<%
	session.removeAttribute("message");	
}
%>

</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/login/loginCheck.jsp" method="post">
	<ul>
		<li>
			아이디 : <input type="text" name="mem_id" value="<%=Objects.toString(faildId,"")%>"/>
			<lable>
			<input type="checkbox" name="idChecked" value="idSaved"/>아이디기억하기
			</lable>
		</li>
		<li>
			비밀번호 : <input type="password" name="mem_pass" value=""/>
			<input type="submit" value="로그인"/>
		</li>
		
	</ul>

</form>

</body>
</html>