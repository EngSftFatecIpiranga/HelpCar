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
		<p id="subtitulo">Login Form</p>
		<s:form action="login" method="post" id="corpo">

			<s:textfield name="condutor.login" label="Login" />
			<s:password name="condutor.senha" label="Senha" />
			<s:submit value="entrar" />
		</s:form>
		<h5>
			<a href="http://localhost:8080/HelpCar/cadastroForm">Clique aqui
				para fazer seu cadastro</a>
		</h5>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>