<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Cadastra Evento</title>
</head>
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>
	<div class="fundo" align="center">
		<p id="subtitulo">Cadastro de eventos</p>
		<c:set var="count" value="0" scope="page" />
		<s:form action="cadastraEvento" method="post">

			<c:forEach var="tipo" items="${tiposEvento}">
				<input type="hidden" name="eventos[${count}].tipoEvento" value="${tipo}" />
				<input type="hidden" name="eventos[${count}].veiculo"value="${veiculoLogado}" />
				<table class="form.${tipo.nomeEvento}" width="900px">

					<tr>
						<td width="30%"><img width="70" height="70" alt="" src="imagens/${tipo.nomeEvento}.png"></td>
						<td width="50%"><B><CENTER><font face="Arial" size="4">${tipo.nomeEvento}</font></CENTER></B></td>
						<td width="100%">Km Evento:<input type="text" name="eventos[${count}].kmEvento" /></td>
                    	<td width="100%">Custo:<input type="text" name="eventos[${count}].custo" /></td>
						<td width="100%">Data Evento:<j:campoData id="eventos[${count}].dataEvento" classe="${count}" /></td>
				</tr>
				</table>
				<c:set var="count" value="${count + 1}" scope="page" />
			</c:forEach>

			<table align="center">
				<tr>
					<td><p>
							<s:submit value="cadastrar" />
						</p></td>
				</tr>
			</table>
		</s:form>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>