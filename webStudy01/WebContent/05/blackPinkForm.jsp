<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Map<String, String[]> singerMap = new LinkedHashMap<>();
{
	singerMap.put("B001", new String[]{"jenny","WEB-INF/blackPink/jenny.jsp"});	
	singerMap.put("B002", new String[]{"jisu","WEB-INF/blackPink/jisu.jsp"});	
	singerMap.put("B003", new String[]{"lisa","WEB-INF/blackPink/lisa.jsp"});	
	singerMap.put("B004", new String[]{"roze","WEB-INF/blackPink/roze.jsp"});	

}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05/blackPinkForm.jsp</title>
<script type="text/javascript">
	function changeHandler(){
		document.form.submit();
	}
</script>
</head>
<body>
<form name="form" action="<%=request.getContextPath() %>/05/getBP.jsp">
	<select name="member" onchange="changeHandler();">
		<option value="">멤버 선택</option>
		<%
		// 엔트리로 해보기
		  for (String mapkey : singerMap.keySet()){
		        out.println(String.format("<option value='%s'>%s</option>", mapkey, singerMap.get(mapkey)[0]));
		  }
		%>	
	</select>

</form>

</body>
</html>