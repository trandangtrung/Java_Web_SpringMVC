//package Service;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import dao.ImplSanPhamDAO;
//import entity.SanPham;
//import utils.HibernateHelper;
//
//@Service
//public class ImplSanPhamService implements ISanPhamService {
//
////	private Session session;
////	@Autowired
////	private ImplSanPhamDAO SanPhamDAO;
////	public ImplSanPhamService() {
////		session = HibernateHelper.getSessionFactory().openSession();
////	}
//
//	@Override
//	public List<SanPham> getLoaiSanPham(int ma_lsp) {
////		SessionFactory factory = null;
//		Session session = null;
////		Configuration configuration = new Configuration().configure();
//
////		factory = configuration.buildSessionFactory();
//		session = HibernateHelper.getSessionFactory().openSession();
//		List<SanPham> lstsp1 = session.createQuery("From SanPham WHERE ma_lsp= :ma_lsp").setParameter("ma_lsp", ma_lsp)
//				.list();
//		session.close();
////		factory.close();
//		return lstsp1;
//
////		session.beginTransaction();
////	    List<SanPham> lstsp1 = session.createQuery("From SanPham WHERE ma_lsp= :ma_lsp").setParameter("ma_lsp", ma_lsp).list();
////	    session.getTransaction().commit();
////	    session.close();
////	    		
////		return lstsp1;
//
//	}
//}
