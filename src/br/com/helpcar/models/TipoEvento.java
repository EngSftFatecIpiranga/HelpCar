package br.com.helpcar.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tipo_evento")
public class TipoEvento {

	@Id
	@GeneratedValue
	@Column(name="id_tipo", length=6)
	private int idTipo;
	
	@Column (name="nome_evento", length=20)
	private String nomeEvento;
	
	@Column (name="alerta")
	private boolean alerta;
	
	@Column (name="meses_validade")
	private int mesesValidade;
	
	@Column (name="km_validade")
	private int kmValidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_evento", nullable = false)
	private List<Evento> evento;
	
	
	public int getIdTipo() {
		return idTipo;
	}



	public List<Evento> getEvento() {
		return evento;
	}



	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}



	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public boolean isAlerta() {
		return alerta;
	}

	public void setAlerta(boolean alerta) {
		this.alerta = alerta;
	}

	public int getMesesValidade() {
		return mesesValidade;
	}

	public void setMesesValidade(int mesesValidade) {
		this.mesesValidade = mesesValidade;
	}

	public int getKmValidade() {
		return kmValidade;
	}

	public void setKmValidade(int kmValidade) {
		this.kmValidade = kmValidade;
	}
	
	

}
