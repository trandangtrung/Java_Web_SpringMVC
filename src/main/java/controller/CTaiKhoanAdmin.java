package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IKhachHangDAO;
import dao.IQuanTriDAO;
import dao.ISanPhamDAO;
import dao.ImplKhachHangDAO;
import dao.ImplQuanTriDAO;
import dao.ImplSanPhamDAO;
import entity.KhachHang;
import entity.QuanTri;
import entity.SanPham;

@Controller
@RequestMapping("/admin/taikhoan")
public class CTaiKhoanAdmin {

	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index(Model m) {
		List<QuanTri> lstqt = loadData();
		m.addAttribute("lstqt", lstqt);
		return "admin/taikhoanadmin/index";
	}
	@RequestMapping(value = "/search2", method =RequestMethod.GET)
	public String search(@RequestParam(name = "search2") String search2, Model m) {
		IQuanTriDAO dao = new ImplQuanTriDAO();
		List<QuanTri> lst = dao.search2(search2);
		m.addAttribute("lstqt", lst);
		m.addAttribute("search1", search2);
		return "admin/taikhoanadmin/index";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "id") int id, Model m) {
		IQuanTriDAO dao = new ImplQuanTriDAO();
		QuanTri qt = dao.selectById(id);
		m.addAttribute("qt", qt);
		return "admin/taikhoanadmin/detail";
	}
	@RequestMapping(value = "/init-update", method = RequestMethod.GET)
	public String initUpdate(@RequestParam(name = "id") int id, Model m) {
		IQuanTriDAO dao = new ImplQuanTriDAO();
		QuanTri qt = dao.selectById(id);
		m.addAttribute("qt", qt);
		return "admin/taikhoanadmin/update";
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateKhachHang(Model m, @ModelAttribute("qt") QuanTri qt) {
		IQuanTriDAO dao = new ImplQuanTriDAO();
		boolean isOk = dao.update(qt);
		if (isOk) {
			m.addAttribute("msg", "Cập nhật thành công");
		} else {
			m.addAttribute("msgErr", "Cập nhật thất bại");
		}
		m.addAttribute("qt", qt);
		return "admin/taikhoanadmin/update";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model m, @RequestParam(name = "id") int id) {
		IQuanTriDAO dao = new ImplQuanTriDAO();
		boolean isOk = dao.delete(id);
		if (isOk) {
			m.addAttribute("msg", "Xóa thành công");
		} else {
			m.addAttribute("msgErr", "Xóa thất bại");
		}
		List<QuanTri> lstqt = loadData();
		m.addAttribute("lstqt", lstqt);
		
		return "admin/taikhoanadmin/index";
	}
	
	private List<QuanTri> loadData(){
		IQuanTriDAO dao = new ImplQuanTriDAO();
		return dao.selectAll(); 
	}
}

	