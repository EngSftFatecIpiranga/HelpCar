package br.com.helpcar.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

@Validations
@Entity
@Table(name="usuario")

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
	
	@Column(name="cnh", length=11)
	private String cnh;
	
	@Column(name="data_nascimento")
	private Calendar vencimentoCnh;
	
	@Column(name="nomeUsuario")
	private String nomeUsuario;
	
	@Column(name="senha")
	private String senha;
	
	
	public String getNome() {
		return nome;
	}
	
	@RequiredStringValidator(fieldName="nome", message="Campo obrigatório", shortCircuit=true)
	@StringLengthFieldValidator(fieldName="nome", message="Mínimo 10 caracteres", minLength="10")
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	
	@RequiredFieldValidator(fieldName="dataNascimento", message="Campo data nascimento obrigatório")
	@DateRangeFieldValidator(fieldName="dataNascimento", message = "Data inválida", shortCircuit = true, min = "01/01/1900")
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCelular() {
		return celular;
	}
	
	@RegexFieldValidator(fieldName="celular", message="O campo celular deve estar no seguinte formato XX-XXXXX-XXXX", regexExpression="[0-9][0-9]-[0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]")
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCnh() {
		return cnh;
	}
	
	@RegexFieldValidator(fieldName="cnh", message="O campo CNH deve estar no seguinte formato XXXXXXXXXXX", regexExpression="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public Calendar getVencimentoCnh() {
		return vencimentoCnh;
	}
	
	@RequiredFieldValidator(fieldName="vencimentoCnh", message="Campo data vencimento CNH obrigatório")
	@DateRangeFieldValidator(fieldName="vencimentoCnh", message = "Data inválida", shortCircuit = true, min = "01/01/1900")
	public void setVencimentoCnh(Calendar vencimentoCnh) {
		this.vencimentoCnh = vencimentoCnh;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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
	
	
}


