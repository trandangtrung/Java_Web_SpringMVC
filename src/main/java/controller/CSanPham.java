package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.IMenusDAO;
import dao.ISanPhamDAO;
import dao.ImplMenusDAO;
import dao.ImplPaginatesDAO;
import dao.ImplSanPhamDAO;
import entity.Menus;
import entity.SanPham;
import utils.Paginates;

@Controller
@RequestMapping("admin/sanpham")
public class CSanPham {
	@Autowired
	private ImplSanPhamDAO SanPhamDAO;
	
	@Autowired
	ImplPaginatesDAO paginateDAO;

	private int totalSanPhamPage = 6;

	
	@RequestMapping(value ="", method = RequestMethod.GET)
	public ModelAndView Index() {		
		ModelAndView mv = new ModelAndView("admin/sanpham/index");
		
		List<SanPham> lstsp1 = loadData();
		mv.addObject("lstsp", lstsp1);

		int totalData1 = lstsp1.size();
		Paginates paginateInfo1 = paginateDAO.GetInfoPaginates(totalData1, totalSanPhamPage, 1);
		mv.addObject("paginateInfo1", paginateInfo1);
		mv.addObject("lstsp", SanPhamDAO.selectPaginate1(paginateInfo1.getStart(),totalSanPhamPage));
		mv.addObject("AllSanPham",lstsp1);
		
		return mv; 
	}
	
	@RequestMapping(value ="/{currentPage}")
	public ModelAndView Index(@PathVariable(name="currentPage") String currentPage) {
		
		ModelAndView mv = new ModelAndView("admin/sanpham/index");
		
		List<SanPham> lstsp1 = loadData();
		mv.addObject("lstsp", lstsp1);

		int totalData1 = lstsp1.size();
		Paginates paginateInfo1 = paginateDAO.GetInfoPaginates(totalData1, totalSanPhamPage,Integer.parseInt(currentPage));
		mv.addObject("paginateInfo1", paginateInfo1);
		mv.addObject("lstsp", SanPhamDAO.selectPaginate1(paginateInfo1.getStart(), totalSanPhamPage));
		mv.addObject("AllSanPham",lstsp1);
		
		return mv; 
	}
	
//	@RequestMapping(value ="", method = RequestMethod.GET)
//	public String index(Model m) {
//		List<SanPham> lstsp = loadData();
//		m.addAttribute("lstsp", lstsp);
//		return "admin/sanpham/index";
//	}
	@RequestMapping(value = "/initInsert", method = RequestMethod.GET)
	public String initInsert(Model m) {
		SanPham sp = new SanPham();
		m.addAttribute("sp", sp);
		return "admin/sanpham/insert";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(Model m, @ModelAttribute("sp") SanPham sp) {
		ISanPhamDAO dao = new ImplSanPhamDAO();
		boolean isOk = dao.insert(sp);
		if (isOk) {
			m.addAttribute("msg", "Thêm mới thành công");
		} else {
			m.addAttribute("msgErr", "Thêm mới thất bại");
		}
		m.addAttribute("sp", sp);
		
		return "admin/sanpham/insert";
	}
	
	@RequestMapping(value = "/search", method =RequestMethod.GET)
	public String search(@RequestParam(name = "search") String search, Model m) {
		ISanPhamDAO dao = new ImplSanPhamDAO();
		List<SanPham> lst = dao.search(search);
		m.addAttribute("lstsp", lst);
		m.addAttribute("s", search);
		return "admin/sanpham/index";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "ma_sp") int ma_sp, Model m) {
		ISanPhamDAO dao = new ImplSanPhamDAO();
		SanPham sp = dao.selectById(ma_sp);
		m.addAttribute("sp", sp);
		return "admin/sanpham/detail";
	}
	
	@RequestMapping(value = "/init-update", method = RequestMethod.GET)
	public String initUpdate(@RequestParam(name = "ma_sp") int ma_sp, Model m) {
		ISanPhamDAO dao = new ImplSanPhamDAO();
		SanPham sp = dao.selectById(ma_sp);
		m.addAttribute("sp", sp);
		return "admin/sanpham/update";
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateSanPham(Model m, @ModelAttribute("sp") SanPham sp) {
		ISanPhamDAO dao = new ImplSanPhamDAO();
		boolean isOk = dao.update(sp);
		if (isOk) {
			m.addAttribute("msg", "Cập nhật thành công");
		} else {
			m.addAttribute("msgErr", "Cập nhật thất bại");
		}
		m.addAttribute("sp", sp);
		return "admin/sanpham/update";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model m, @RequestParam(name = "ma_sp") int ma_sp) {
		ISanPhamDAO dao = new ImplSanPhamDAO();
		boolean isOk = dao.delete(ma_sp);
		if (isOk) {
			m.addAttribute("msg", "Xóa thành công");
		} else {
			m.addAttribute("msgErr", "Xóa thất bại");
		}
		List<SanPham> lstsp = loadData();
		m.addAttribute("lstsp", lstsp);
		
		return "admin/sanpham/index";
	}
	
	
	
	private List<SanPham> loadData(){
		ISanPhamDAO dao = new ImplSanPhamDAO();
		return dao.selectAll(); 
	}
}
