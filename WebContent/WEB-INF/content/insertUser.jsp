	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<logic:notPresent name="userBean" scope="session">
    <logic:redirect forward="error" />
</logic:notPresent>

<html:html lang="true">
<head>
    <title><bean:message key="editUser.title" /></title>
</head>
<body>
    <div align="center">
    <h3><font face="Comic Sans MS" size="3"><font color="blue">
        <bean:message key="editUser.title" /></font></font>
    </h3>
    <html:form action="/SaveEditUser.do" method="post" focus="login">
        <html:hidden property="idUsuario" name="userBean" />
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
                <td align="right"><bean:message key="prompt.email" />:</td>
                <td align="left">
                    <html:text property="email" size="45"
                    name="userBean" /></td>
            </tr>
            <tr>
                <td align="right"><bean:message key="prompt.nome" /></td>
                <td align="left">
                    <html:text property="nome" size="60" name="userBean" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <bean:message key="prompt.senhaAntiga" />:
                </td>
                <td align="left">
                    <html:password property="senhaAntiga" size="16" 
                        maxlength="12" redisplay="false" value="zzzzz" />
                </td>
            </tr>
 <tr>
                <td align="right"><bean:message key="prompt.novaSenha" />:</td>
                <td align="left">
                    <html:password property="novaSenha" size="16" 
                        maxlength="20" redisplay="false" value="zzzzz" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <bean:message key="prompt.confirmacaoNovaSenha" />:
                </td>
                <td align="left">
                    <html:password property="confirmacaoNovaSenha" size="16" 
                        maxlength="20" redisplay="false" value="zzzzz" />
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
</html:html>