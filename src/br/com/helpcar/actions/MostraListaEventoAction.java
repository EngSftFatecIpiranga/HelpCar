package br.com.helpcar.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import br.com.helpcar.dao.EventoDao;
import br.com.helpcar.models.Condutor;
import br.com.helpcar.models.Evento;
import br.com.helpcar.models.Veiculo;


@ParentPackage("default")
public class MostraListaEventoAction {
	
	private List<Evento> eventos;
	private EventoDao eventoDao;
	private Veiculo veiculo;
	private String msg;
	private String tipo;

	@Action(value="mostraListaEvento", results={
			@Result(name="ok", location ="listaeventos.jsp"),
			@Result(name="erro", type= "redirectAction", params={"actionName","cadastroEventoForm", "msg", "${msg}","tipo","${tipo}"}),
			@Result(name="veiculoNaoLogado", type= "redirectAction", params={"actionName","index", "msg", "${msg}","tipo","${tipo}"})},
			interceptorRefs= { @InterceptorRef("seguranca")}) 	
	public String execute(){
		veiculo = (Veiculo) ActionContext.getContext().getSession().get("veiculoLogado");
		if(veiculo !=null){
			eventoDao = new EventoDao();
			setEventos( eventoDao.listaEventosVeiculo(veiculo));
			if(eventos==null){
				setMsg("Cadastre eventos");
				setTipo("notice");
				return "erro";
			}
		}else{
			setMsg("Escolha um veiculo ou cadastre um veiculo");
			setTipo("notice");
			return "veiculoNaoLogado";
		}
		
		setMsg("Executamos a sua solicitacao com sucesso");
		setTipo("notice");
		return "ok";
				
	}

	
	public List<Evento> getEventos() {
		return eventos;
	}


	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}


	//******* Getter e Setters da Toast(envio de mensagens JSP)*********//
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
