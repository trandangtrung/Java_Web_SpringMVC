package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.HoaDon;
import entity.HoaDonChiTiet;
import utils.CartUtil;
import utils.HibernateHelper;

@Service
public class ImplHoaDonChiTietDAO implements IHoaDonChiTietDAO {
	@Autowired
	private ImplHoaDonDAO HoaDonDAO;
	
	private Session mSs;

	public ImplHoaDonChiTietDAO() {
		mSs = HibernateHelper.getSessionFactory().openSession();
	}

	@Override
	public List<HoaDonChiTiet> selectAll() {
		mSs.beginTransaction();
		List<HoaDonChiTiet> lst;
		lst = mSs.createQuery("FROM HoaDonChiTiet").list();
		mSs.getTransaction().commit();
		mSs.close();
		return lst;
	}

	@Override
	public boolean insert(HoaDonChiTiet hdct) {
		mSs.beginTransaction();
		try {
			mSs.save(hdct);
		} catch (Exception e) {
			return false;
		} finally {
			mSs.getTransaction().commit();
			mSs.close();
		}
		return true;
	}

	@Override
	public HoaDonChiTiet selectById(Integer ma_hd) {
		// Mở giao dịch
		mSs.beginTransaction();
		HoaDonChiTiet hdct = (HoaDonChiTiet) mSs.createQuery("FROM HoaDonChiTiet WHERE id = :ma_hd").setParameter("ma_hd", ma_hd)
				.getSingleResult();

		mSs.close();
		return hdct;
	}

	@Override
	public int AddChiTietHD(HoaDonChiTiet hdct) {
		Session mss = null;
		mss = HibernateHelper.getSessionFactory().openSession();
		mss.beginTransaction();
		int insert1 =(Integer) mss.save(hdct);
		mss.getTransaction().commit();
		mss.close();
		return insert1;
	}
	
//	@Override
//	public void AddHoaDonDetail(HashMap<Long, CartUtil> carts) {
//		long ma_hd = GetIDHoaDon();
//		for(Map.Entry<Long, CartUtil> itemCart : carts.entrySet()) {
//			HoaDonChiTiet hdct = new HoaDonChiTiet();
//			hdct.setMa_hd(ma_hd);
//			hdct.setMa_sp(itemCart.getValue().getSanpham().getMa_sp());
//			hdct.setQuanty(itemCart.getValue().getQuanty());
//			hdct.setTotal(itemCart.getValue().getTotalPrice());
//
//		}
//	}
//	
//
//	@Override
//	public int GetIDHoaDon() {
//		Session mss = null;
//		mss = HibernateHelper.getSessionFactory().openSession();
//		mss.beginTransaction();
//		int id = (Integer) mss.createQuery("SELECT MAX(ma_hd) FROM HoaDon").uniqueResult();
//		return id;
//	}


}
