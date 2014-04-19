package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.helpcar.dao.CondutorDao;
import br.com.helpcar.models.Condutor;

import com.opensymphony.xwork2.ActionContext;

public class AtualizaCondutorAction {

	private Condutor condutor;
	private CondutorDao condutorDao;
	private String msg; 
	private String tipoMsg; 

	@Action(value="atualizaCondutor", results={
			@Result(name="ok", location ="menu.jsp"),
			@Result(name="erro", location ="menu.jsp")
	
	})
	public String execute(){
		
		condutorDao = new CondutorDao();
		try{
			condutor = (Condutor)ActionContext.getContext().getSession().get("usuarioLogado");
			condutorDao.atualizaCondutor(condutor);
			setMsg("Usuario alterado com sucesso!");
			setTipoMsg("success");
			return "ok";
		}catch (Exception e){
			System.out.println(e);
			setMsg("Erro ao atualizado o usuario!");
			setTipoMsg("error");
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

	public String getTipoMsg() {
		return tipoMsg;
	}

	public void setTipoMsg(String tipoMsg) {
		this.tipoMsg = tipoMsg;
	}
	
}
