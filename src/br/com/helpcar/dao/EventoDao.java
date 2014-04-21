package br.com.helpcar.dao;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.helpcar.listener.HibernateListener;
import br.com.helpcar.models.Evento;
import br.com.helpcar.models.Usuario;
import br.com.helpcar.models.Veiculo;

/**
 * Classe persist�ncia do evento
 * @author: Marcio Shigueru Katsumata
 * @version: 1.0
 */
public class EventoDao {
	//vari�veis
	private Session session;
	private SessionFactory sessionFactory;
	
	/**
	   * M�todo construtor VeiculoDao
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	
	public EventoDao(){
		session = null;
	       
  	sessionFactory = 
 	         (SessionFactory) ServletActionContext.getServletContext()
                      .getAttribute(HibernateListener.KEY_NAME);
  
 		session = sessionFactory.openSession();
 		
 		
	}
	
	/**
	   * M�todo lista eventos
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */

	@SuppressWarnings("unchecked")
	public List<Evento> listaTodos() throws Exception{
		session.beginTransaction();	
             return session.createCriteria(Evento.class).add(Restrictions.eq("d_e_l_e_t", false)).list();
        
          
         
	}
	
	/**
	   * M�todo lista eventos de um usuario
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */

	@SuppressWarnings("unchecked")
	public List<Evento> listaEventosVeiculo(Veiculo veiculo) {
		session.beginTransaction();		
    	Query query = session.createQuery("FROM Evento as e WHERE e.id_veiculo = :id_veiculo and e.d_e_l_e_t = :d_e_l_e_t ").setInteger("id_veiculo", veiculo.getIdVeiculo()).setBoolean("d_e_l_e_t", false) 	;
      	List  evento = query.list();
        
      	
      	return evento;
      
        
       
	}
	
	/**
	   * M�todo para cadastrar evento
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
	   * M�todo para cadastrar evento
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
	   * M�todo para cadastrar evento
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

	
	
}
