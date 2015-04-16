<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="util.CountFileHandler;"%>
<html>
<head>
<title>统计访问量-无缺陷</title>
</head>
<body>

<% 
long count=CountFileHandler.readFile("G:/count.txt");
if(session.getAttribute("visited")==null){
	session.setAttribute("visited","y");
	session.setMaxInactiveInterval(60*60*24);
	count=count+1;
	CountFileHandler.writeFile("G:/count.txt",count);
}
%>
<h2>
欢迎您访问，本页面已经被访问过
${count }次了。 
</h2>
</body>
</html>