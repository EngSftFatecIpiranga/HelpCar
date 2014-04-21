package br.com.helpcar.jobs;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.helpcar.listener.HibernateListener;
import br.com.helpcar.models.Evento;
import br.com.helpcar.models.Usuario;
import br.com.helpcar.models.Veiculo;
import br.com.helpcar.utils.HibernateUtil;

/**
 * Classe persistência do evento
 * @author: Marcio Shigueru Katsumata
 * @version: 1.0
 */
public class EventoDao extends HibernateUtil {
	//variáveis
	private Session session;
	private SessionFactory sessionFactory;
	
	/**
	   * Método construtor VeiculoDao
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	
	public EventoDao(){
		session = getSession();
 		
	}
	

	/**
	   * Método lista eventos de um usuario
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */

	@SuppressWarnings("unchecked")
	public List<Evento> listaEventoVencendoQuinzenal(Calendar data) {
		session.beginTransaction();	
		data.add(Calendar.DAY_OF_MONTH,15);
		data.set(Calendar.HOUR_OF_DAY,0);
		data.set(Calendar.MINUTE,0);
		data.set(Calendar.SECOND,0);
		Query query = session.createQuery("FROM Evento as e WHERE e.dataLimite = :data_limite and e.d_e_l_e_t = :d_e_l_e_t").setCalendar("data_limite", data).setBoolean("d_e_l_e_t", false);
    	List<Evento>  eventos = query.list();
      
    	
    	return eventos;
   
     
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Evento> listaEventoVencendoSemanal(Calendar data) {
		session.beginTransaction();	
		data.add(Calendar.DAY_OF_MONTH,7);
		data.set(Calendar.HOUR_OF_DAY,0);
		data.set(Calendar.MINUTE,0);
		data.set(Calendar.SECOND,0);
		Query query = session.createQuery("FROM Evento as e WHERE e.data_limite = : data_limite and e.d_e_l_e_t = :d_e_l_e_t ").setCalendar("data_limite", data).setBoolean("d_e_l_e_t", false);
    	List<Evento>  eventos = query.list();
      
    	
    	return eventos;
   
     
	}
	
	
}
