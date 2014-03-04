package br.com.helpcar.utils;


import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static final SessionFactory ourSessionFactory;

		static {
			try {
				ourSessionFactory = 
						new AnnotationConfiguration().configure().buildSessionFactory();
			} catch (Throwable ex) {
				throw new ExceptionInInitializerError(ex);
			}
		}

	public static Session getSession() throws HibernateException {
		return ourSessionFactory.openSession();
	}

	@SuppressWarnings("deprecation")
	public void close() throws HibernateException, SQLException {
		if (getSession() != null && getSession().isOpen()) {
			 getSession().connection().close();  
			    getSession().close();  
		}
	}

}