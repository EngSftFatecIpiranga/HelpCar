package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
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


public class CadastraUsuarioAction  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Condutor condutor;
	private CondutorDao condutorDao;
	private String msg;
	private String tipo;
	
	
	@Action(value="cadastraUsuario", results={
			@Result(name="success", type= "redirectAction", params={"actionName","loginForm", "msg", "${msg}", "tipo","${tipo}"}),
			@Result(name="erro", type= "redirectAction", params={"actionName","cadastroForm", "msg", "${msg}","tipo","${tipo}"}),
			@Result(name="input", location= "cadastra-usuario.jsp")
			})	
	public String execute(){
		
		condutorDao = new CondutorDao();
		try{
			condutor.setSenha(EncriptadorSenha.encripta(condutor.getSenha()));
			if(!condutorDao.existeCondutor(condutor)){
				condutorDao.cadastraCondutor(condutor);
				setMsg("Usuario cadastrado com sucesso!");
				setTipo("success");
				return "success";
			}else{
				setMsg("Nao foi possivel cadastrar este usuario, j� existe um usuario com este cadastro!");
				setTipo("notice");
				return "erro";
			}
		}catch(Exception e){
			setMsg("N�o foi poss�vel cadastrar este usu�rio. Contate o administrador do sistema."+e);
			setTipo("error");
			System.out.println(e);
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
