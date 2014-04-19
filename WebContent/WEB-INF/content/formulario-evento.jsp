<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="j" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script src="js/jquery.toastmessage.js" type="text/javascript"></script>
<link href="css/jquery.toastmessage.css" rel="stylesheet" type="text/css" />   
<link rel="stylesheet" href="css/jquery-ui-1.10.4.css">
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui-1.10.4.js"></script>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastra Evento</title>
</head>
<body>

	<h2>Cadastro de eventos</h2>
	<c:set var="count" value="0" scope="page" />
	<c:forEach var="tipo"  items="${tiposEvento}">
		<input type="hidden" name ="eventos[${count}].idTipo"value="${tipo.idTipo}" />
		<input type="hidden" name ="eventos[${count}].idVeiculo"value="${veiculo.idVeiculo}" />    
		<input type="checkbox" id="check${tipo.nomeEvento}" value="${tipo.nomeEvento}"><img width="30" height="30" alt="" src="img/${tipo.nomeEvento}.jpg">${tipo.nomeEvento}
		<input type="text" name="eventos[${count}].kmEvento" /> 
		<j:campoData id="eventos[${count}].dataEvento" /> 
   		<c:set var="count" value="${count + 1}" scope="page"/>
	</c:forEach>

	
</body>
</html>