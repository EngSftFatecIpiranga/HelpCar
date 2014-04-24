<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="j" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script src="js/jquery.toastmessage.js" type="text/javascript"></script>
<link href="css/jquery.toastmessage.css" rel="stylesheet" type="text/css" />   
<link href="css/estilos.css" rel="stylesheet" type="text/css" /> 
<sx:head parseContent="true" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpCar</title>
</head>

<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
	<h2>Relatório de gastos</h2>
	<h3>De <fmt:formatDate pattern="dd/MM/yyyy" value="${dataInicial.time}"/>  até  <fmt:formatDate pattern="dd/MM/yyyy" value="${dataFinal.time}"/></h3>
	
	<table>
		<tr>
			<td>Descricão:</td>
			<td>Valor: </td>
			<td>Data da manutenção: </td>
			<td>Data da proxima manutenção : </td>
		</tr>
	
	<c:forEach var="evento"  items="${eventos}">
				<tr>
					 <td>${evento.tipoEvento.nomeEvento}</td>
					 <td>${evento.custo}</td>
					 <td><fmt:formatDate pattern="dd/MM/yyyy" value="${evento.dataEvento.time}"/></td>
					 <td><fmt:formatDate pattern="dd/MM/yyyy" value="${evento.dataLimite.time}" /></td>		
				</tr>


	</c:forEach>
	</table>
			Valor gasto no período: <c:out value="${total}" />
	<jsp:include page="rodape.jsp"></jsp:include>
</body>	
		
</html>