<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<div class="fundo" align="center">

	<table>
		<tr>
			<td>
				<table>
					<tr>
						<td><img src="imagens/logoprincipal.png" width="300" height="130" /></td>
						<td width="600"><p class="titulo">Help Car - Gerenciador de Manuten��es</p></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr >
			<td>
				<div id="menu">
			    	<ul>
    					<li><%response.sendRedirect("/HelpCar/index");%></li>
                        <li><a href="<%=response.encodeURL("formulario-usuario.jsp")%>">Cadastro Usu�rio</li>
                        <li><a href="<%=response.encodeURL("formulario-veiculo.jsp")%>">Cadastro Ve�culo</li>
    					<li><a href="<%=response.encodeURL("formulario-evento.jsp")%>">Cadastro Manuten��o</li>
    					<li><a href="<%=response.encodeURL("????????.jsp")%>">Logout</li>
    				</ul>
				</div>
			</td>
		</tr>
		</table>
</div> 


</body>
</html>