package br.com.helpcar.models;

import java.util.Calendar;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Classe Model de eventos
 */
@Entity
@Table(name="eventos")
public class Evento {
	
	@Id
	@GeneratedValue
	@Column(name="id_evento", length=6)
	private int idEvento;
	
	//Relacionamento com a tabela veiculos muitos para um
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_veiculo", nullable = false)
	private Veiculo veiculo;
	
	//Relacionamento com a tabela tipo_evento muitos para um
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo", nullable = false)
	private TipoEvento tipoEvento;
	
	@Column(name="data_evento")
	private Calendar dataEvento;
	
	@Column(name="km_evento")
	private int kmEvento;
	
	@Column(name="data_limite")
	private Calendar dataLimite;
	
	@Column(name="litros")
	private int litros;
	

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Calendar getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Calendar dataEvento) {
		this.dataEvento = dataEvento;
	}

	public int getKmEvento() {
		return kmEvento;
	}

	public void setKmEvento(int kmEvento) {
		this.kmEvento = kmEvento;
	}

	public Calendar getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Calendar dataLimite) {
		this.dataLimite = dataLimite;
	}

	public int getLitros() {
		return litros;
	}

	public void setLitros(int litros) {
		this.litros = litros;
	}
	
	
	
}
