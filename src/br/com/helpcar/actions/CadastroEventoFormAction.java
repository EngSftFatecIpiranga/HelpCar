package br.com.helpcar.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import br.com.helpcar.dao.TipoEventoDao;
import br.com.helpcar.models.TipoEvento;
import br.com.helpcar.models.Veiculo;

@ParentPackage("default")
public class CadastroEventoFormAction {
	private String msg;
	private List<TipoEvento> tiposEvento; 
	private TipoEventoDao tipoEventoDao;
	private Veiculo veiculo;
	
	@Action(value="cadastroEventoForm", results={
			@Result(name="ok", location ="formulario-evento.jsp")},
			interceptorRefs= { @InterceptorRef("seguranca") }) 
	public String execute() {
		tipoEventoDao = new TipoEventoDao();

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
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
