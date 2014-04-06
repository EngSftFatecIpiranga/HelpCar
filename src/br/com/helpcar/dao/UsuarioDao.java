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
import br.com.helpcar.models.Usuario;
/**
 * Classe Dao de Usuário
 */
public class UsuarioDao  {
	
	/**
	   * Método para listar todos os usuários.
	   * @param none
	   * @throws Exception
	   * @return List de usuário
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	@SuppressWarnings("unchecked")
	public List<Usuario> listaTodos() throws Exception{
		Session session = null;
       
        	SessionFactory sessionFactory = 
       	         (SessionFactory) ServletActionContext.getServletContext()
                            .getAttribute(HibernateListener.KEY_NAME);
        
       		session = sessionFactory.openSession();
       		session.beginTransaction();	
               return session.createCriteria(Usuario.class).list();
          
            
           
	}
	
	/**
	   * Método para procurar usuários.
	   * @param String valor do campo 
	   * @param String nome do campo
	   * @throws Exception
	   * @return List de usuário
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	@SuppressWarnings("unchecked")
	public List<Usuario> achaUsuario(String valor, String campo) throws Exception{
		Session session = null;
		
		SessionFactory sessionFactory = 
      	         (SessionFactory) ServletActionContext.getServletContext()
                           .getAttribute(HibernateListener.KEY_NAME);
       
      		session = sessionFactory.openSession();
      		session.beginTransaction();	
	    	if (campo.equals("nome")){
	    		return (List<Usuario>) session.createCriteria(Usuario.class)
	    	            .add(Restrictions.like(campo,valor, MatchMode.END));
			}else{
				return (List<Usuario>) session.createCriteria(Usuario.class)
	    	            .add(Restrictions.eq(campo,valor));
			}
	    	
	}
	
	/**
	   * Método para verificar se o usuário 
	   * informado está cadastrado no banco.
	   * @param Usuario (objeto)
	   * @throws Exception
	   * @return boolean
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	public boolean existeUsuario(Usuario usuario) throws Exception{
		Session session = null;
		SessionFactory sessionFactory = 
      	         (SessionFactory) ServletActionContext.getServletContext()
                           .getAttribute(HibernateListener.KEY_NAME);
       
      	session = sessionFactory.openSession();
      	
      	session.beginTransaction();	
      	Query query = session.createQuery("FROM Usuario as l WHERE l.login = :login AND l.senha = :senha").setString("senha", usuario.getSenha()).setString("login", usuario.getLogin());
      	List  usuarios = query.list();
      	boolean existeUsuario = (usuarios != null && !usuarios.isEmpty());
      	session.getTransaction().commit();// fecha a transação
      	
     
      	return existeUsuario;
		
	}
	
	/**
	   * Método para cadastrar usuarios
	   * @param Usuario (objeto)
	   * @throws Exception
	   * @author Marcio Katsumata
	   * @since 1.0
	   * @version 1.0
	   */
	public void cadastraUsuario(Usuario usuario){
		Session session = null;
		try{
			SessionFactory sessionFactory = 
	      	         (SessionFactory) ServletActionContext.getServletContext()
	                           .getAttribute(HibernateListener.KEY_NAME);
	       
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(usuario);
			session.getTransaction().commit();
			
		}catch (Exception e) {
			session.getTransaction().rollback();
   			throw new HibernateException(e);
   		} 
	}
	

}
