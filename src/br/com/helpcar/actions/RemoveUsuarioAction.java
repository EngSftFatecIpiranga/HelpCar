package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.helpcar.dao.EventoDao;
import br.com.helpcar.dao.CondutorDao;
import br.com.helpcar.models.Condutor;
import br.com.helpcar.models.Evento;
import br.com.helpcar.models.Usuario;

public class RemoveUsuarioAction {
	private Condutor condutor;
	private CondutorDao condutorDao;
	@Action(value="removeEvento", results={
			@Result(name="ok", location ="menu.jsp"),
			@Result(name="erro", location="formulario-evento.jsp")
	})	
	public String execute(){
		condutor.setD_e_l_e_t(true);
		condutorDao = new CondutorDao();
		if(condutorDao.atualizaCondutor(condutor)){
			
			return "ok";
		}
		
		return "erro";
	}
}
