<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpCar</title>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
	<div class="fundo" align="center">
		<p id="subtitulo">Seja Bem vindo, ${usuarioLogado.nome}</p>
	</div>
	<div id="conteudo" align="center">
					<p>Esta � a p�gina inicial do seu gerenciador de manuten��es.</p>
	</div>
	<input type="hidden" name="msg" id="msg" value="${msg}" />
	<input type="hidden" name="tipo" id="tipo" value="${tipo}" />				
	<jsp:include page="rodape.jsp"></jsp:include>
	
</body>

</html>