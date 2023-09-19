package dao;

import java.util.List;

import org.hibernate.Session;

import entity.KhachHang;
import utils.HibernateHelper;

public class ImplKhachHangDAO implements IKhachHangDAO {

	private Session mSs;

	public ImplKhachHangDAO() {
		mSs = HibernateHelper.getSessionFactory().openSession();
	}

	@Override
	public List<KhachHang> selectAll() {
		mSs.beginTransaction();
		List<KhachHang> lst = mSs.createQuery("FROM KhachHang").list();
		mSs.close();
		return lst;
	}

	@Override
	public KhachHang selectById(int ma_kh) {
		mSs.beginTransaction();
		KhachHang kh = (KhachHang) mSs.createQuery("FROM KhachHang WHERE id = :makh").setParameter("makh", ma_kh)
				.getSingleResult();
		mSs.close();
		return kh;
	}

	@Override
	public boolean insert(KhachHang kh) {
		// Mở giao dịch
		mSs.beginTransaction();
		mSs.save(kh); // Mã id được tự động sinh sẽ gán ngược trực tiếp vào object
		mSs.getTransaction().commit(); // Xác nhận sự thay đổi dữ liệu
		mSs.close();
		if (kh.getMa_kh() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(KhachHang kh) {
		// Mở giao dịch
		mSs.beginTransaction();
		try {
			mSs.update(kh); // Cập nhật
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
	public boolean delete(int ma_kh) {
		// Mở giao dịch
		mSs.beginTransaction();
		try {
			KhachHang kh = mSs.get(KhachHang.class, ma_kh); // Lấy về danh mục theo ID
			mSs.delete(kh); // Cập nhật
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
	public List<KhachHang> search1(String title1) {
		// Mở giao dịch
		mSs.beginTransaction();
		// Sử dụng ngôn ngữ HQL để truy vấn dữ liệu
		List<KhachHang> lst = mSs.createQuery("FROM KhachHang WHERE ho_ten LIKE :search1")
				.setParameter("search1", "%" + title1 + "%").list();
		mSs.close();
		return lst;
	}

}
