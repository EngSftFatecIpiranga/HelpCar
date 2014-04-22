<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script src="js/jquery.toastmessage.js" type="text/javascript"></script>
<link href="css/jquery.toastmessage.css" rel="stylesheet" type="text/css" />   
<link href="css/estilos.css" rel="stylesheet" type="text/css" /> 
<sx:head parseContent="true" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpCar</title>
</head>

<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
	<h2>Cadastro Usu�rio</h2>
	<s:form action ="cadastraUsuario" method ="post" validate="true">
		<s:textfield name="condutor.nome" label="Nome"  /> <br />
		<s:textfield name="condutor.email" label="Email" /> <br />
		<sx:datetimepicker name="condutor.DataNascimento" label="Data Nascimento" displayFormat="dd/MM/yyyy" value=todayDate/>
		<s:textfield name="condutor.celular"  label="Celular" /> <br />
		<s:textfield name="condutor.cnh" label="CNH" /> <br />

		<s:textfield name="condutor.login" label="Login:"  /> <br />
		<s:password name="condutor.senha" label="Senha"  /> <br />
		<input type="hidden" name="msg" id="msg"value="${msg}" />
		<s:submit name= "cadastra" value="Cadastra" type="button" align="center" method="post" />
	</s:form>
	
	<jsp:include page="rodape.jsp"></jsp:include>
</body>	
		
</html>