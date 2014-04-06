<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<logic:notPresent name="userListBean" scope="request">
    <logic:redirect forward="error" />
</logic:notPresent>

<html:html lang="true">
<head>
    <title><bean:message key="user.title" /></title>
</head>

<body>
    <center>
    <h3><font face="Comic Sans MS" size="3"><font color="blue">
	    <bean:message key="cars.title" />
    </font></font></h3>
    <table width="80%" border="1">
        <tr>
            <th width="50%"><bean:message key="prompt.nome" /></th>
            <th width="20%"><bean:message key="prompt.email" /></th>
            <th width="10%"><bean:message key="prompt.dataNascimento" /></th>
            <th width="10%"><bean:message key="prompt.dataValidadeCNH" /></th>
            <th width="10%"><bean:message key="prompt.senha" /></th>
        </tr>
        <logic:iterate name="carsListBean" id="user">
            <tr>
                <td align="center">
                    <bean:write name="user" property="User" />
                </td>
                <td>
                    <html:link page="/EditUser.do" paramId="idUsuario"
                        paramName="user" paramProperty="idUsuario">
                        <bean:write name="user" property="nome" />
                    </html:link>
                </td>
                <td><bean:write name="user" property="email" /></td>
                <td>
                    <html:link page="/DeleteUser.do" paramId="idUsuario"
                        paramName="user" paramProperty="idUsuario">
                        <bean:message key="prompt.excluir" />
                    </html:link>
                </td>
            </tr>
        </logic:iterate>
    </table>
    <br/>
    <html:link page="/InsertUser.do">
        <bean:message key="prompt.incluir" />
    </html:link> 
    <html:link page="/Welcome.do">Home</html:link>
    </center>
</body>
</html:html>