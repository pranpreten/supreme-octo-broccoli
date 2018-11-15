<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="kr.or.ddit.web.model2.FileList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String fileName = request.getParameter("fileNames");
	if(StringUtils.isBlank(fileName)){
		fileName = "";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goReset(){
		var form = document.reset;
		form.submit();
	}
	
	function goLowerPage(gogo){
		var form = document.goLower;
		form.res.value = gogo;
		form.submit();
	}
</script>
</head>
<body>
<div>
	<form name="reset" action="<%=request.getContextPath() %>/fileBrowser.do">
	<input type="button" value="../" onclick="javascript:goReset();"/>
	</form>
	
	<form name="goLower" action="<%=request.getContextPath() %>/tmp/fileList2">
	<input name="res" value="" type="hidden"/>
	</form>
	<ul>
	<%
		FileList fileVO = new FileList();
		String[] result = fileVO.getDetailFileList(fileName);
		for(String gogo:result){
			
			%>
			<li><a href="javascript:goLowerPage(<%=gogo %>);"><%=gogo %></a></li>
			<%
		}
	%>
	</ul>
</div>

</body>
</html>