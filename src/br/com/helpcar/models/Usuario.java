package br.com.helpcar.models;

import java.util.Calendar;

import javax.persistence.*;

import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

/**
 * Classe Model de usuario 
 */

@Entity  
@Table(name = "usuario",  uniqueConstraints = @UniqueConstraint(columnNames = "id_usuario"))  
@Inheritance(strategy = InheritanceType.JOINED )// Garante que os atributos padrões da superclasse sejam mapeados nesta classe.  
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType=DiscriminatorType.STRING) //Tipo de usuario
public class Usuario {
	
	@Id
	@GeneratedValue
	@Column(name="id_usuario")
	private int idUsuario;
	
	@Column(name="nome", length=60)
	private String nome;
	
	@Column(name="data_nascimento")
	private Calendar dataNascimento;
	
	@Column(name="celular", length=11)
	private String celular;
	
	@Column(name="email", length=45)
	private String email;


	@Column(name="login")
	private String login;
	
	@Column(name="senha")
	private String senha;
	
	
	@Column(name="d_e_l_e_t" , columnDefinition ="tinyint default 0")
	private boolean d_e_l_e_t;
	
	public String getNome() {
		return nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCelular() {
		return celular;
	}
	

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean isD_e_l_e_t() {
		return d_e_l_e_t;
	}

	public void setD_e_l_e_t(boolean d_e_l_e_t) {
		this.d_e_l_e_t = d_e_l_e_t;
	}
	
	
}


