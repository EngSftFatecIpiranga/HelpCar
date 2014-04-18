package br.com.helpcar.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import br.com.helpcar.dao.EventoDao;
import br.com.helpcar.models.Evento;
import br.com.helpcar.models.Veiculo;

public class CadastraEventoAction {
	private List<Evento> eventos;
	private EventoDao eventoDao;
	private String msg;
	private Veiculo veiculo;
	
	@Action(value="cadastraEvento", results={
			@Result(name="ok", location ="menu.jsp"),
			@Result(name="erro", type= "redirectAction",params={"actionName","cadatroEventoForm", "msg", "${msg}"})
	})
	public String execute(){
		
		
		veiculo = (Veiculo)ActionContext.getContext().getSession().get("veiculoLogado");
		eventoDao = new EventoDao();
		
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

	
}
