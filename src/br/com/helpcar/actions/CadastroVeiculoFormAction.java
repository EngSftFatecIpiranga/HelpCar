package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.InterceptorRef;;

@ParentPackage("default")
public class CadastroVeiculoFormAction {
	private String msg;
	@Action(value="cadastroVeiculoForm", results={
			@Result(name="ok", location ="formulario-veiculo.jsp")},
			interceptorRefs= { @InterceptorRef("seguranca") }) 
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
