package br.com.helpcar.listener;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.helpcar.jobs.AlertaTask;


public class TaskReminder implements ServletContextListener {
	 
	public void contextDestroyed(ServletContextEvent arg0) {
		//
	}
 
	public void contextInitialized(ServletContextEvent arg0) {
		//Data do dia corrente  
		Calendar dataIni = new GregorianCalendar();  
		  
		//Seta a data inicial para o dia seguinte, ou seja, a próxima 00hs          
		//dataIni.add(Calendar.DAY_OF_MONTH, 1);//1 dia após a data corrente  
		 
		//Seta a hora = 18:30 (Meia noite)  
		dataIni.set(Calendar.HOUR_OF_DAY, 18);  
		dataIni.set(Calendar.MINUTE, 30);  
		dataIni.set(Calendar.SECOND, 0);  
		Date time = dataIni.getTime();  
		//Instancia o timer  
		Timer timer= new Timer();  
		  
		//Intervalo para executar a classe novamente  
		//86400 = qtd segundos em 24hs  
		//long periodo = 86400*1000;  
		
		
		//Teste com 30 segundos.
		long periodo = 30*1000; 
		//Agenda a tarefa  
		
		//timer.scheduleAtFixedRate(new AlertaTask(), time, periodo);
		
		//dispara só 1 vez para testes
		timer.schedule(new AlertaTask(), periodo);
	}
 
	
}

