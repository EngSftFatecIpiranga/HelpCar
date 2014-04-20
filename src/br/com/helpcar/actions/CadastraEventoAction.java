package br.com.helpcar.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import br.com.helpcar.dao.EventoDao;
import br.com.helpcar.dao.TipoEventoDao;
import br.com.helpcar.models.Evento;
import br.com.helpcar.models.TipoEvento;
import br.com.helpcar.models.Veiculo;

public class CadastraEventoAction {
	private List<Evento> eventos;
	private EventoDao eventoDao;
	private TipoEventoDao tipoEventoDao;
	private List<TipoEvento> tiposEvento;
	private String msg;
	private Veiculo veiculo;
	
	@Action(value="cadastraEvento", results={
			@Result(name="ok", location ="menu.jsp"),
			@Result(name="erro", type= "redirectAction",params={"actionName","cadatroEventoForm", "msg", "${msg}"})
	})
	public String execute(){
		
		int index = 0;
		veiculo = (Veiculo)ActionContext.getContext().getSession().get("veiculoLogado");
		eventoDao = new EventoDao();
		tipoEventoDao = new TipoEventoDao();
		
		tiposEvento = tipoEventoDao.listaTodos();

		for (Evento evento: eventos){
			
			evento.setTipoEvento(tiposEvento.get(index));
			evento.setDataLimite(verificaVencimentoData(evento));
			evento.setKmLimite(verificaVencimentoKm(evento));
			index++;
		}
		if(eventoDao.cadastraListaEventos(eventos, veiculo)){
			setMsg ("Eventos registrados com sucesso!");
			return "ok";
		}
		
		setMsg ("Ocorreu um erro ao cadastrar o usuario, contacte o administrador");
		return "erro";
	}


	public List<Evento> getEventos() {
		return eventos;
	}


	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Calendar verificaVencimentoData(Evento evento){
		Calendar data = null;
		int kmMedia = 0;
		int kmValidade =0;
		int dias;
		
		kmMedia = veiculo.getKmMediaDia();
		kmValidade = evento.getTipoEvento().getKmValidade();
		dias = kmValidade/kmMedia;
		data = evento.getDataEvento();
		data.add(Calendar.DAY_OF_YEAR,dias );

		return data;
	}
	
	public int verificaVencimentoKm(Evento evento){

		int kmEvento = 0;
		int kmValidade =0;
		int km;
		
		kmEvento = evento.getKmEvento();
		kmValidade = evento.getTipoEvento().getKmValidade();
		km = kmEvento + kmValidade;
		


		return km;
	}
}
