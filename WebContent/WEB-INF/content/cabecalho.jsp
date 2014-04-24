<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script src="js/jquery.toastmessage.js" type="text/javascript"></script>
<link href="css/jquery.toastmessage.css" rel="stylesheet"
	type="text/css" />
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<script src="js/mensagem.js" type="text/javascript"></script>
<link type="text/css"
	href="css/custom-theme/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-ui-1.8.20.custom.min.js"></script>
<script src="js/jquery.toastmessage.js" type="text/javascript"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Help Car</title>
</head>
<body>



	<div class="fundo" align="center">

		<table>
			<tr>
				<td>
					<table>
						<tr>
							<td><img src="imagens/logoprincipal.png" width="300"
								height="130" /></td>
							<td width="600"><p class="titulo">Help Car - Gerenciador
									de Manutenções</p></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<div id="menu">
						<ul>
							<li>
								<%
									response.sendRedirect("/HelpCar/index");
								%>
							</li>
							<li><a href="<s:url action="cadastroForm"/>">Início</li>
							<li><a href="<s:url action="cadastroVeiculoForm"/>">Cadastro
									Veículo</li>
							<li><a href="<s:url action="cadastroEventoForm"/>">Cadastro
									Manutenção</li>
							<li><a href="<s:url action="geraRelatorioForm"/>">Relatório</li>
							<li><a href="<s:url action="logout"/>">Logout</li>
						</ul>
					</div>
				</td>
			</tr>
		</table>
	</div>


</body>
</html>