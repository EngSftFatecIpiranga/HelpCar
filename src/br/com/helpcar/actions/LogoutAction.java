package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;

@ParentPackage("default")
public class LogoutAction {
	@Action(value="logout", results={
			@Result(name="ok", location ="formulario-login.jsp")},
			interceptorRefs= { @InterceptorRef("seguranca") })
	public String logout() throws Exception{
		@SuppressWarnings("rawtypes")
		SessionMap sessao = (SessionMap)ActionContext.getContext().get(ActionContext.SESSION);
		sessao.invalidate();
		return "ok";
	}
}
