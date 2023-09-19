package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import entity.Users;
import utils.HibernateHelper;



@Service
@Repository
public class ImplAccountDAO implements IAccountDAO {
	
//	
//	@Autowired
//	private BCryptPasswordEncoder  passwordEncoder;
	
	private Session session;

	public ImplAccountDAO() {
		session = HibernateHelper.getSessionFactory().openSession();
	}

//	@Autowired
//	UserUtil userDao = new UserUtil();
	@Override
	public Users AddAccount(String ten, String pass_word) {
		Session session = null;
		session = HibernateHelper.getSessionFactory().openSession();
		session.beginTransaction();
		Users lstp =(Users) session.createQuery("FROM Users Where ten=:ten and pass_word=:pass_word").setParameter("ten", ten)
				.setParameter("pass_word",pass_word).uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		return lstp;
	}
	
	@Override
	public int SaveAccount(Users user) {
//		user.setPass_word(BCrypt.hashpw(user.getPass_word(), BCrypt.gensalt(12)));
		Session mss = null;
		mss = HibernateHelper.getSessionFactory().openSession();
		mss.beginTransaction();
		int insert =(Integer) mss.save(user);
		mss.getTransaction().commit();
		mss.close();
		return insert;
	}

	@Override
	public int CheckAccount(Users user) {
		
		return 0;
	}




}
