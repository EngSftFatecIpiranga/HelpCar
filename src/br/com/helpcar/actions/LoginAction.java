package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.helpcar.dao.UsuarioDao;
import br.com.helpcar.models.Usuario;
import br.com.helpcar.utils.EncriptadorSenha;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Hello
	private Usuario usuario;
	
	@Action(value="login", results={
			@Result(name="ok", location ="menu.jsp"),
			@Result(name="invalido", location="formulario-login.jsp")
	})
	public String login() throws Exception{
		if(new UsuarioDao().existeUsuario(usuario)){
			usuario.setSenha(EncriptadorSenha.encripta(usuario.getSenha()) );
			ActionContext.getContext().getSession().put("usuarioLogado", usuario);
			return "ok";
		}else{
			
			return "invalido";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	
	
	
 

}