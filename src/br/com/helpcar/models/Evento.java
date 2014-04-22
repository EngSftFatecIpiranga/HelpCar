package br.com.helpcar.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_veiculo", nullable = false)
	private Veiculo veiculo;
	
	//Relacionamento com a tabela tipo_evento muitos para um
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo", nullable = false)
	private TipoEvento tipoEvento;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="data_evento")
	private Calendar dataEvento;
	

	@Column(name="custo")
	private double custo;
	
	@Column(name="km_evento")
	private int kmEvento;
	
	@Column(name="data_limite")
	private Calendar dataLimite;


	@Column(name="km_limite")
	private int kmLimite;
	
	@Column(name="litros")
	private int litros;
	
	@Column(name="d_e_l_e_t" , columnDefinition ="tinyint default 0")
	private boolean d_e_l_e_t;
	

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
	
	
	public int getKmLimite() {
		return kmLimite;
	}

	public void setKmLimite(int kmLimite) {
		this.kmLimite = kmLimite;
	}

	public int getLitros() {
		return litros;
	}

	public void setLitros(int litros) {
		this.litros = litros;
	}

	public boolean getD_e_l_e_t() {
		return d_e_l_e_t;
	}

	public void setD_e_l_e_t(boolean d_e_l_e_t) {
		this.d_e_l_e_t = d_e_l_e_t;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	
	
}
