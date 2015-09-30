<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Por aquí paso
	<form:form commandName="compra">
      <table>
          <tr>
              <td>Sala:</td>
              <td><form:input path="salaId" /></td>
          </tr>
          <tr>
              <td>Cantidad:</td>
              <td><form:input path="cantidad" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="Comprar" />
              </td>
          </tr>
      </table>
  </form:form>
</body>
</html>