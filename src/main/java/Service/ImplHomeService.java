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
//import dao.ImplLoaiSanPhamDAO;
//import dao.ImplSanPhamDAO;
//import entity.LoaiSanPham;
//import entity.SanPham;
//import utils.HibernateHelper;
//
//@Service
//
//public class ImplHomeService implements IHomeService {
//	
////	private Session mSs = HibernateHelper.getSessionFactory().openSession();
//	@Autowired
//	private ImplSanPhamDAO SanPhamDAO;
//	
////	@Override
////	public List<LoaiSanPham> GetLoaiSanPham() {
////		// TODO Auto-generated method stub
////		return loaiSanPhamDAO.GetLoaiSanPham();
////	}
//
//	@Override
//	public List<SanPham> selectPaginate(int start, int end) {
////		SessionFactory factory = null;
//		Session session = null;
////		Configuration configuration = new Configuration().configure();
//
////		factory = configuration.buildSessionFactory();
//		session = HibernateHelper.getSessionFactory().openSession();
//		List<SanPham> lstsp = session.createQuery("FROM SanPham").setFirstResult(start).setMaxResults(end).list();
//		session.close();
////		factory.close();
//		return lstsp;
//		}
//	
//}
