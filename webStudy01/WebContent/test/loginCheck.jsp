<%@page import="kr.or.ddit.utils.CookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CookieUtil cookies = new CookieUtil(request);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 여부 검사</title>
</head>
<body>
<%
	if(cookies.getCookie("AUTH")!=null){
%>
아이디 "<%=cookies.getCookieValue("AUTH") %>" 로 로그인 한 상태
<%
	}else{
%>
로그인하지 않은 상태
<%
	}
%>

</body>
</html>