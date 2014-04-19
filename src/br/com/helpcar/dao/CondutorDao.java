package br.com.helpcar.dao;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		session = null;
	       
    	sessionFactory = 
   	         (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);
    
   		session = sessionFactory.openSession();
   		
   		
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
				session.beginTransaction();	
               return session.createCriteria(Condutor.class).list();
          
            
           
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
		session.beginTransaction();	
	    	if (campo.equals("nome")){
	    		return (List<Condutor>) session.createCriteria(Condutor.class)
	    	            .add(Restrictions.like(campo,valor, MatchMode.END));
			}else{
				return (List<Condutor>) session.createCriteria(Condutor.class)
	    	            .add(Restrictions.eq(campo,valor));
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
	public boolean existeCondutor(Usuario usuario){
		try{
			session.beginTransaction();	
      		Query query = session.createQuery("FROM Usuario as l WHERE l.login = :login AND l.senha = :senha").setString("senha", usuario.getSenha()).setString("login", usuario.getLogin());
      		List  usuarios = query.list();
      		boolean existeUsuario = (usuarios != null && !usuarios.isEmpty());
      		session.getTransaction().commit();
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
		session.beginTransaction();	
		return (Condutor) session.createCriteria(Condutor.class)
		            .add(Restrictions.eq("login",condutor.getLogin())).uniqueResult();
    	


		
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

		try{
			session.beginTransaction();	
			session.persist(condutor);
			session.getTransaction().commit();
			return true;
			
		}catch (Exception e) {
			session.getTransaction().rollback();
   		
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
		try{
			session.beginTransaction();	
			session.update(condutor);
			session.getTransaction().commit();
			return true;
		
		}catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println(e);
			return false;
		} 
		
	}
	
	public Condutor achaCondutor(String valor1, String campo1,String valor2, String campo2,String valor3, String campo3) {
		try{
			session.beginTransaction();	
			return (Condutor) session.createCriteria(Condutor.class)
			            .add(Restrictions.eq(campo1,valor1)).add(Restrictions.eq(campo2,valor2))
			            .add(Restrictions.eq(campo3,valor3)).uniqueResult();
		
		}catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println(e);

		}
		return null; 
		
	}
	
	
	

}
