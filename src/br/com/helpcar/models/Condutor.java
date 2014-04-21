package br.com.helpcar.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



/**
 * Classe Model de condutor 
 */

@Entity(name="condutor")  
@Table(name = "condutor")  
@DiscriminatorValue ("c") //Tipo de usuario na tabela usuario
@PrimaryKeyJoinColumn(name="id_usuario") 
@OnDelete(action=OnDeleteAction.CASCADE)
public class Condutor extends Usuario {
	
	
	@Column(name="cnh", length=11)
	private String cnh;
	
	@Column(name="vencimento_cnh")
	private Calendar vencimentoCnh;

	
	@ManyToMany(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinTable(name="condutor_has_veiculos", joinColumns={@JoinColumn(name="id_usuario")}, inverseJoinColumns={@JoinColumn(name="id_veiculo")})
	private List<Veiculo> veiculo;
	
	
	public String getCnh() {
		return cnh;
	}
	

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public Calendar getVencimentoCnh() {
		return vencimentoCnh;
	}
	

	public void setVencimentoCnh(Calendar vencimentoCnh) {
		this.vencimentoCnh = vencimentoCnh;
	}

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
