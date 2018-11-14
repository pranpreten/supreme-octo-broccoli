<%@page import="kr.or.ddit.web.useragent.Practice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userAgent = request.getHeader("User-Agent");
	Practice practice = Practice.getPractice(userAgent);
	String browerName = practice.getBrowerName();
	String pattern = "해당접속 브라우저는 %s 입니다";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<%=String.format(pattern, browerName) %><br/>
	<%= userAgent%>
</div>

</body>
</html>