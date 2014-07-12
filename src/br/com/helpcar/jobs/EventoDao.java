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
	   * Método lista eventos
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */

	@SuppressWarnings("unchecked")
	public List<Evento> listaTodos() throws Exception{
		session.beginTransaction();	
             return session.createCriteria(Evento.class).list();
        
          
         
	}
	
	/**
	   * Método lista eventos de um usuario
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */

	@SuppressWarnings("unchecked")
	public List<Evento> listaEventosVeiculo(Veiculo veiculo) {
		session.beginTransaction();		
    	Query query = session.createQuery("FROM Evento as e WHERE e.id_veiculo = :id_veiculo ").setInteger("id_veiculo", veiculo.getIdVeiculo());
      	List  evento = query.list();
        
      	
      	return evento;
      
        
       
	}
	
	/**
	   * Método para cadastrar evento
	   * @param Veiculo (objeto)
	   * @throws Exception
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	public boolean cadastraEvento(Evento evento){

		try{
			session.beginTransaction();	
			session.persist(evento);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} 
	}
	
	/**
	   * Método para cadastrar evento
	   * @param Veiculo (objeto)
	   * @throws Exception
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	public boolean cadastraListaEventos(List<Evento> eventos, Veiculo veiculo){

		try{
			session.beginTransaction();	
			for(Evento evento:eventos){
				evento.setVeiculo(veiculo);
				session.persist(evento);
			}
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} 
	}
	
	/**
	   * Método para cadastrar evento
	   * @param Veiculo (objeto)
	   * @throws Exception
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	public boolean atualizaEvento(Evento evento){

		try{
			session.beginTransaction();	
			session.update(evento);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} 
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
		Query query = session.createQuery("FROM Evento as e WHERE e.dataLimite = :data_limite ").setCalendar("data_limite", data);
    	List<Evento>  eventos = query.list();
      
    	
    	return eventos;
   
     
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Evento> listaEventoVencendoSemanal(Calendar data) {
		session.beginTransaction();	
		data.add(Calendar.DAY_OF_MONTH,-15);
		Query query = session.createQuery("FROM Evento as e WHERE e.data_limite = : data_limite ").setCalendar("data_limite", data);
    	List<Evento>  eventos = query.list();
      
    	
    	return eventos;
   
     
	}
	
	
}
