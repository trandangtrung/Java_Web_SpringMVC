package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IKhachHangDAO;
import dao.ImplKhachHangDAO;
import entity.KhachHang;



@Controller
@RequestMapping("/admin/khachhang")
public class CKhachHang {
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index(Model m) {
		List<KhachHang> lstkh = loadData();
		m.addAttribute("lstkh", lstkh);
		return "admin/khachhang/index";
	}
	@RequestMapping(value = "/search1", method =RequestMethod.GET)
	public String search(@RequestParam(name = "search1") String search1, Model m) {
		IKhachHangDAO dao = new ImplKhachHangDAO();
		List<KhachHang> lst = dao.search1(search1);
		m.addAttribute("lstkh", lst);
		m.addAttribute("search1", search1);
		return "admin/khachhang/index";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "ma_kh") int ma_kh, Model m) {
		IKhachHangDAO dao = new ImplKhachHangDAO();
		KhachHang kh = dao.selectById(ma_kh);
		m.addAttribute("kh", kh);
		return "admin/khachhang/detail";
	}
	@RequestMapping(value = "/init-update", method = RequestMethod.GET)
	public String initUpdate(@RequestParam(name = "ma_kh") int ma_kh, Model m) {
		IKhachHangDAO dao = new ImplKhachHangDAO();
		KhachHang kh = dao.selectById(ma_kh);
		m.addAttribute("kh", kh);
		return "admin/khachhang/update";
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateKhachHang(Model m, @ModelAttribute("kh") KhachHang kh) {
		IKhachHangDAO dao = new ImplKhachHangDAO();
		boolean isOk = dao.update(kh);
		if (isOk) {
			m.addAttribute("msg", "Cập nhật thành công");
		} else {
			m.addAttribute("msgErr", "Cập nhật thất bại");
		}
		m.addAttribute("kh", kh);
		return "admin/khachhang/update";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model m, @RequestParam(name = "ma_kh") int ma_kh) {
		IKhachHangDAO dao = new ImplKhachHangDAO();
		boolean isOk = dao.delete(ma_kh);
		if (isOk) {
			m.addAttribute("msg", "Xóa thành công");
		} else {
			m.addAttribute("msgErr", "Xóa thất bại");
		}
		List<KhachHang> lstkh = loadData();
		m.addAttribute("lstkh", lstkh);
		
		return "admin/khachhang/index";
	}
	
	private List<KhachHang> loadData(){
		IKhachHangDAO dao = new ImplKhachHangDAO();
		return dao.selectAll(); 
	}
}
