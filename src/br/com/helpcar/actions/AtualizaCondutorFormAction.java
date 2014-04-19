package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class AtualizaCondutorFormAction {
	private String msg;
	@Action(value="atualizaCondutorForm", results={
			@Result(name="ok", location ="formulario-atualiza.jsp")
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
