package br.com.helpcar.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import br.com.helpcar.dao.TipoEventoDao;
import br.com.helpcar.models.Condutor;
import br.com.helpcar.models.TipoEvento;
import br.com.helpcar.models.Veiculo;

public class CadastroEventoFormAction {
	private String msg;
	private List<TipoEvento> tiposEvento;
	private TipoEventoDao tipoEventoDao;
	private Veiculo veiculo;
	
	@Action(value="cadastroEventoForm", results={
			@Result(name="ok", location ="formulario-evento.jsp")
	})
	public String execute() {

		setTiposEvento(tipoEventoDao.listaTodos());
		
		return "ok";
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<TipoEvento> getTiposEvento() {
		return tiposEvento;
	}
	public void setTiposEvento(List<TipoEvento> tiposEvento) {
		this.tiposEvento = tiposEvento;
	}
	
	
}
