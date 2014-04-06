package br.com.helpcar.dao;

import java.util.List;

import org.hibernate.Query;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.helpcar.listener.HibernateListener;
import br.com.helpcar.models.Usuario;

public class UsuarioDao  {

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
	
	public boolean existeUsuario(Usuario usuario) throws Exception{
		Session session = null;
		SessionFactory sessionFactory = 
      	         (SessionFactory) ServletActionContext.getServletContext()
                           .getAttribute(HibernateListener.KEY_NAME);
       
      	session = sessionFactory.openSession();
      	
      	session.beginTransaction();	
      	Query query = session.createQuery("FROM Usuario as l WHERE l.nome = :nome AND l.senha = :senha").setString("senha", usuario.getSenha()).setString("nome", usuario.getNomeUsuario());
      	List  usuarios = query.list();
      	boolean existeUsuario = (usuarios != null && !usuarios.isEmpty());
      	session.getTransaction().commit();// fecha a transação
      	
     
      	return existeUsuario;
		
	}
	
	public void cadastraProduto(Usuario usuario){
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
