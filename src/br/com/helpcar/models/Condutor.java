package br.com.helpcar.models;

import java.util.Calendar;

import javax.persistence.*;


import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;


@Validations
@Entity(name="condutor")
public class Condutor extends Usuario {
	
	
	@Column(name="cnh", length=11)
	private String cnh;
	
	@Column(name="vencimento_cnh")
	private Calendar vencimentoCnh;

	
	@ManyToMany
    @JoinTable(name="condutor_has_veiculos", joinColumns={@JoinColumn(name="cnh")}, inverseJoinColumns={@JoinColumn(name="id_veiculo")})
	private Veiculo veiculo;
	

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
	
	
}
