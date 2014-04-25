<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpCar</title>
</head>
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>
	<div class="fundo" align="center">
		<p id="subtitulo">Lembrar Senha</p>
		<p>Insira o e-mail cadastrado que enviaremos uma nova senha para o seu e-mail e</p>
		<p>inclusive o seu login</p>
		<s:form action="lembraSenha" method="post" validate="true">
			<input type="hidden" name="msg" id="msg" value="${msg}" />
			<input type="hidden" name="tipo" id="msg" value="${msg}" />
			<s:textfield name="condutor.email" label="Informe o e-mail cadastrado" required="true" />
			<s:submit value="entrar" />
		</s:form>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>

</body>
</html>