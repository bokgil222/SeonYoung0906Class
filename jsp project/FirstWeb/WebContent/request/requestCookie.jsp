<%@ page import="java.util.Enumeration" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		Cookie[] cookies = request.getCookies();
		
		// 쿠키 데이터의 저장
		// 쿠키 이름=값
	
		if(cookies!=null && cookies.length>0){
			for(int i =0; i<cookies.length; i++){
				Cookie c = cookies[i];  // 쿠키 객체
				out.println(c.getName()+"="+c.getValue());
		}
	}
	%>
	
	<hr>
	
	<h3>host: <%= request.getHeader("host") %></h3>
	<%
		Enumeration headers = request.getHeaderNames();
		
		while(headers.hasMoreElements()){
			// header 이름 가져온다.
			String headerName = (String)headers.nextElement();
			// header 이름으로 header의 속성값을 가져 온다.
			String value = request.getHeader(headerName);
			
			out.println("<h4>"+headerName+": "+value+"</h4>");
		}
	%>
	
</body>

</html>