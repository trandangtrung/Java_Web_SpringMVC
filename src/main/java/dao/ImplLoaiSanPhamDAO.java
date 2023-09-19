package dao;

import java.util.List;

import org.hibernate.Session;

import entity.LoaiSanPham;
import utils.HibernateHelper;

public class ImplLoaiSanPhamDAO implements ILoaiSanPhamDAO {
	private Session mSs;
	public ImplLoaiSanPhamDAO(){
		mSs = HibernateHelper.getSessionFactory().openSession();
	}
	@Override
	public List<LoaiSanPham> GetLoaiSanPham() {
		mSs.beginTransaction();
		List<LoaiSanPham> lst = mSs.createQuery("FROM LoaiSanPham").list();
		mSs.close();
		return lst;	
	}
	@Override
	public LoaiSanPham GetLoaiSanPhamId(int ma_lsp) {
		mSs.beginTransaction();
		LoaiSanPham lsp = (LoaiSanPham)mSs.createQuery("FROM LoaiSanPham where id = :malsp").setParameter("malsp", ma_lsp).
				getSingleResult();
		mSs.getTransaction().commit();
		mSs.close();
		return lsp;
	}

}
