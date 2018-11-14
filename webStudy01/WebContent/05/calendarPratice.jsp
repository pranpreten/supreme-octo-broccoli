<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   .sunday{
      background-color: red;
   }
   .saturday{
      background-color: blue;
   }
   table{
      width: 100%;
      height: 500px;
      border-collapse: collapse;
   }
   td,th{
      border: 1px solid black;
   }
</style>
<script type="text/javascript">
function eventHandler(year,month) {
	var form = document.forms[0];
	 if((year&&month)||(month==0)){
	      form.year.value = year;
	      form.month.value = month;
     }
     
    form.submit();
    
 }
</script>
</head>
<body>
<%

	// 이번달 다음달 이동관련
	request.setCharacterEncoding("UTF-8");
	String monthStr = request.getParameter("month");
	String yearStr = request.getParameter("year");
	String language = request.getParameter("language");
	Calendar cal = Calendar.getInstance();
	Locale clientLocale = request.getLocale();
	
	
	if(yearStr != null && yearStr.matches("\\d{4}") && monthStr != null && monthStr.matches("1[0-1]|\\d")){
	     cal.set(Calendar.YEAR, Integer.parseInt(yearStr));
	     cal.set(Calendar.MONTH, Integer.parseInt(monthStr)); 
	}
	if(language != null && language.trim().length()>0){
		 clientLocale = Locale.forLanguageTag(language);  // 언어 정보 변경
	}
	   

	// 날짜 숫자 찍는거 관련
	int currentYear = cal.get(Calendar.YEAR);
	int currentMonth = cal.get(Calendar.MONTH);
	cal.set(Calendar.DAY_OF_MONTH,1); // 현재 날자를 1일로 세팅
	int fristDayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1일의 요일로 세팅
	int offset = fristDayOfWeek-1;
	int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
	DateFormatSymbols symbols = new DateFormatSymbols(clientLocale);
	
	cal.add(Calendar.MONTH, -1); //이전달로 이동 관련 세팅
	int beforeYear = cal.get(Calendar.YEAR);
	int beforeMonth = cal.get(Calendar.MONTH);
	
	cal.add(Calendar.MONTH, 2); // 다음달로 이동관련 세팅
	int nextYear = cal.get(Calendar.YEAR);
	int nextMonth = cal.get(Calendar.MONTH);
	
	// 로케일 관련
	Locale[] locales = Locale.getAvailableLocales();
	
%>
<form action="">
<h4>
 	<a onclick="eventHandler(<%=beforeYear%>,<%=beforeMonth%>);">이전달</a> 
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	 <input type="number" name="year" value="<%=currentYear%>" 
 	 	onblur="eventHandler();"
      >년
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <select name="month" onchange="eventHandler()">
         <%
            String[] monthStrings = symbols.getShortMonths();
            for(int idx=0; idx< monthStrings.length-1; idx++){
               out.println(String.format("<option value='%d' %s>%s</option>",
                     idx, idx==currentMonth?"selected":"" ,monthStrings[idx]));
            }
         %>
      </select>
	<a onclick="eventHandler(<%=nextYear%>,<%=nextMonth%>);">다음달</a> 
	<select name="language" onchange="eventHandler()">
         <%
            for(Locale tmp: locales){
               out.println(String.format("<option value='%s' %s>%s</option>", 
                     tmp.toLanguageTag(), tmp.equals(clientLocale)?"selected":"",
                           tmp.getDisplayLanguage(clientLocale)));
            }
         %>
     </select>

	
</h4>

</form>



<table>
<thead>
	<tr>
	<%
		String[] dateStrings = symbols.getShortWeekdays();
		for(int idx = Calendar.SUNDAY; idx<=Calendar.SATURDAY; idx++){
			out.println(String.format("<th>%s</th>", dateStrings[idx]));
		}
	%>
	</tr>
</thead>
<tbody>
<%
	int dayCount = 1;
	String pattern = "<td class='%s'>%d</td>";
	for(int i = 1; i<=6; i++){
		out.println("<tr>");
		for(int j=1; j<=7; j++){
			int dateChar = dayCount++ - offset; 
			if(dateChar<1||dateChar>lastDate){
				out.print("<td>&nbsp;</td>");
			}else{
				String clzValue = "normal";
	            if(j==1){
	               clzValue = "sunday";
	            } else if(j==7){
	               clzValue = "saturday";
	            }
	            out.println(String.format(pattern, clzValue, dateChar));
			}
		}
		out.println("</tr>");
	}

%>
</tbody>


</table>

</body>
</html>