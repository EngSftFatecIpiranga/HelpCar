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
	<h2>Bem vindo, ${usuarioLogado.nome}</h2>
	<h2>Carro: ${veiculoLogado.modelo}</h2>
<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>