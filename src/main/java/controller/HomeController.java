package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ILoaiSanPhamDAO;
import dao.IMenusDAO;
import dao.ISanPhamDAO;
import dao.ImplLoaiSanPhamDAO;
import dao.ImplMenusDAO;
import dao.ImplSanPhamDAO;
import entity.LoaiSanPham;
import entity.Menus;
import entity.SanPham;

@Controller
@RequestMapping()
public class HomeController{
	
	@RequestMapping(value = {"/","/trang-chu"}, method = RequestMethod.GET)
	public String Home(Model m,@RequestParam(defaultValue = "9") int limit) {
		IMenusDAO dao = new ImplMenusDAO();
		List<Menus> lstmn = dao.selectAll();
		m.addAttribute("lstmn", lstmn);
		
		ILoaiSanPhamDAO dao1 = new ImplLoaiSanPhamDAO();
		List<LoaiSanPham> loaisp = dao1.GetLoaiSanPham();
		m.addAttribute("loaisp", loaisp);
		
		ISanPhamDAO dao2 = new ImplSanPhamDAO();
		List<SanPham> lstsp = dao2.selectAll();
		m.addAttribute("lstsp", lstsp);
		
		ISanPhamDAO dao3 = new ImplSanPhamDAO();
		List<SanPham> lstsp1 = dao3.getSanPham(limit);
		m.addAttribute("lstsp1", lstsp1);
		
//		ISanPhamDAO dao4 = new ImplSanPhamDAO();
//		List<SanPham> lst = dao4.search(search);
//		m.addAttribute("lst", lst);
//		m.addAttribute("s", search);
		
		return "user/index";
	}
	@RequestMapping(value = "/search2", method = RequestMethod.GET)
	public String TimKiem(Model m  , @RequestParam(name = "search") String search) {
		
			ISanPhamDAO dao2 = new ImplSanPhamDAO();
			List<SanPham> lstsp = dao2.search(search);
			m.addAttribute("lstsp", lstsp);
			m.addAttribute("s", search);
		return "user/products/timkiem";
	}
}
