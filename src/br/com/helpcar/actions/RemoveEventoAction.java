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
	@Action(value="removeEvento", results={
			@Result(name="ok", location ="menu.jsp"),
			@Result(name="erro", location="formulario-evento.jsp")},
			interceptorRefs= { @InterceptorRef("seguranca") })	
	public String execute(){
		evento.setD_e_l_e_t(true);
		eventoDao = new EventoDao();
		if(eventoDao.atualizaEvento(evento)){
			
			return "ok";
		}
		
		return "erro";
	}

}