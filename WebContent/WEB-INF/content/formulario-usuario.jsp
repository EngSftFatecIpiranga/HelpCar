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



<script type="text/javascript">
 </script>
</head>
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>

	<div class="fundo" align="center">
		<p id="subtitulo">Cadastro Usuário</p>
		<input type="hidden" name="msg" id="msg" value="${msg}" />
		<s:form action="cadastraUsuario" method="post" validate="true">
			<s:textfield name="condutor.nome" label="Nome" required="true" />
			<sx:datetimepicker name="condutor.dataNascimento" label="Data Nascimento" displayFormat="dd/MM/yyyy" value="todayDate" />
			<s:textfield name="condutor.email" label="Email" required="true" />
			<s:textfield name="condutor.celular" label="Celular" required="true" />
			<s:textfield name="condutor.cnh" label="CNH" required="true" />		
			<s:textfield name="condutor.login" label="Login:" required="true" />
			<s:password name="condutor.senha" label="Senha" required="true" />
			<s:submit name="cadastra" value="Cadastra" type="button" align="center" method="post" />
		</s:form>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>