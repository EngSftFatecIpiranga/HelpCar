package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import br.com.helpcar.models.Condutor;
import com.opensymphony.xwork2.ActionContext;


public class CadastroFormAction {
	private String msg;
	private String tipo;
	
	@Action(value="cadastroForm", results={
			@Result(name="ok", location ="formulario-usuario.jsp"),
			@Result(name="logado", location ="index2.jsp")
	})
	public String execute() {
		Condutor condutor = (Condutor) ActionContext.getContext().getSession().get("usuarioLogado");
		if(condutor == null)
			return "ok";
		else
			return "logado";
	}
	
	//******* Getter e Setters da Toast(envio de mensagens JSP)*********//
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
