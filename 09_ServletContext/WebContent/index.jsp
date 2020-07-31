<%@page import="java.util.LinkedHashSet"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
	<%!Set<String> productNames = new LinkedHashSet<String>();%>

	<form action="" method="post">
		Product Name <input type="text" name="txtName"><br> <input
			type="submit" value="print">
	</form>

	<%
		if (request.getParameter("txtName") != null) {
		productNames.add(request.getParameter("txtName"));
	}
	if (application.getAttribute("name") == null) {
		application.setAttribute("name", productNames);
	}
	%>
	<hr>
	Suggestion : [
	<% for(String str:productNames){
		out.print(str+",");
	}
	%>]

	<%
		application.setAttribute("name", productNames);
	%>
</body>
</html>