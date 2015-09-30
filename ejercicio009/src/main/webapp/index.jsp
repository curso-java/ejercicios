<html>
<body>
<h2>Hello World!</h2>
	<%
		String valor = (String)session.getAttribute("PALABRA_JOSE_MANUEL");
		out.println(valor);
	%>
</body>
</html>
