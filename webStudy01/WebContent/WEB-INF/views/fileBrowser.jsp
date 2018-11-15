<%@page import="kr.or.ddit.web.model2.FileList"%>
<%@page import="java.util.Objects"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String[] fileList = (String[])request.getAttribute("file");
String names = request.getParameter("fileName");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goFile(tmp){
		var form = document.FileForm;
		
		form.fileNames.value = tmp;
		form.submit();
	}
	
</script>
<style type="text/css">
div{
	width: 80%;
	height: 500px;
	float: center;
	border : solid 1px blue;
}
</style>
</head>
<body>
<form name="FileForm" action="<%=request.getContextPath() %>/tmp/fileList.jsp">
<input name="fileNames" value="" type="hidden"/>
</form>
<ul>
<%
	for(String tmp:fileList){
		
		%>
		<li><a href="javascript:goFile('<%=tmp %>');"><%=tmp %></a></li>
		<%
	}
%>
</ul>


</body>
</html>
