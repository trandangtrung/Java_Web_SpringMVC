package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.IMenusDAO;
//import Service.ImplHomeService;
//import Service.ImplSanPhamService;
import dao.IPaginatesDAO;
import dao.ISanPhamDAO;
import dao.ImplMenusDAO;
import dao.ImplPaginatesDAO;
import dao.ImplSanPhamDAO;
import entity.Menus;
import entity.SanPham;
import utils.Paginates;

@Controller
@RequestMapping()
public class Category {
	@Autowired
	private ImplSanPhamDAO SanPhamDAO;
	
	@Autowired
	ImplPaginatesDAO paginateDAO;

	private int totalSanPhamPage = 3;

	
	@RequestMapping(value ="/san-pham/{ma_lsp}")
	public ModelAndView Index(@PathVariable(name="ma_lsp") String ma_lsp) {		
		ModelAndView mv = new ModelAndView("user/products/Category");
		
		IMenusDAO dao = new ImplMenusDAO();
		List<Menus> lstmn = dao.selectAll();
		mv.addObject("lstmn", lstmn);

		ISanPhamDAO spdao = new ImplSanPhamDAO();
		List<SanPham> lsp1 = spdao.getLoaiSanPham(Integer.parseInt(ma_lsp));
		int totalData = lsp1.size();
		Paginates paginateInfo = paginateDAO.GetInfoPaginates(totalData, totalSanPhamPage, 1);
		mv.addObject("ma_lsp", ma_lsp);
		mv.addObject("paginateInfo", paginateInfo);
		mv.addObject("sanphamPaginate", SanPhamDAO.selectPaginate(Integer.parseInt(ma_lsp),paginateInfo.getStart(),totalSanPhamPage));
		mv.addObject("AllSanPham",lsp1);
		
		return mv; 
	}
	
	@RequestMapping(value ="/san-pham/{ma_lsp}/{currentPage}")
	public ModelAndView Index(@PathVariable(name="ma_lsp") String ma_lsp,@PathVariable(name="currentPage") String currentPage) {
		
		ModelAndView mv = new ModelAndView("user/products/Category");
		
		IMenusDAO dao = new ImplMenusDAO();
		List<Menus> lstmn = dao.selectAll();
		mv.addObject("lstmn", lstmn);
		
		ISanPhamDAO spdao = new ImplSanPhamDAO();
		List<SanPham> lsp1 = spdao.getLoaiSanPham(Integer.parseInt(ma_lsp));
		int totalData = lsp1.size();
		Paginates paginateInfo = paginateDAO.GetInfoPaginates(totalData, totalSanPhamPage,Integer.parseInt(currentPage));
		mv.addObject("ma_lsp", ma_lsp);
		mv.addObject("paginateInfo", paginateInfo);
		mv.addObject("sanphamPaginate", SanPhamDAO.selectPaginate(Integer.parseInt(ma_lsp),paginateInfo.getStart(), totalSanPhamPage));
		mv.addObject("AllSanPham",lsp1);
		
		return mv; 
	}
}
