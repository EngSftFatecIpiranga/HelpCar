package br.com.helpcar.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;


@Entity
@Table(name="carro")
public class Carro {
	
	@Id
	@GeneratedValue
	@Column(name="id_carro", length=5)
	private int idCarro;
	
	
	@Column(name="nome", length=30)
	private String nome;
	
	@Column(name="placa", length=7)
	private String placa;
	
	@Column(name="marca", length=15)
	private String marca;
	
	@Column(name="modelo", length=30)
	private String modelo;
	
	
	@Column(name="fabricacao")
	private Calendar fabricacao;
	
	
	@Column(name="km_inicial")
	private int kmInicial;
	
	
	@Column(name="km_atual")
	private int kmAtual;


	
	
	
	public int getIdCarro() {
		return idCarro;
	}


	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	
	public String getNome() {
		return nome;
	}

	@RequiredStringValidator(fieldName="nome", message="Campo obrigatório", shortCircuit=true)
	@StringLengthFieldValidator(fieldName="nome", message="Mínimo 3 caracteres", minLength="3")
	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getPlaca() {
		return placa;
	}
	
	@RegexFieldValidator(fieldName="placa", message="o campo placa deve estar no seguinte formato ZZZ-9999", regexExpression="[A-Z][A-Z][A-Z]-[0-9][0-9][0-9][0-9]")
	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getMarca() {
		return marca;
	}

	@RequiredStringValidator(fieldName="marca", message="Campo obrigatório", shortCircuit=true)
	@StringLengthFieldValidator(fieldName="marca", message="Mínimo 3 caracteres, Máximo 15 caracteres", minLength="3", maxLength="15")
	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}
	
	@RequiredStringValidator(fieldName="modelo", message="Campo obrigatório", shortCircuit=true)
	@StringLengthFieldValidator(fieldName="modelo", message="Mínimo 3 caracteres, Máximo 30 caracteres", minLength="3", maxLength="30")
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public Calendar getFabricacao() {
		return fabricacao;
	}


	public void setFabricacao(Calendar fabricacao) {
		this.fabricacao = fabricacao;
	}


	public int getKmInicial() {
		return kmInicial;
	}
	
	@RequiredStringValidator(fieldName="km_inicial", message="Campo obrigatório", shortCircuit=true)
	@RegexFieldValidator(fieldName="km_inicial", message="o campo quilometragem inicial deve estar entre 0 e 999.999", regexExpression="[0-999999]")
	public void setKmInicial(int kmInicial) {
		this.kmInicial = kmInicial;
	}

	
	public int getKmAtual() {
		return kmAtual;
	}
	
	@RequiredStringValidator(fieldName="km_atual", message="Campo obrigatório", shortCircuit=true)
	@RegexFieldValidator(fieldName="km_atual", message="o campo quilometragem atual deve estar entre 0 e 999.999", regexExpression="[0-999999]")
	public void setKmAtual(int kmAtual) {
		this.kmAtual = kmAtual;
	}
	
	
	

}
