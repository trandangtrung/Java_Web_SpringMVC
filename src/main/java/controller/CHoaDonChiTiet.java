package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IHoaDonChiTietDAO;
import dao.ImplHoaDonChiTietDAO;
import entity.HoaDonChiTiet;

@Controller
@RequestMapping("/admin/hoadon/hoadonchitiet")
public class CHoaDonChiTiet {
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String initUpdate( Model m) {
		IHoaDonChiTietDAO dao = new ImplHoaDonChiTietDAO();
		List<HoaDonChiTiet> lst = dao.selectAll();
		m.addAttribute("hdct", lst);
		
//		IHoaDonChiTietDAO dao = new ImplHoaDonChiTietDAO();
//		HoaDonChiTiet hdct = dao.selectById(ma_hd);
//		m.addAttribute("hdct", hdct);
		return "admin/hoadon/hoadonchitiet/update";
	}
}
