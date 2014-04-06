package br.com.helpcar.dao;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.helpcar.listener.HibernateListener;
import br.com.helpcar.models.Veiculo;
import br.com.helpcar.models.Usuario;

public class VeiculoDao {
	
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> listaTodos() throws Exception{
		Session session = null;
       
        	SessionFactory sessionFactory = 
       	         (SessionFactory) ServletActionContext.getServletContext()
                            .getAttribute(HibernateListener.KEY_NAME);
        
       		session = sessionFactory.openSession();
       		session.beginTransaction();	
               return session.createCriteria(Veiculo.class).list();
          
            
           
	}
	
}
