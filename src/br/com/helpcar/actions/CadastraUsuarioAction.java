package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import br.com.helpcar.models.Condutor;
import br.com.helpcar.models.Usuario;
import br.com.helpcar.utils.EncriptadorSenha;
import br.com.helpcar.dao.CondutorDao;

@ParentPackage("default")
public class CadastraUsuarioAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Condutor condutor;
	private CondutorDao condutorDao;
	private String msg;
	
	
	
	@Action(value="cadastraUsuario", results={
			@Result(name="ok", type= "redirectAction", params={"actionName","loginForm", "msg", "${msg}"}),
			@Result(name="erro", type= "redirectAction", params={"actionName","cadastroForm", "msg", "${msg}"})
			})	
	public String execute(){
		
		condutorDao = new CondutorDao();
		try{
			condutor.setSenha(EncriptadorSenha.encripta(condutor.getSenha()));
			if(!condutorDao.existeCondutor(condutor)){
				condutorDao.cadastraCondutor(condutor);
				setMsg("Usuario cadastrado com sucesso!");
				
			}else{
				setMsg("Nao foi possivel cadastrar este usuario, já existe um usuario com este cadastro!");
				return "erro";
			}
		}catch(Exception e){
			setMsg("Não foi possível cadastrar este usuário. Contate o administrador do sistema."+e);
			System.out.println(e);
			return "erro";
		}
		return "ok";
		
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
