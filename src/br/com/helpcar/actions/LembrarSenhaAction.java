package br.com.helpcar.actions;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import br.com.helpcar.dao.CondutorDao;
import br.com.helpcar.models.Condutor;
import br.com.helpcar.models.Evento;
import br.com.helpcar.utils.CalendarUtil;
import br.com.helpcar.utils.EncriptadorSenha;
import br.com.helpcar.utils.MailUtil;


public class LembrarSenhaAction {
	private Condutor condutor;
	private Condutor condutorAux;
	private CondutorDao condutorDao;
	private String msg; 
	private String tipo;
	private int senhaProvisoria;
	private String senhaNova;
	


	@Action(value="lembraSenha", results={
			@Result(name="ok", type= "redirectAction", params={"actionName","senhaNovaForm", "msg", "${msg}","tipo","${tipo}", "condutor", "${condutor}"}),
			@Result(name="erro", type= "redirectAction", params={"actionName","lembraSenhaForm", "msg", "${msg}","tipo","${tipo}"} )
	
	})
	public String execute(){
		
		condutorDao = new CondutorDao();
		

		condutor = condutorDao.achaCondutor("email", condutor.getEmail());
		
		if(condutor!=null){
			senhaProvisoria = 100000 + (int)((999999 - 100000)*Math.random());
			condutor.setSenha(EncriptadorSenha.encripta(senhaProvisoria+""));
			condutorDao.atualizaCondutor(condutor);
			MailUtil.sendMail(condutor.getEmail(), escreveMsg(condutor));
			setMsg("Foi enviado com sucesso ao seu e-mail a sua senha provisoria");
			setTipo("success");
			return "ok";
		}else{
			setMsg("Email nao encontrado");
			setTipo("error");
			return "erro";
		}
		

		
	}
	
	@Action(value="senhaNova", results={
			@Result(name="ok", type= "redirectAction", params={"actionName","index", "msg", "${msg}","tipo","${tipo}"}),
			@Result(name="erro", type= "redirectAction", params={"actionName","senhaNovaForm", "msg", "${msg}","tipo","${tipo}","condutor", "${condutor}"}),
	})
	public String execute2(){
		
		condutorDao = new CondutorDao();
		
		
		if(condutorDao.existeCondutor(condutor)){
			condutor.setSenha(EncriptadorSenha.encripta(senhaNova));
			if(condutorDao.atualizaCondutor(condutor)){
				setMsg("Senha atualizada com sucesso");
				setTipo ("success");
				return "ok";
			}
		}
		setMsg("Erro ao atualizar a senha");
		setTipo ("error");
		return "erro";

		
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
	
	public String getSenhaNova() {
		return senhaNova;
	}

	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}

	public StringBuilder escreveMsg(Condutor condutor){
		
	StringBuilder msg = new StringBuilder();
	msg.append("Prezado "+condutor.getNome() +",");
	msg.append(System.getProperty("line.separator") );
	msg.append("Estamos enviando este para informa o seu login e a senha aletoria nova ");
	msg.append(System.getProperty("line.separator") );
	msg.append("Login: "+condutor.getLogin());
	msg.append(System.getProperty("line.separator") );
	msg.append("Senha: "+senhaProvisoria);
	msg.append(System.getProperty("line.separator") );
	msg.append("Atenciosamente,");
	msg.append(System.getProperty("line.separator") );
	msg.append("Equipe Helpcar.");
	
	return msg;
}
	
}
