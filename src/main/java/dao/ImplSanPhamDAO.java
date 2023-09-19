package dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import entity.SanPham;
import utils.HibernateHelper;

@Service
public class ImplSanPhamDAO implements ISanPhamDAO {

	private Session mSs;

	public ImplSanPhamDAO() {
		mSs = HibernateHelper.getSessionFactory().openSession();
	}

	@Override
	public List<SanPham> selectAll() {
		mSs.beginTransaction();
		List<SanPham> lst = mSs.createQuery("FROM SanPham").list();
		mSs.close();
		return lst;
	}

	@Override
	public boolean update(SanPham sp) {
		// Mở giao dịch
		mSs.beginTransaction();
		try {
			mSs.update(sp); // Cập nhật
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
	public boolean delete(int ma_sp) {
		// Mở giao dịch
		mSs.beginTransaction();
		try {
			SanPham sp = mSs.get(SanPham.class, ma_sp); // Lấy về danh mục theo ID
			mSs.delete(sp); // Cập nhật
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
	public boolean insert(SanPham sp) {
		// Mở giao dịch
		mSs.beginTransaction();
		mSs.save(sp); // Mã id được tự động sinh sẽ gán ngược trực tiếp vào object
		mSs.getTransaction().commit(); // Xác nhận sự thay đổi dữ liệu
		mSs.close();
		if (sp.getMa_sp() > 0) {
			return true;
		}

		return false;
	}

	@Override
	public List<SanPham> search(String title) {
		// Mở giao dịch
		mSs.beginTransaction();
		// Sử dụng ngôn ngữ HQL để truy vấn dữ liệu
		List<SanPham> lst = mSs.createQuery("FROM SanPham WHERE ten_sp LIKE :search")
				.setParameter("search", "%" + title + "%").list();
		mSs.close();
		return lst;
	}

	@Override
	public SanPham selectById(int ma_sp) {
		// Mở giao dịch
		Session session = null;
		session = HibernateHelper.getSessionFactory().openSession();
		SanPham sp = (SanPham) mSs.createQuery("FROM SanPham WHERE id = :masp").setParameter("masp", ma_sp)
				.getSingleResult();

		session.close();
		return sp;
	}

	@Override
	public List<SanPham> selectPaginate(int ma_lsp, int start, int totalPage) {

		Session session = null;
		session = HibernateHelper.getSessionFactory().openSession();
		List<SanPham> lstsp = session.createQuery("FROM SanPham WHERE ma_lsp= :ma_lsp").setParameter("ma_lsp", ma_lsp).setFirstResult(start).setMaxResults(totalPage).list();
		session.close();

		return lstsp;
	}

	@Override
	public List<SanPham> getSanPham(int limit) {
		mSs.beginTransaction();
		List<SanPham> lstlm = mSs.createQuery("From SanPham").setMaxResults(limit).list();

		mSs.close();
		return lstlm;
	}

	 @Override
	 public List<SanPham> getLoaiSanPham(int ma_lsp) {
	Session session = null;

	session=HibernateHelper.getSessionFactory().openSession();
	List<SanPham> lstsp1 = session.createQuery("From SanPham WHERE ma_lsp= :ma_lsp").setParameter("ma_lsp", ma_lsp)
			.list();
	session.close();
//	factory.close();
	return lstsp1;
	 }

	@Override
	public List<SanPham> selectPaginate1(int start, int totalPage) {
		Session session = null;
		session = HibernateHelper.getSessionFactory().openSession();
		List<SanPham> lstsp1 = session.createQuery("FROM SanPham").setFirstResult(start).setMaxResults(totalPage).list();
		session.close();

		return lstsp1;
	}


}
