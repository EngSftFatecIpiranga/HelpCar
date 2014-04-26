package br.com.helpcar.jobs;

import java.util.Calendar;
import java.util.List;


import java.util.TimerTask;



import br.com.helpcar.jobs.EventoDao;
import br.com.helpcar.models.Condutor;
import br.com.helpcar.models.Evento;
import br.com.helpcar.utils.CalendarUtil;
import br.com.helpcar.utils.MailUtil;




public class AlertaTask extends TimerTask {
	
	private List<Evento> eventos;
	private List <Condutor> condutores;
	private EventoDao eventoDao;


	public StringBuilder escreveMsg(Condutor condutor, Evento evento){
	
	StringBuilder msg = new StringBuilder();
	msg.append("Prezado "+condutor.getNome() +",");
	msg.append(System.getProperty("line.separator") );
	msg.append("Estamos enviando este e-mail para alerta-lo da troca do seguinte item do seu carro :");
	msg.append(System.getProperty("line.separator") );
	msg.append(evento.getTipoEvento().getNomeEvento() +" vencimento aproximado: "+ CalendarUtil.calendarString(evento.getDataLimite()) + " / "+ evento.getKmLimite()+" km");
	msg.append(System.getProperty("line.separator") );
	msg.append("Atenciosamente,");
	msg.append(System.getProperty("line.separator") );
	msg.append("Equipe Helpcar.");
	
	return msg;
}

	@Override
	public void run() {
		eventoDao = new EventoDao();
		
		eventos = eventoDao.listaEventoVencendoQuinzenal(Calendar.getInstance());
		
		for (Evento evento : eventos){
			condutores= evento.getVeiculo().getCondutor();
			for (Condutor condutor: condutores){
				if(MailUtil.sendMail(condutor.getEmail(), escreveMsg(condutor, evento))){
					System.out.println("E-mail enviado com sucesso para "+condutor.getNome());
				}
				
			}
		}
		
		eventos = eventoDao.listaEventoVencendoSemanal(Calendar.getInstance());
		
		for (Evento evento : eventos){
			condutores= evento.getVeiculo().getCondutor();
			for (Condutor condutor: condutores){
				if(MailUtil.sendMail(condutor.getEmail(), escreveMsg(condutor, evento))){
					System.out.println("E-mail enviado com sucesso para "+condutor.getNome());
				}
				
			}
		}
	}
} 