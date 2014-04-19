<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script src="js/jquery.toastmessage.js" type="text/javascript"></script>
<link href="css/jquery.toastmessage.css" rel="stylesheet" type="text/css" />   
<script src="js/mensagem.js" type="text/javascript"></script>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpCar</title>
</head>
<body>
	<h2>Cadastro Veiculo</h2>
	<s:form action ="cadastraVeiculo" method ="post" validate="true">
		<s:textfield name="veiculo.nome" label="Nome veiculo" required="true" /> <br />
		<s:textfield name="veiculo.marca" label="Marca" required="true" /> <br />
		<s:textfield name="veiculo.modelo" label="Modelo" required="true" /> <br />
		<s:textfield name="veiculo.fabricacao" label="Ano do modelo" required="true"  /> <br />
		<s:textfield name="veiculo.kmInicial" label="Quiometragem inicial" required="true"  /> <br />	
		<s:submit name= "cadastra" value="Cadastra" type="button" align="center" method="post" />
	</s:form>

</html>