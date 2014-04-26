package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import br.com.helpcar.dao.EventoDao;
import br.com.helpcar.models.Evento;

@ParentPackage("default")
public class RemoveEventoAction {

	private Evento evento;
	private EventoDao eventoDao;
	private int idEvento;
	private String msg;
	private String tipo;
	
	@Action(value="removeEvento", results={
			@Result(name="ok",type="httpheader", params= {"status", "200"})},
			interceptorRefs= { @InterceptorRef("seguranca") })	
	public String execute(){
		eventoDao = new EventoDao();
		evento= eventoDao.buscaPorId(idEvento);
		evento.setD_e_l_e_t(true);

		if(eventoDao.atualizaEvento(evento)){
			setMsg("Manutenção removida com sucesso!");
			setTipo("success");
			return "ok";
		}

		return "ok";
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}

