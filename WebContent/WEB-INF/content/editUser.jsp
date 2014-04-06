<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html lang="true">
<head>
    <title><bean:message key="insertUser.title" /></title>
</head>
<body>
    <div align="center">
    <h3><font color="blue"><bean:message key="insertUser.title" /></font></h3>
    </font> <html:form action="/SaveInsertUser.do" method="post"
        focus="idUsuario">
        <table width="80%" border="0">
            <tr>
                <td width="30%"></td>
                <td width="70%">
                    <%-- exibe os erros de validação --%> 
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
                <td align="right"><bean:message key="prompt.email" />:</td>
                <td align="left"><html:text property="email" size="45"
                    name="userBean" /></td>
            </tr>
            <tr>
                <td align="right"><bean:message key="prompt.nome" /></td>
                <td align="left">
                    <html:text property="nome" size="60" name="userBean" />
                </td>
            </tr>
            <tr>
                <td align="right"><bean:message key="prompt.senha" />:</td>
                <td align="left">
                    <html:password property="senha" size="16" 
                        maxlength="12" redisplay="false" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <bean:message key="prompt.cSenha" />:
                </td>
                <td align="left">
                    <html:password property="cSenha"
                        size="16" maxlength="12" redisplay="false" />
                    </td>
            </tr>
            <tr>
                <td align="right"><bean:message key="prompt.dataValidadeCNH" /></td>
                <td align="left">
                    <html:text property="dataValidadeCNH" size="60" name="userBean" />
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
    <html:link page="/ListUsers.do">
        <bean:message key="prompt.voltar" />
    </html:link>
    </div>
</body>
<html:javascript formName="SaveInsertUserForm" />
</html:html>