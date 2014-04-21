package br.com.helpcar.actions;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import br.com.helpcar.dao.CondutorDao;
import br.com.helpcar.models.Condutor;
import br.com.helpcar.utils.EncriptadorSenha;


public class LembrarSenhaAction {
	private Condutor condutor;
	private Condutor condutorAux;
	private CondutorDao condutorDao;
	private String msg; 
	private int senhaProvisoria;
	
	@Action(value="lembraSenha", results={
			@Result(name="ok", location ="menu.jsp"),
			@Result(name="erro", location ="menu.jsp")
	
	})
	public String execute(){
		
		condutorDao = new CondutorDao();
		condutorAux = condutorDao.achaCondutor(condutor.getEmail(), "email", condutor.getNome(), "nome", condutor.getCnh(),"cnh");
		if(condutor!=null){
			condutorAux.setSenha(condutor.getSenha());
			condutor = condutorAux;
			ActionContext.getContext().getSession().put("usuarioLogado", condutor);
			return "ok";
		}else{
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
	
}
