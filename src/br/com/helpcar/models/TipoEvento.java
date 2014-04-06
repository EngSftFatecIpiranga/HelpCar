package br.com.helpcar.models;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe Model de tipo de evento 
 */
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoEvento")
	private Set<Evento> evento;
	
	
	public int getIdTipo() {
		return idTipo;
	}



	public Set<Evento> getEvento() {
		return evento;
	}


	public void setEvento(Set<Evento> evento) {
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
