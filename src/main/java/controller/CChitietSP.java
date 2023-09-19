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
public class CChitietSP {
	@RequestMapping(value = {"/chi-tiet-san-pham/{ma_sp}"}, method = RequestMethod.GET)
	public String ChiTiet(Model m, @PathVariable(name="ma_sp") int ma_sp ) {
		IMenusDAO dao = new ImplMenusDAO();
		List<Menus> lstmn = dao.selectAll();
		m.addAttribute("lstmn", lstmn);
		
		ISanPhamDAO spd = new ImplSanPhamDAO();
		SanPham lstdao = spd.selectById(ma_sp);
		m.addAttribute("lstdao", lstdao);
		
		ISanPhamDAO spd1 = new ImplSanPhamDAO();
		int idLoaiSanPham = spd.selectById(ma_sp).getMa_lsp();
		List<SanPham> lstdao1 = spd1.getLoaiSanPham(idLoaiSanPham);
		m.addAttribute("lstdao1", lstdao1);
		
		
		return "user/products/sanphamct";
	}

}
