package utils;

import java.util.List;

import org.hibernate.Session;

public class Main {
	public static void main(String[] args) {
//		SessionFactory sf = new Configuration().configure().buildSessionFactory(); // Tải cấu hình file cfg
//		Session ss = sf.openSession(); // Mở phiên
//		// Mở giao dịch
//		ss.beginTransaction();
//		List<SanPham> lst = ss.createQuery("FROM SanPham").list();
//		for (SanPham sp : lst) {
//			System.out.println(sp.getMa_sp() + "." + sp.getTen_sp() + "." + sp.getLstLoaiSp());
//		}
//		ISanPhamDAO dao = new ImplSanPhamDAO();
//		List<SanPham> lst = dao.selectAll();
//		for (SanPham sp : lst) {
//			System.out.println(sp.getGia_moi() + "." + sp.getTen_sp() + "/");
//		}
		
		Session ss = HibernateHelper.getSessionFactory().openSession();
		List<Object[]> lst = ss.getNamedNativeQuery("SanPhamCT").list();
		for (Object spct [] : lst) {
			//System.out.println(spct.getTen_sp() + "." + spct.getTen_ms());
			System.out.println(spct[0].toString() + spct[1].toString());
		}
		ss.close();
	}
	
}
