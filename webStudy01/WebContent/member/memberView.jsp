<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mem_id = request.getParameter("who");
	
	IMemberService service = new MemberServiceImpl();
	
	MemberVO member = service.retrieveMember(mem_id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<thead>
		<th> 아이디 </th>
		<th> 회원명 </th>
		<th> 주소1 </th>
		<th> 주소2 </th>
		<th> 휴대폰 </th>
		<th> 이메일 </th>
		<th> 마일리지 </th>
	</thead>
		<tr>
			<td><%=member.getMem_id() %></td>
			<td><%=member.getMem_name() %></td>
			<td><%=member.getMem_add1() %></td>
			<td><%=member.getMem_add2() %></td>
			<td><%=member.getMem_hp() %></td>
			<td><%=member.getMem_mail() %></td>
			<td><%=member.getMem_mileage() %></td>
		</tr>
	<tbody>
	
	</tbody>

</table>

</body>
</html>