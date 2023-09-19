package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IHoaDonDAO;
import dao.ImplHoaDonDAO;
import entity.HoaDon;

@Controller
@RequestMapping("admin/hoadon")
public class CHoaDon {
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model m) {
		List<HoaDon> lsthd = loadData();
		m.addAttribute("lsthd", lsthd);
		return "admin/hoadon/index";
	}

	@RequestMapping(value = "/search3", method = RequestMethod.GET)
	public String search(@RequestParam(name = "search3") String search3, Model m) {
		IHoaDonDAO dao = new ImplHoaDonDAO();
		List<HoaDon> lst = dao.search3(search3);
		m.addAttribute("lsthd", lst);
		m.addAttribute("s", search3);
		return "admin/hoadon/index";
	}

//	@RequestMapping(value = { "", "/"}, method = RequestMethod.GET)
//	public String initUpdate(@RequestParam(name = "ma_hd") int ma_hd, Model m) {
//		IHoaDonChiTietDAO dao = new ImplHoaDonChiTietDAO();
//		HoaDonChiTiet hdct = dao.selectById(ma_hd);
//		m.addAttribute("hdct", hdct);
//		return "hoadon/update";
//	}

//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public String updateSanPham(Model m, @ModelAttribute("sp") SanPham sp) {
//		ISanPhamDAO dao = new ImplSanPhamDAO();
//		boolean isOk = dao.update(sp);
//		if (isOk) {
//			m.addAttribute("msg", "Cập nhật thành công");
//		} else {
//			m.addAttribute("msgErr", "Cập nhật thất bại");
//		}
//		m.addAttribute("sp", sp);
//		return "hoadon/update";
//	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model m, @RequestParam(name = "ma_hd") int ma_hd) {
		IHoaDonDAO dao = new ImplHoaDonDAO();
		boolean isOk = dao.delete(ma_hd);
		if (isOk) {
			m.addAttribute("msg", "Xóa thành công");
		} else {
			m.addAttribute("msgErr", "Xóa thất bại");
		}
		List<HoaDon> lsthd = loadData();
		m.addAttribute("lsthd", lsthd);
		
		return "admin/hoadon/index";
	}

	private List<HoaDon> loadData() {
		IHoaDonDAO dao = new ImplHoaDonDAO();
		return dao.selectAll();
	}
}
