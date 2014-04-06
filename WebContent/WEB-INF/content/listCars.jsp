<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<logic:notPresent name="carsListBean" scope="request">
    <logic:redirect forward="error" />
</logic:notPresent>

<html:html lang="true">
<head>
    <title><bean:message key="cars.title" /></title>
</head>

<body>
    <center>
    <h3><font face="Comic Sans MS" size="3"><font color="blue">
	    <bean:message key="cars.title" />
    </font></font></h3>
    <table width="80%" border="1">
        <tr>
            <th width="50%"><bean:message key="prompt.marca" /></th>
            <th width="20%"><bean:message key="prompt.modelo" /></th>
            <th width="10%"><bean:message key="prompt.ano" /></th>
            <th width="10%"><bean:message key="prompt.portas" /></th>
            <th width="10%"><bean:message key="prompt.placa" /></th>
        </tr>
        <logic:iterate name="carsListBean" id="cars">
            <tr>
                <td align="center">
                    <bean:write name="cars" property="idVeiculo" />
                </td>
                <td>
                    <html:link page="/EditCar.do" paramId="idVeiculo"
                        paramName="cars" paramProperty="idVeiculo">
                        <bean:write name="cars" property="marca" />
                    </html:link>
                </td>
                <td><bean:write name="cars" property="login" /></td>
                <td><bean:write name="cars" property="descricaoStatus" /></td>
                <td>
                    <html:link page="/DeleteCar.do" paramId="idVeiculo"
                        paramName="cars" paramProperty="idVeiculo">
                        <bean:message key="prompt.excluir" />
                    </html:link>
                </td>
            </tr>
        </logic:iterate>
    </table>
    <br/>
    <html:link page="/InsertCar.do">
        <bean:message key="prompt.incluir" />
    </html:link> 
    <html:link page="/Welcome.do">Home</html:link>
    </center>
</body>
</html:html>