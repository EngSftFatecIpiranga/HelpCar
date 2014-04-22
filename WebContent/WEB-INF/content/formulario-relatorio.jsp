<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="j" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<head>
<sx:head parseContent="true"/>
<title>HelpCar</title>

</head>
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>

	<div class="fundo" align="center">
		<p id="subtitulo">Relatório de gastos</p>
		<input type="hidden" name="msg" id="msg" value="${msg}" />
		<input type="hidden" name="tipo" id="tipo" value="${tipo}" />
		<s:form action="geraRelatorio" method="post" validate="true">
			<sx:datetimepicker name="dataInicial" label="Data Inicial" displayFormat="dd/MM/yyyy" value="todayDate" /> <sx:datetimepicker name="dataFinal" label="Data Final" displayFormat="dd/MM/yyyy" value="todayDate" />
			<s:submit name="gera" value="Gera" type="button" align="center" method="post" />
		</s:form>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>