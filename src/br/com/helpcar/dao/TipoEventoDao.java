package br.com.helpcar.dao;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.helpcar.listener.HibernateListener;
import br.com.helpcar.models.Evento;
import br.com.helpcar.models.TipoEvento;
import br.com.helpcar.models.Usuario;
import br.com.helpcar.models.Veiculo;

/**
 * Classe persistência do evento
 * @author: Marcio Shigueru Katsumata
 * @version: 1.0
 */
public class TipoEventoDao {
	//variáveis
	private Session session;
	private SessionFactory sessionFactory;
	
	/**
	   * Método construtor VeiculoDao
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	
	public TipoEventoDao(){
		session = null;
	       
  	sessionFactory = 
 	         (SessionFactory) ServletActionContext.getServletContext()
                      .getAttribute(HibernateListener.KEY_NAME);
  
 		session = sessionFactory.openSession();
 		
 		
	}
	
	/**
	   * Método lista eventos
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */

	@SuppressWarnings("unchecked")
	public List<TipoEvento> listaTodos(){
		session.beginTransaction();	
        return session.createCriteria(TipoEvento.class).list();
        
          
         
	}
	

	
	
}
