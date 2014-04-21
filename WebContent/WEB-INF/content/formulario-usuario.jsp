<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script src="js/jquery.toastmessage.js" type="text/javascript"></script>
<link href="css/jquery.toastmessage.css" rel="stylesheet"
	type="text/css" />
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	window.onload = function showStickySuccessToast() {

		var msg = document.getElementById("msg").value;

		if (msg != '') {
			$().toastmessage('showToast', {
				text : msg,
				sticky : true,
				position : 'top-center',
				type : 'error',
				closeText : '',
				close : function() {
					console.log("toast is closed ...");
				}
			});
		}
	};
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpCar</title>
</head>
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>
	<div class="fundo" align="center">
		<p id="subtitulo">Cadastro Usuário</p>
		<input type="hidden" name="msg" id="msg" value="${msg}" />
		<s:form action="cadastraUsuario" method="post" validate="true">
			<s:textfield name="condutor.nome" label="Nome" required="true" />

			<s:textfield name="condutor.email" label="Email" required="true" />


			<s:textfield name="condutor.celular" label="Celular" required="true" />

			<s:textfield name="condutor.cnh" label="CNH" required="true" />


			<s:textfield name="condutor.login" label="Login:" required="true" />

			<s:password name="condutor.senha" label="Senha" required="true" />


			<s:submit name="cadastra" value="Cadastra" type="button"
				align="center" method="post" />
		</s:form>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>