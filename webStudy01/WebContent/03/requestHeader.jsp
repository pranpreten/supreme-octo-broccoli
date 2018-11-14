<%@page import="java.util.Locale"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String lang = request.getParameter("lang");
	Locale currentLocale = request.getLocale();
	if(lang!=null && lang.trim().length()!=0){
		currentLocale = Locale.forLanguageTag(lang);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changeHandler(){
		document.langForm.submit();
	}
</script>
</head>
<body>
<%
	Locale[] locales = Locale.getAvailableLocales(); // 자바에서 지원하는 모든 나라, 국가정보가 들어있는 객체
%>
<form name="langForm">
	<select name="lang" onchange="changeHandler();">
		<option value="">언어 선택</option>
		<%
			String optPattern = "<option value='%s' %s>%s</option>";
			for(Locale tmp:locales){
				String value = tmp.toLanguageTag(); //toLanguageTag 로케일 객체에서 ko-kr을 빼온것
				String text = tmp.getDisplayLanguage();//getDisplayLanguage 로케일 객체에서 언어를 빼온것
				String selected = "";
				if(currentLocale.equals(tmp)){
					selected = "selected"; // 선택된 값으로 화면이 바뀌는데 선택된 값으로 콤보밖스가 남아있게
				}
				if(text!=null && text.trim().length()!=0){
					out.println(String.format(optPattern, value, selected, text));
				}
			}
		%>
	</select>
</form>
<ul>
	<li>
		현재 사용자의 언어와 국가 정보
		: <%=request.getHeader("accept-language") %>
	</li>
	<li>
	<%
		//ex) ko_KR : 로케일문자 언어_지역(국가);
		Locale locale = request.getLocale();
		String country = locale.getDisplayCountry(currentLocale);
		String language = locale.getDisplayLanguage(currentLocale);
	%>
		Locale 객체 활용
		: <%=language %>,<%=country %>
	</li>
</ul>
<table>
	<thead>
		<tr>
		<th>헤더명</th>
		<th>헤더값</th>
		</tr>
	</thead>
	<tbody>
		<%
			Enumeration<String> names = request.getHeaderNames();
			String pattern = "<tr><td>%s</td><td>%s</td></tr>";
			while(names.hasMoreElements()){
				String headerName = names.nextElement();
				String headerValue = request.getHeader(headerName);
				out.println(String.format(pattern, headerName, headerValue));
			}
		%>
	</tbody>
</table>
</body>
</html>