<%@page import="kr.or.ddit.vo.AlbasengVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07/includeDesc.jsp</title>
</head>
<body>
<h4> Include </h4>

<pre>
	1. 동적 include : 실행중(runtime), 실행 결과물들이 include
					서버사이드 페이지 모듈화에 주로 사용.
					1) RequestDispatcher 를 사용
					2) PageContext 를 사용
					3) 액션 태그를 사용
					JSP 스펙에 따라 기본적으로 제공되는 커스텀 태그.
					&lt;prefix:tagname attributes...../&gt;
					- forward : requset dispatch 방식의 forward
					- include : requset dispatch 방식의 include
					- useBean 
					  (setProperty/getProperty)
 					  <jsp:useBean id="albaVO" class="kr.or.ddit.vo.AlbasengVO" 
 					  	scope="page"
					  />
					  <jsp:setProperty property="name" name="albaVO" value="이름"/>
<%-- 					  <jsp:setProperty property="age" name="albaVO" param="age"/> --%>
					  <jsp:setProperty property="*" name="albaVO" />
					  <jsp:getProperty property="name" name="albaVO"/>
					  <jsp:getProperty property="age" name="albaVO"/>

<!-- // 						AlbasengVO albaVO = (AlbasengVO)pageContext.getAttribute("albaVO"); -->
<!-- // 						if(albaVO==null){ -->
<!-- // 							albaVO = new AlbasengVO(); -->
<!-- // 							pageContext.setAttribute("albaVO", albaVO); -->
<!-- // 						} 
								albaVO.setName("이름");
								albaVO.setAge(new Integer(request.getParameter("age")));

-->
		<%
			pageContext.include("/includee/codeFragment.jsp");
		%>
		
	2. 정적 include : 실행전, 소스 자체가 include
					include 지시자 이용
					중복 코드 해결에 주로 사용.
					웹 어플리케이션에 전역적으로 정적 include 를 할 때,
					web.xml의 include-code/pleud 등이 활용 됨.(비추!!)
					<%--@include file="/includee/codeFragment.jsp" --%>
					<%--=varAtFrag.length()--%>

</pre>
</body>
</html>