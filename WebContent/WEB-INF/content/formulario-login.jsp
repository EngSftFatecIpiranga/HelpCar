<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script src="js/jquery.toastmessage.js" type="text/javascript"></script>
<link href="css/jquery.toastmessage.css" rel="stylesheet" type="text/css" />   
 <script type="text/javascript" >
 window.onload=function showStickySuccessToast() {
	 
	 	var msg =document.getElementById("msg").value;

	 	if(msg!=''){
            $().toastmessage('showToast', {
                text: msg,
                sticky: true,
                position: 'top-center',
                type: 'success',
                closeText:'',
                close: function () {
                    console.log("toast is closed ...");
                }
            });
	 	}
 	};
  
 </script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpCar</title>
</head>
<body>

	<h2>Login Form</h2>
	<s:form action ="login" method ="post">
		<input type="hidden" name="msg" id="msg"value="${msg}" />
		<s:textfield name ="condutor.login"  label="Login"/>
		<s:password name ="condutor.senha"  label = "Senha" />
		<s:submit value ="entrar"  />
	</s:form>
</body>
</html>