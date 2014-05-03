package br.com.helpcar.dao;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.infinispan.loaders.modifications.Commit;

import br.com.helpcar.listener.HibernateListener;
import br.com.helpcar.models.Condutor;
import br.com.helpcar.models.Usuario;
/**
 * Classe de persistência do condutor
 */
public class CondutorDao  {
	private Session session;
	private SessionFactory sessionFactory;
	
	
	/**
	   * Método construtor de persistência do condutor
	   * @param none
	   * @throws Exception
	   * @return List de condutores
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	
	public CondutorDao(){

   		
   		
	}
	
	
	/**
	   * Método para listar todos os condutores.
	   * @param none
	   * @throws Exception
	   * @return List de condutores
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	@SuppressWarnings("unchecked")
	public List<Condutor> listaTodos() throws Exception{
		session = null;
	       
    	sessionFactory = 
   	         (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);
    
   		session = sessionFactory.openSession();
		try{
				session.beginTransaction();	
               return session.createCriteria(Condutor.class).add(Restrictions.eq("d_e_l_e_t", false)).list();
		}finally{
			session.close();
		}
            
           
	}
	
	/**
	   * Método para procurar condutores .
	   * @param String valor do campo 
	   * @param String nome do campo
	   * @throws Exception
	   * @return List de condutores
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	@SuppressWarnings("unchecked")
	public List<Condutor> achaListaCondutores(String valor, String campo) throws Exception{
		session = null;
	       
    	sessionFactory = 
   	         (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);
    
   		session = sessionFactory.openSession();
		
		session.beginTransaction();	
		List condutores ;
	    	if (campo.equals("nome")){
	    		condutores =  (List<Condutor>) session.createCriteria(Condutor.class)
	    	            .add(Restrictions.like(campo,valor, MatchMode.END)).add(Restrictions.eq("d_e_l_e_t", false));
	    		session.close();
	    		return condutores;
			}else{
				condutores = (List<Condutor>) session.createCriteria(Condutor.class)
	            .add(Restrictions.eq(campo,valor)).add(Restrictions.eq("d_e_l_e_t", false));
				session.close();
				return condutores;
			}
		
			
		
	}
	
	/**
	   * Método para verificar se existe o condutor 
	   * informado está cadastrado no banco.
	   * @param Condutor (objeto)
	   * @return boolean
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	public boolean existeCondutor(Condutor condutor){
		session = null;
	       
    	sessionFactory = 
   	         (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);
    
   		session = sessionFactory.openSession();
		try{
			session.beginTransaction();	
			Criterion rest1= Restrictions.eq("login", condutor.getLogin());
			Criterion rest2= Restrictions.eq("cnh", condutor.getCnh());
	
			List  usuarios= session.createCriteria(Condutor.class).add(Restrictions.or(rest1,rest2)).list();
     
      		boolean existeUsuario = (usuarios != null && !usuarios.isEmpty());
      		session.getTransaction().commit();
      		session.close();
      		return existeUsuario;
		}catch (Exception e){
			return false;
		}
     

		
	}
	/**
	   * Método para verificar se existe o condutor 
	   * informado está cadastrado no banco.
	   * @param Condutor (objeto)
	   * @return boolean
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	public boolean existeLoginCondutor(Condutor condutor){
		session = null;
	       
  	sessionFactory = 
 	         (SessionFactory) ServletActionContext.getServletContext()
                      .getAttribute(HibernateListener.KEY_NAME);
  
 		session = sessionFactory.openSession();
		try{
			session.beginTransaction();	

	
			List  usuarios= session.createCriteria(Condutor.class).add(Restrictions.eq("login",condutor.getLogin())).add(Restrictions.eq("senha", condutor.getSenha())).list();
   
    		boolean existeUsuario = (usuarios != null && !usuarios.isEmpty());
    		session.getTransaction().commit();
    		session.close();
    		return existeUsuario;
		}catch (Exception e){
			return false;
		}
   

		
	}
	/**
	   * Método para achar um condutor
	   * informado está cadastrado no banco.
	   * @param Usuario (objeto)
	   * @return Condutor
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	public Condutor achaCondutor(Condutor condutor) {
		session = null;
	       
    	sessionFactory = 
   	         (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);
    
   		session = sessionFactory.openSession();
		
		session.beginTransaction();	
		Condutor condutorAux = (Condutor) session.createCriteria(Condutor.class)
	            .add(Restrictions.eq("login",condutor.getLogin())).add(Restrictions.eq("d_e_l_e_t", false)).uniqueResult();
		session.close();
		return condutorAux;
    	

	
		
	}
	
	/**
	   * Método para cadastrar usuarios
	   * @param Usuario (objeto)
	   * @throws Exception
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	public boolean cadastraCondutor(Condutor condutor){
		session = null;
	       
    	sessionFactory = 
   	         (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);
    
   		session = sessionFactory.openSession();
		try{
			session.beginTransaction();	
			session.persist(condutor);
			session.getTransaction().commit();
			session.close();
			return true;
			
		}catch (Exception e) {
			session.getTransaction().rollback();
			session.close();
   			return false;
   		} 
	}
	/**
	   * Método para cadastrar usuarios
	   * @param Usuario (objeto)
	   * @throws Exception
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	public boolean atualizaCondutor(Condutor condutor) {
		session = null;
	       
    	sessionFactory = 
   	         (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);
    
   		session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			session.update(condutor);
			session.getTransaction().commit();
			session.close();
			return true;
		
		}catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println(e);
			session.close();
			return false;
		} 
		
	}
	
	public Condutor achaCondutor( String campo1, String valor1) {
		session = null;
	       
    	sessionFactory = 
   	         (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);
    
   		session = sessionFactory.openSession();
		try{
			
			session.beginTransaction();	
			Condutor condutor = (Condutor) session.createCriteria(Condutor.class)
            .add(Restrictions.eq(campo1,valor1)).uniqueResult();
			
			session.close();
			return condutor;
		
		}catch (Exception e) {
			session.getTransaction().rollback();
			session.close();
			System.out.println(e);
			return null;
		}
	}
	
	
	

}
