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
<h3>Simple Iterator</h3>
<ol>
<s:iterator value="comboMeals">
  <li><s:property /></li>
</s:iterator>
</ol>
 
<h3>Iterator with IteratorStatus</h3>
<table>
<s:iterator value="listaEventos" status="listaEventosStatus">
  <tr>
  	<s:if test="#listaEventosStatus.even == true">
      <td style="background: #CCCCCC"><s:property/></td>
    </s:if>
    <s:elseif test="#listaEventosStatus.first == true">
      <td><s:property/> (This is first value) </td>
    </s:elseif>
    <s:else>
      <td><s:property/></td>
    </s:else>
  </tr>
</s:iterator>
</table>
</body>
</html>