package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ParentPackage;
import br.com.helpcar.dao.CondutorDao;
import br.com.helpcar.models.Condutor;

import com.opensymphony.xwork2.ActionContext;

@ParentPackage("default")
public class AtualizaCondutorAction {

	private Condutor condutor;
	private CondutorDao condutorDao;
	private String msg; 
	private String tipo; 

	@Action(value="atualizaCondutor", results={
			@Result(name="ok", location ="menu.jsp"),
			@Result(name="erro", location ="menu.jsp")},
			interceptorRefs= { @InterceptorRef("seguranca") })
	public String execute(){
		
		condutorDao = new CondutorDao();
		try{
			condutor = (Condutor)ActionContext.getContext().getSession().get("usuarioLogado");
			condutorDao.atualizaCondutor(condutor);
			setMsg("Usuario alterado com sucesso!");
			setTipo("success");
			return "ok";
		}catch (Exception e){
			System.out.println(e);
			setMsg("Erro ao atualizado o usuario!");
			setTipo("error");
			return "erro";
		}
		
	}
	
	public Condutor getCondutor() {
		return condutor;
	}
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
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
