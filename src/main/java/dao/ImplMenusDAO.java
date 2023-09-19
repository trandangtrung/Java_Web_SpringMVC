package dao;

import java.util.List;

import org.hibernate.Session;

import entity.Menus;
import utils.HibernateHelper;

public class ImplMenusDAO implements IMenusDAO {
	
	private Session mSs;
	public ImplMenusDAO() {
		mSs = HibernateHelper.getSessionFactory().openSession();
	}
	
	@Override
	public List<Menus> selectAll() {
		mSs.beginTransaction();
		List<Menus> lst = mSs.createQuery("FROM Menus").list();
		mSs.close();
		return lst;
	}

}
