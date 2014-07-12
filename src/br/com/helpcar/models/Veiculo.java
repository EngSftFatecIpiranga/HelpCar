package br.com.helpcar.models;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

/**
 * Classe Model de veiculo 
 */
@Entity
@Table(name="veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue
	@Column(name="id_veiculo", length=5)
	private int idVeiculo;
	
	@Column(name="nome", length=30)
	private String nome;
	
	@Column(name="placa", length=7)
	private String placa;
	
	@Column(name="marca", length=15)
	private String marca;
	
	@Column(name="modelo", length=30)
	private String modelo;
	
	
	@Column(name="fabricacao", length=4)
	private int fabricacao;
	
	
	@Column(name="km_inicial")
	private int kmInicial;
	
	
	@Column(name="km_atual")
	private int kmAtual;
	
	@Column(name="km_media_dia")
	private int kmMediaDia;



	 @ManyToMany(cascade=CascadeType.ALL , fetch= FetchType.EAGER, mappedBy="veiculo")
	private List<Condutor> condutor;
	

	 @OneToMany(fetch= FetchType.EAGER, mappedBy = "veiculo")
	private Set<Evento> evento;
	 
	 
	 @Column(name="d_e_l_e_t" , columnDefinition ="tinyint default 0")
	private boolean d_e_l_e_t;
	
	
	
	
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


	public int getFabricacao() {
		return fabricacao;
	}
	
	@RequiredStringValidator(fieldName="fabricacao", message="Campo obrigatório", shortCircuit=true)
	@RegexFieldValidator(fieldName="fabricacao", message="o campo fabricao deve estar no seguinte formato 9999", regexExpression="[0-9][0-9][0-9][0-9]")
	public void setFabricacao(int fabricacao) {
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


	public int getIdVeiculo() {
		return idVeiculo;
	}


	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}


	public List<Condutor> getCondutor() {
		return condutor;
	}


	public void setCondutor(List<Condutor> condutor) {
		this.condutor = condutor;
	}

	public boolean isD_e_l_e_t() {
		return d_e_l_e_t;
	}

	public void setD_e_l_e_t(boolean d_e_l_e_t) {
		this.d_e_l_e_t = d_e_l_e_t;
	}

	public Set<Evento> getEvento() {
		return evento;
	}

	public void setEvento(Set<Evento> evento) {
		this.evento = evento;
	}

	public int getKmMediaDia() {
		return kmMediaDia;
	}

	public void setKmMediaDia(int kmMediaDia) {
		this.kmMediaDia = kmMediaDia;
	}



	
	
	

}
