package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import entity.KhachHang;
import entity.QuanTri;
import utils.HibernateHelper;

@Repository
@Transactional
@SuppressWarnings("deprecation")
public class ImplQuanTriDAO implements IQuanTriDAO {
	
	private Session mSs;
	public ImplQuanTriDAO() {
		mSs = HibernateHelper.getSessionFactory().openSession();
	}

	@Override
	public QuanTri loginQuanTri(String tai_khoan, String mat_khau) {
		mSs.beginTransaction();
		QuanTri qt = (QuanTri) mSs.createQuery("FROM QuanTri WHERE tai_khoan= :tai_khoan and mat_khau= :mat_khau")
				.setParameter("tai_khoan", tai_khoan).setParameter("mat_khau", mat_khau).uniqueResult();
		mSs.getTransaction().commit();
		mSs.close();
		return qt;
	}

	@Override
	public List<QuanTri> selectAll() {
		mSs.beginTransaction();
		List<QuanTri> lst = mSs.createQuery("FROM QuanTri").list();
		mSs.close();
		return lst;
	}

	@Override
	public QuanTri selectById(int id) {
		mSs.beginTransaction();
		QuanTri qt = (QuanTri) mSs.createQuery("FROM QuanTri WHERE id = :id").setParameter("id", id)
				.getSingleResult();
		mSs.close();
		return qt;
	}

	@Override
	public boolean insert(QuanTri kh) {
		mSs.beginTransaction();
		mSs.save(kh); // Mã id được tự động sinh sẽ gán ngược trực tiếp vào object
		mSs.getTransaction().commit(); // Xác nhận sự thay đổi dữ liệu
		mSs.close();
		if (kh.getId() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(QuanTri qt) {
		// Mở giao dịch
				mSs.beginTransaction();
				try {
					mSs.update(qt); // Cập nhật
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
	public boolean delete(int id) {
		// Mở giao dịch
				mSs.beginTransaction();
				try {
					QuanTri qt = mSs.get(QuanTri.class, id); // Lấy về danh mục theo ID
					mSs.delete(id); // Cập nhật
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
	public List<QuanTri> search2(String title2) {
		// Mở giao dịch
				mSs.beginTransaction();
				// Sử dụng ngôn ngữ HQL để truy vấn dữ liệu
				List<QuanTri> lst = mSs.createQuery("FROM QuanTri WHERE tai_khoan LIKE :search2")
						.setParameter("search2", "%" + title2 + "%").list();
				mSs.close();
				return lst;
	}

}
