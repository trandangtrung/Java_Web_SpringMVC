package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {
	private static SessionFactory sf;
	private HibernateHelper() {
		
	}
	public static SessionFactory getSessionFactory() {
		if(sf== null) {
			sf = new Configuration().configure().buildSessionFactory();
		}
		return sf;
	}
}
