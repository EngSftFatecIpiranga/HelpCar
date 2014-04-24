package br.com.helpcar.actions;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;

import br.com.helpcar.dao.EventoDao;
import br.com.helpcar.models.Evento;
import br.com.helpcar.models.Veiculo;

@ParentPackage("default")
public class GeraRelatorioAction {
	private Calendar dataInicial;
	private Calendar dataFinal;
	private EventoDao eventoDao;
	private String msg ;
	private String tipo;
	private List<Evento> eventos;
	private double total;
	//@Result(name="ok", type="jasper", params ={"location" ,"/jasper/eventos.jasper", "dataSource","${eventos}", "format", "PDF"}),
	@Action(value="geraRelatorio", results={
			@Result(name="ok", location = "relatorio-evento.jsp", params={"eventos","${eventos}"}),
			@Result(name="naoExiste", type= "redirectAction", params={"actionName","geraRelatorioForm", "msg", "${msg}", "tipo", "$[tipo}"})},
			interceptorRefs= { @InterceptorRef("seguranca") }) 	
	public String execute(){
		eventoDao = new EventoDao();
			
			Veiculo veiculo = (Veiculo) ActionContext.getContext().getSession().get("veiculoLogado");
		
		eventos = eventoDao.listaEventosVeiculo(veiculo, dataInicial, dataFinal);
		
		for (Evento evento: eventos){
			total += evento.getCusto();
		}
		
		
		if(eventos !=null){
			System.out.println("Gerando relatorio");
			setMsg("Relatorio gerado com sucesso!");
			setTipo("success");

			return "ok";
		}else{
			setMsg("Nao existem dados para esse periodo");
			setTipo("error");
			return "naoExiste";
		}
		
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Calendar getDataInicial() {
		return new GregorianCalendar();
	}

	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Calendar getDataFinal() {
		return new GregorianCalendar();
	}

	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

	
}
