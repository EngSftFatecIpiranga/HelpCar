package br.com.helpcar.dao;


import java.util.ArrayList;
import java.util.List;




import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;




import br.com.helpcar.listener.HibernateListener;
import br.com.helpcar.models.Condutor;
import br.com.helpcar.models.Veiculo;
import br.com.helpcar.models.Usuario;
/**
 * Classe persistência do veículo
 * @author: Marcio Shigueru Katsumata
 * @version: 1.0
 */

public class VeiculoDao {

	//variáveis
	private Session session;
	private SessionFactory sessionFactory;
	
	/**
	   * Método para construtor veiculo
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	
	public VeiculoDao(){
		session = null;
	       
    	sessionFactory = 
   	         (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);
    
   		session = sessionFactory.openSession();
   		session.beginTransaction();	
   		
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> listaTodos() throws Exception{

               return session.createCriteria(Veiculo.class).add(Restrictions.eq("d_e_l_e_t", false)).list();
          
            
           
	}
	
	/**
	   * Método para cadastrar veiculo
	   * @param Veiculo (objeto)
	   * @throws Exception
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	public boolean cadastraVeiculo(Veiculo veiculo){

		try{

			session.persist(veiculo);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return false;
 			
 			
 		} 
	}
	

}
