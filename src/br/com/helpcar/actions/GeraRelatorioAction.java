package br.com.helpcar.actions;

import java.util.Calendar;
import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

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
	
	@Action(value="geraRelatorio", results={
			@Result(name="ok", type="jasper", params ={"location" ,"/jasper/eventos.jasper", "dataSource","eventos", "format", "PDF"}),
			@Result(name="naoExiste", type= "redirectAction", params={"actionName","geraRelatorioForm", "msg", "${msg}", "tipo", "$[tipo}"})},
			interceptorRefs= { @InterceptorRef("seguranca") }) 	
	public String execute(){
		eventoDao = new EventoDao();
		
		Veiculo veiculo = (Veiculo) ActionContext.getContext().getSession().get("veiculoLogado");
		
		List<Evento> eventos = eventoDao.listaEventosVeiculo(veiculo, dataInicial, dataFinal);
		
		if(eventos !=null){
			setMsg("Relatorio gerado com sucesso!");
			setTipo("success");
			 // Normally we would provide a pre-compiled .jrxml file
		    // or check to make sure we don't compile on every request.
		    try {
		        JasperCompileManager.compileReportToFile(
		                "HelpCar/jasper/eventos.jrxml",
		                "HelpCar/jasper/our_compiled_template.jasper");
		    } catch (Exception e) {
		        e.printStackTrace();
		        return "naoExiste";
		    }
			return "ok";
		}else{
			setMsg("Nao existem dados para esse periodo");
			setTipo("error");
			return "naoExiste";
		}
	}

	public Calendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Calendar getDataFinal() {
		return dataFinal;
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

	
}
