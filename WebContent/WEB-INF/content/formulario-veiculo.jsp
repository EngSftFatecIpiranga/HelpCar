<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script src="js/jquery.toastmessage.js" type="text/javascript"></script>
<link href="css/jquery.toastmessage.css" rel="stylesheet" type="text/css" />   
<script src="js/mensagem.js" type="text/javascript"></script>
<link href="css/estilos.css" rel="stylesheet" type="text/css" /> 


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpCar</title>
</head>

<jsp:include page="cabecalho.jsp"></jsp:include>
<body>
	<div class="fundo" align="center">
		<p id="subtitulo">Cadastro Veiculo</p>
	<s:form action ="cadastraVeiculo" method ="post" validate="true">
		<s:textfield name="veiculo.nome" label="Nome veiculo" required="true" />
		<s:textfield name="veiculo.marca" label="Marca" required="true" />
		<s:textfield name="veiculo.modelo" label="Modelo" required="true" />
		<s:textfield name="veiculo.fabricacao" label="Ano do modelo" required="true"  />
		<s:textfield name="veiculo.kmInicial" label="Quilometragem inicial" required="true"  />	
		<s:textfield name="veiculo.kmMediaDia" label="Quilometragem média por dia" required="true"  />	
		<s:textfield name="veiculo.placa" label="Placa do veículo" required="true"  />
		<s:submit name= "cadastra" value="Cadastra" type="button" align="center" method="post" />
	</s:form>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>	
		
</html>