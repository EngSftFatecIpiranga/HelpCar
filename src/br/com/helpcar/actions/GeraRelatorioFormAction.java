package br.com.helpcar.actions;

import java.util.Calendar;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import br.com.helpcar.dao.EventoDao;

@ParentPackage("default")
public class GeraRelatorioFormAction {
	private String msg;
	private String tipo;
	
	
	
	@Action(value="geraRelatorioForm", results={
			@Result(name="ok", location ="formulario-relatorio.jsp")},
			interceptorRefs= { @InterceptorRef("seguranca") }) 	
	public String execute(){

		
		return "ok";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
