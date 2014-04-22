<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script src="js/jquery.toastmessage.js" type="text/javascript"></script>
<link href="css/jquery.toastmessage.css" rel="stylesheet"
	type="text/css" />
<link href="css/estilos.css" rel="stylesheet" type="text/css" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpCar</title>
</head>
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>
	<div class="fundo" align="center">
		<p id="subtitulo">Lembrar Senha</p>
		<s:form action="lembraSenha" method="post">
			<input type="hidden" name="msg" id="msg" value="${msg}" />
			<s:textfield name="condutor.nome" label="Nome" />
			<s:password name="condutor.email" label="E-mail" />
			<s:password name="condutor.CNH" label="CNH" />
			<s:password name="condutor.Senha" label="Senha Nova" />
			<s:submit value="entrar" />
		</s:form>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>

</body>
</html>