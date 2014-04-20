package br.com.helpcar.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import br.com.helpcar.jobs.JobAlertaEvento;

public class QuartzSchedulerListener implements ServletContextListener {
	 
	public void contextDestroyed(ServletContextEvent arg0) {
		//
	}
 
	public void contextInitialized(ServletContextEvent arg0) {
 
		JobDetail job = JobBuilder.newJob(JobAlertaEvento.class)
			.withIdentity("alertaEvento", "alertas").build();
 
		try {
 
			Trigger trigger = TriggerBuilder
			  .newTrigger()
			  .withIdentity("trigger20hrs", "Trigger1")
			  .withSchedule(
			     CronScheduleBuilder.cronSchedule("0 37 19 ? * *")) //Agendando às 20 hrs todos os dias.
			  .build();
 
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);
 
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
 
	}
}