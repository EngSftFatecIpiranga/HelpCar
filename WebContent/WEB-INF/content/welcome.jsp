<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="/struts-tags/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html lang="true">
<head>
<title><bean:message key="welcome.title" /></title>
</head>
<body>
    <div align="center">
    <h1>
        <font face="Comic Sans MS" size="3" ></font>
        <font color="blue"><bean:message key="welcome.title" /></font>
    </h1>
    
    <logic:notPresent name="org.apache.struts.action.MESSAGE" 
        scope="application">
        <font color="red"> ERROR: Application resources not loaded --
        check servlet container logs for error messages. </font>
    </logic:notPresent>
    
    <h3><bean:message key="welcome.heading" /></h3>
    <p><bean:message key="welcome.message" /></p>
    
    <html:link page="/menu.do">Menu Inicial</html:link>
    </div>
</body>
</html:html>