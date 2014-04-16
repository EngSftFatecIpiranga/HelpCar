package br.com.helpcar.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.helpcar.dao.EventoDao;
import br.com.helpcar.models.Evento;
import br.com.helpcar.models.Veiculo;

public class MostraListaEventoAction {
	
	private List<Evento> eventos;
	private EventoDao eventoDao;
	private Veiculo veiculo;

	@Action(value="removeEvento", results={
			@Result(name="ok", location ="menu.jsp"),
			@Result(name="erro", location="formulario-evento.jsp")
	})	
	public String execute(){

		eventoDao = new EventoDao();
		eventoDao.listaEventosVeiculo(veiculo);
		return "ok";
				
	}
}
