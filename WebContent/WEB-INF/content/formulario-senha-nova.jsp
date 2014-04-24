<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/mensagem.js"></script>
<script src="js/jquery.toastmessage.js" type="text/javascript"></script>
<link href="css/jquery.toastmessage.css" rel="stylesheet" type="text/css" />
<link href="css/estilos.css" rel="stylesheet" type="text/css" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpCar</title>
</head>
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>
	<div class="fundo" align="center">
		<p id="subtitulo">Senha nova</p>
		<p>Insira o e-mail cadastrado que enviaremos uma nova senha para o seu e-mail e</p>
		<p>inclusive o seu login</p>
		<s:form action="senhaNova" method="post">
			<input type="hidden" name="msg" id="msg" value="${msg}" />
			<input type="hidden" name="tipo" id="msg" value="${msg}" />
			<input type="hidden" name="condutor.login" id="condutor.login" value="${condutor.login}" />
			<s:password name="condutor.senha" label="Informe a senha enviada ao seu e-mail" />
			<s:password name="senhaNova" label="Insira a sua senha nova" />
			<s:submit value="entrar" />
		</s:form>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>

</body>
</html>