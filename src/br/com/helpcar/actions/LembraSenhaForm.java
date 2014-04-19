package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class LembraSenhaForm {
	private String msg;
	@Action(value="lembraSenhaForm", results={
			@Result(name="ok", location ="formulario-lembra.jsp")
	})
	public String execute() {
		return "ok";
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
