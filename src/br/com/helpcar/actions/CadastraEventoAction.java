package br.com.helpcar.actions;
import br.com.helpcar.utils.CalendarUtil;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import br.com.helpcar.utils.EditaTexto;

@ParentPackage("default")
public class CadastraEventoAction {
	private List<Evento> eventos;
	private List<Evento> eventosAux;
	private EventoDao eventoDao;
	private TipoEvento tipoEvento;
	private TipoEventoDao tipoEventoDao;
	private List<TipoEvento> tiposEvento;
	private String msg;
	private String tipo;
	private Veiculo veiculo;

	@Action(value="cadastraEvento", results={
			@Result(name="ok", type= "redirectAction",params={"actionName","listaEventosForm", "msg", "${msg}", "tipo","${tipo}"}),
			@Result(name="erro", type= "redirectAction",params={"actionName","cadatroEventoForm", "msg", "${msg}"})},
					interceptorRefs= { @InterceptorRef("seguranca")})
	public String execute(){
		eventosAux = new ArrayList<Evento>();
		int index = 0;
		veiculo = (Veiculo)ActionContext.getContext().getSession().get("veiculoLogado");
		eventoDao = new EventoDao();
		tipoEventoDao = new TipoEventoDao();
		
		

		for (Evento evento: eventos){

			if(evento.getDataEvento() != null ){
				tipoEvento = tipoEventoDao.buscaPorId(evento.getIdAux());
				evento.setTipoEvento(tipoEvento);
				evento.setDataLimite(verificaVencimentoData(evento));
				evento.setKmLimite(verificaVencimentoKm(evento));

				eventosAux.add(evento);
			}
		}
		eventos = eventosAux;
		if(eventoDao.cadastraListaEventos(eventos, veiculo)){
			setTipo("success");
			setMsg ("Eventos registrados com sucesso!");
			return "ok";
		}
		
		setTipo("error");
		setMsg ("Ocorreu um erro ao cadastrar o veiculo, contacte o administrador");
		return "erro";
	}


	public List<Evento> getEventos() {
		return eventos;
	}


	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
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


	public Calendar verificaVencimentoData(Evento evento){
		Calendar data = null;
		int kmValidade =0;
		int kmMedia = 0;
		int dias;
		
		data= CalendarUtil.stringCalendar(CalendarUtil.calendarString(evento.getDataEvento()));
		kmMedia = veiculo.getKmMediaDia();
		kmValidade = evento.getTipoEvento().getKmValidade();
		dias = kmValidade/kmMedia;
		try{
			data.add(Calendar.DAY_OF_MONTH,dias);
		}catch (Exception e){
			System.out.println(e);
		}
		evento.setDataLimite(data);

		return data;
	}
	
	public int verificaVencimentoKm(Evento evento){

		int kmEvento = 0;
		int kmValidade =0;
		int km1;
		
		kmEvento = evento.getKmEvento();
		kmValidade = evento.getTipoEvento().getKmValidade();
		km1 = kmEvento + kmValidade;


		return km1;
	}


	
}
