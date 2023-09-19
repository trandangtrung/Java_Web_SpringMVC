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
public class ImplHoaDonDAO implements IHoaDonDAO {
	
	@Autowired
	private  ImplHoaDonChiTietDAO hoadonctDAO;
	
	private Session mSs;

	private Session AddHoaDonDetail;

	public ImplHoaDonDAO() {
		mSs = HibernateHelper.getSessionFactory().openSession();
	}

	@Override
	public List<HoaDon> selectAll() {
		mSs.beginTransaction();
		List<HoaDon> lst = mSs.createQuery("FROM HoaDon").list();
		mSs.close();
		return lst;
	}


	@Override
	public boolean update(HoaDon hd) {
		// Mở giao dịch
		mSs.beginTransaction();
		try {
			mSs.update(hd); // Cập nhật
			mSs.getTransaction().commit(); // Xác nhận sự thay đổi dữ liệu
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			mSs.close();
		}
		return false;
	}

	@Override
	public boolean delete(int ma_hd) {
		// Mở giao dịch
		mSs.beginTransaction();
		try {
			HoaDon hd = mSs.get(HoaDon.class, ma_hd); // Lấy về danh mục theo ID
			mSs.delete(hd); // Cập nhật
			mSs.getTransaction().commit(); // Xác nhận sự thay đổi dữ liệu
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			mSs.close();
		}
		return false;
	}
	@Override
	public int AddHoaDon(HoaDon hoadon) {
		Session mss = null;
		mss = HibernateHelper.getSessionFactory().openSession();
		mss.beginTransaction();
		int insert2 =(Integer) mss.save(hoadon);
		mss.getTransaction().commit();
		mss.close();
		return insert2;
	}

	@Override
	public List<HoaDon> search3(String title) {
		// Mở giao dịch
		mSs.beginTransaction();
		// Sử dụng ngôn ngữ HQL để truy vấn dữ liệu
		List<HoaDon> lst = mSs.createQuery("FROM HoaDon WHERE ten LIKE :search3")
				.setParameter("search3", "%" + title + "%").list();
		mSs.close();
		return lst;
	}


	@Override
	public boolean insert(HoaDon hoadon) {
		// Mở giao dịch
		mSs.beginTransaction();
		mSs.save(hoadon); // Mã id được tự động sinh sẽ gán ngược trực tiếp vào object
		mSs.getTransaction().commit(); // Xác nhận sự thay đổi dữ liệu
		mSs.close();
		if (hoadon.getMa_hd() > 0) {
			return true;
		}
		return false;
	}
	
	


	@Override
	public void AddHoaDonDetail(HashMap<Long, CartUtil> carts) {
		long ma_hd = GetIDHoaDon();
		for(Map.Entry<Long, CartUtil> itemCart : carts.entrySet()) {
			HoaDonChiTiet hdct = new HoaDonChiTiet();
			hdct.setMa_hd(ma_hd);
			hdct.setMa_sp(itemCart.getValue().getSanpham().getMa_sp());
			hdct.setQuanty(itemCart.getValue().getQuanty());
			hdct.setTotal(itemCart.getValue().getTotalPrice());
//			AddHoaDonDetail(hdct);
//			AddHoaDonDetail(hdct);
//			hoadonctDAO.AddHoaDonDetail(hdct);
			AddHoaDonDetail.save(hdct);
			
			
		}
		
	}

	@Override
	public int GetIDHoaDon() {
		Session mss = null;
		mss = HibernateHelper.getSessionFactory().openSession();
		mss.beginTransaction();
		int id = (Integer) mss.createQuery("SELECT MAX(ma_hd) FROM HoaDon").uniqueResult();
		return id;
	}

}
