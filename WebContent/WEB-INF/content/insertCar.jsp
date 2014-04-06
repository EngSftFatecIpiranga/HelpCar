	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<logic:notPresent name="carBean" scope="session">
    <logic:redirect forward="error" />
</logic:notPresent>

<html:html lang="true">
<head>
    <title><bean:message key="carUser.title" /></title>
</head>
<body>
    <div align="center">
    <h3><font face="Comic Sans MS" size="3"><font color="blue">
        <bean:message key="carUser.title" /></font></font>
    </h3>
    <html:form action="/SaveEditCar.do" method="post" focus="login">
        <html:hidden property="idVeiculo" name="carBean" />
        <table width="80%" border="0">
            <tr>
                <td width="30%"></td>
                <td width="70%">
                    <logic:messagesPresent>
                        <font color="red">
                            <ul>
                                <html:messages id="error">
                                    <li><bean:write name="error" /></li>
                                </html:messages>
                            </ul>
                        </font>
                    </logic:messagesPresent>
                </td>
            <tr>
            <tr>
                <td align="right"><bean:message key="prompt.marca" />:</td>
                <td align="left">
                    <html:text property="marca" size="45"
                    name="carBean" /></td>
            </tr>
            <tr>
                <td align="right"><bean:message key="prompt.modelo" /></td>
                <td align="left">
                    <html:text property="modelo" size="60" name="carBean" />
                </td>
            </tr>
            <tr>
                <td align="right"><bean:message key="prompt.ano" /></td>
                <td align="left">
                    <html:text property="ano" size="60" name="carBean" />
                </td>
            </tr>
            <tr>
                <td align="right"><bean:message key="prompt.placa" /></td>
                <td align="left">
                    <html:text property="placa" size="60" name="carBean" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <html:submit>
                        <bean:message key="button.send" />
                    </html:submit> 
                    <html:reset>
                        <bean:message key="button.reset" />
                    </html:reset>
                </td>
            </tr>
        </table>
    </html:form> <br />
    <html:link page="/ListCars.do">
        <bean:message key="prompt.voltar" />
    </html:link>
    </div>
</body>
</html:html>