<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String palabra = (String) request.getAttribute("PALABRA_LORENZO");
		if (palabra == null) {
			palabra = request.getParameter("PALABRA_LORENZO_PARAMETRO");
		}
	
	%>
	El texto de Lorenzo es <%= palabra %>
	
	<form action="salida.jsp" method="post">
		Palabra de Lorenzo: <input name="PALABRA_LORENZO_PARAMETRO" type="text" value="<%= palabra%>"/><br>
		<input type="submit"/>		
	</form>
	
	<%
		java.util.Enumeration<String> cabeceras = request.getHeaderNames();
	
		while(cabeceras.hasMoreElements()) {
			String nombre = cabeceras.nextElement();
			
			out.println(nombre + " - " + request.getHeader(nombre) + "<br>");
			
		}
	
	
	%>
</body>
</html>