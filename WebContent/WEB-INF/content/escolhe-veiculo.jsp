<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function verificaChecks() {
    	var aChk = document.getElementsByName("item"); 
    	for (var i=0;i<aChk.length;i++){ 
        	if (aChk[i].checked == true){ 
        		alert(aChk[i].value);
        		var campo = aChk[i].id+"";
        		document.getElementById('escolha.'+campo).value = aChk[i].id;
        		document.formEscolhe.submit();
        	}  else {
            	// CheckBox Não Marcado... Faça alguma outra coisa...
        	}
    	}
	}
</script>
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>

	<div class="fundo" align="center">
		<p id="subtitulo">Escolha o carro:</p>
		<s:form action ="escolheVeiculo" id= "formEscolhe" name ="formEscolhe" method ="post">
			<c:forEach var="veiculo" items="${listaVeiculos}" >
				<br><input type="radio" id="${veiculo.idVeiculo}" name="item" value="${veiculo.nome}"> <c:out value="${veiculo.nome}" />
				<input type="hidden" name="idVeiculo"  id="escolha.${veiculo.idVeiculo}" value="" />
			</c:forEach>
		<br><input type="button" value="Escolhe" onclick="verificaChecks()">

	</s:form>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>	