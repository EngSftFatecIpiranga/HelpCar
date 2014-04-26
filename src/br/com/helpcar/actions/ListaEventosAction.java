package br.com.helpcar.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import br.com.helpcar.dao.EventoDao;
import br.com.helpcar.dao.TipoEventoDao;
import br.com.helpcar.models.Evento;
import br.com.helpcar.models.TipoEvento;
import br.com.helpcar.models.Veiculo;

@ParentPackage("default")
public class ListaEventosAction {
	private String msg;
	private List<Evento> eventos; 
	private EventoDao eventoDao;
	private Veiculo veiculo;
	@Action(value="listaEventoForm", results={
			@Result(name="ok", location ="lista-eventos.jsp")},
			interceptorRefs= { @InterceptorRef("seguranca") }) 
	public String execute() {
		
		eventoDao = new EventoDao();
		Veiculo veiculo = (Veiculo)ActionContext.getContext().getSession().get("veiculoLogado");
		setEventos(eventoDao.listaEventosVeiculo(veiculo));
		
		return "ok";
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
		
}
