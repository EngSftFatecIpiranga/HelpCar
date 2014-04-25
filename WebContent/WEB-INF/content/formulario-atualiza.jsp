<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<sx:head parseContent="true" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpCar</title>
</head>

<jsp:include page="cabecalho.jsp"></jsp:include>
<body>
	<div class="fundo" align="center">
		<p id="subtitulo">Altera Usuário</p>
	<s:form action ="atualizaCondutor" method ="post" validate="true">
		<c:set var="user" value="${usuarioLogado}" scope="request" />
		<s:textfield name="condutor.nome" label="Nome" value="%{#request.user.nome}" required ="true" />
		<s:textfield name="condutor.email" label="Email" value="%{#request.user.email}" required ="true" />
		<sx:datetimepicker name="condutor.DataNascimento" label="Data Nascimento" displayFormat="dd/MM/yyyy" value="%{#request.user.dataNascimento}"  />
		<s:textfield name="condutor.celular"  label="Celular" value="%{#request.user.celular}" required ="true" />
		<s:textfield name="condutor.cnh" label="CNH" value ="%{#request.user.cnh}" required ="true" />

		<s:textfield name="condutor.login" label="Login:" value ="%{#request.user.login}" required ="true"  />
		<s:password name="condutor.senha" label="Senha"  value="" required ="true"  />
		<input type="hidden" name="msg" id="msg"value="${msg}" />
		<input type="hidden" name="tipo" id="msg"value="${tipo}" />
		<s:submit name= "Altera" value="Altera" type="button" align="center" method="post" />
	</s:form>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>	
		
</html>