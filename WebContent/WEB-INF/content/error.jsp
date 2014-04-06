<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page pageEncoding="ISO-8859-1"%>
<html:html lang="true">
<head>
    <title><bean:message key="error.title" /></title>
</head>
<body bgcolor="white">
    <center>
    <font face="Comic Sans MS" size="3">
    <h1><bean:message key="error.title" /></h1>
    </font>
    <font color="red">
    <logic:messagesPresent>
        <ul>
            <html:messages id="error">
                <li><bean:write name="error" /></li>
            </html:messages>
        </ul>
    </logic:messagesPresent>
    </font>
    <br/>
    <html:link page="/Welcome.do">Página Inicial</html:link>
    </center>
    </body>
</html:html>