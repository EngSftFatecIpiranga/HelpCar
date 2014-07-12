<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="j" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>




<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type="text/css" href="css/custom-theme/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.20.custom.min.js"></script>

	<title>Cadastra Evento</title>
</head>
<body>

	<h2>Cadastro de eventos</h2>
	<c:set var="count" value="0" scope="page" />
	<s:form action ="cadastraEvento" method ="post">
		<c:forEach var="tipo"  items="${tiposEvento}">
			<input type="hidden" name ="eventos[${count}].tipoEvento" value="${tipo}" />
			<input type="hidden" name ="eventos[${count}].veiculo"value="${veiculoLogado}" />    
			<input type="checkbox" id="check${tipo.nomeEvento}" value="${tipo.nomeEvento}"><img width="30" height="30" alt="" src="imagens/${tipo.nomeEvento}.png">${tipo.nomeEvento}
			<input type="text" name="eventos[${count}].kmEvento" /> 
			<j:campoData id="eventos[${count}].dataEvento" classe="${count}" /> <br />
			
   			<c:set var="count" value="${count + 1}" scope="page"/>
		</c:forEach>
		<s:submit value ="cadastrar"  />
		
	</s:form>

	
</body>
</html>