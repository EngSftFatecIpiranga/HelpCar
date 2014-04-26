<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<sx:head parseContent="true" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpCar</title>
</head>

		<!-- Começo do JavaScript para excluir evento -->
		<script type="text/javascript">
			function removeAgora(id) {
				$.post("removeEvento", {'idEvento' : id}, function() {
					// selecionando o elemento html através da ID e alterando o HTML dele
					//$(elementoHtml).closest("tr").hide();
					$("#evento_"+id).closest("tr").hide();					
				});
			}
		</script>
		<!-- Fim do JavaScript -->
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<p align="center">Listagem de manutenções</p>

	<table id="tabrel" align="center" width="600px">
		<thead>
			<tr id="reltitulo">
				<td width="180">DESCRIÇÃO</td>
				<td width="80"><CENTER>VALOR</CENTER></td>
				<td width="100"><CENTER>DATA MANUTENÇÃO</CENTER></td>
				<td width="120"><CENTER>PROXIMA MANUTENÇÃO</CENTER></td>
				<td width="20"><CENTER>REMOVER</CENTER></td>
			</tr>
		</thead>
		<c:forEach var="evento" items="${eventos}">
			<tbody>
				<tr>
					<td>${evento.tipoEvento.nomeEvento}</td>
					<td><CENTER>R$ ${evento.custo}</CENTER></td>
					<td><CENTER>
							<fmt:formatDate pattern="dd/MM/yyyy"
								value="${evento.dataEvento.time}" />
						</CENTER></td>
					<td><CENTER>
							<fmt:formatDate pattern="dd/MM/yyyy"
								value="${evento.dataLimite.time}" />
						</CENTER></td>
			
					<td id="evento_${evento.idEvento}">
						<a href="#" onclick="removeAgora(${evento.idEvento})">Remover</a>
					</td>		
			
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>

</html>