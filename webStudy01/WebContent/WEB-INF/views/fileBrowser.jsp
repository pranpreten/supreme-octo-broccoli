<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	File[] fileList = (File[])request.getAttribute("fileList");
	String fileUrl = (String)request.getAttribute("fileUrl");
	String path = fileUrl.substring(0,fileUrl.lastIndexOf("\\"));
	String noBack = application.getRealPath("");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	ul {
		 list-style:none;
	}
</style>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous">
</script>
<script type="text/javascript">
	$(function(){
		$(".go").dblclick(function() {
			var value = $(this).attr("value");
			//alert(value);
			$("input[name=filePath]").val(value);
			$("#send").submit();
		})
	});
	$(function(){
		$(".goBack").click(function() {
			var value = $("input[name=fileBackPath]").attr("value");
			$("input[name=fileBackPath]").val(value);
			$("#sendBack").submit();
		})
	});
	
</script>
</head>
<body>
<%
	if(!fileUrl.equals(noBack)){
		%>
			<form id="sendBack" name="backForm" action="<%=request.getContextPath() %>/fileBrowser.do">
				<input type="button" value="<<=" class="goBack">
				<input name="fileBackPath" type="hidden" value="<%=path%>">
			</form>
		
		<%
	}
%>

<!-- String tmp = path.substring(0,fileUrl.lastIndexOf("\\")+1); -->
<form id="send" name="bform" action="<%=request.getContextPath() %>/fileBrowser.do">
	<input name="filePath" type="hidden" value="">
</form>
	<ul>
		<%	
		for(File f : fileList) {
			if(f.isFile()) {
			%>
				<li value="<%=f.getPath()%>">File : <%=f.getName() %></li>
			<%			
			}else {
			%>
				<li class="go" value="<%=f.getPath()%>">Folder : <%=f.getName() %></li>
			<%			
			}
		}
		%>	
	</ul>

</body>
</html>