package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.ILoaiSanPhamDAO;
import dao.IMenusDAO;
import dao.ISanPhamDAO;
import dao.ImplCartDAO;
import dao.ImplHoaDonDAO;
import dao.ImplLoaiSanPhamDAO;
import dao.ImplMenusDAO;
import dao.ImplSanPhamDAO;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.LoaiSanPham;
import entity.Menus;
import entity.SanPham;
import entity.Users;
import utils.CartUtil;

@Controller
public class CCart {
	
	@Autowired
	private ImplCartDAO cartDAO = new ImplCartDAO();
	
	@Autowired
	private ImplHoaDonDAO hoadonDAO = new ImplHoaDonDAO();
	
	
	@RequestMapping(value="gio-hang")
	public String Homes(Model m,@RequestParam(defaultValue = "9") int limit) {
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
		
		return "user/cart/listCart";
	}
	
	@RequestMapping(value="AddCart/{ma_sp}")
	public String AddCart(HttpServletRequest request,HttpSession session, @PathVariable int ma_sp) {
		HashMap<Integer, CartUtil> cart = (HashMap<Integer, CartUtil>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Integer, CartUtil>();
		}
		cart = cartDAO.AddCart(ma_sp, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartDAO.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartDAO.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
		
	}
	@RequestMapping(value="EditCart/{ma_sp}/{quanty}")
	public String EditCart(HttpServletRequest request,HttpSession session, @PathVariable int ma_sp, @PathVariable int quanty) {
		HashMap<Integer, CartUtil> cart = (HashMap<Integer, CartUtil>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Integer, CartUtil>();
		}
		cart = cartDAO.EditCart(ma_sp,quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartDAO.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartDAO.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
		
	}
	
	@RequestMapping(value="DeleteCart/{ma_sp}")
	public String DeleteCart(HttpServletRequest request,HttpSession session, @PathVariable int ma_sp) {
		HashMap<Integer, CartUtil> cart = (HashMap<Integer, CartUtil>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Integer, CartUtil>();
		}
		cart = cartDAO.DeleteCart(ma_sp, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartDAO.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartDAO.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	@RequestMapping(value= "/thanhtoan", method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/bills/thanhtoan");
		HoaDon hoadon = new HoaDon();
		Users Infor = (Users) session.getAttribute("loginInfor");
		if(Infor != null) {
			hoadon.setAddress(Infor.getAddress());
			hoadon.setDisplay_name(Infor.getDisplay_name());
			hoadon.setTen(Infor.getTen());
		}
		mv.addObject("hoadon", hoadon);
		return mv;
	}
	@RequestMapping(value= "/thanhtoan", method = RequestMethod.POST)
	public String CheckOutHoaDon(HttpServletRequest request,HttpSession session, @ModelAttribute("hoadon") HoaDon hoadon) {
		hoadon.setQuanty((int)session.getAttribute("TotalQuantyCart"));
		hoadon.setTotal((double) session.getAttribute("TotalPriceCart"));
		if(hoadonDAO.AddHoaDon(hoadon)>0) {
			HashMap<Long, CartUtil> carts = (HashMap<Long, CartUtil>) session.getAttribute("Cart");
				hoadonDAO.AddHoaDonDetail(carts);
		}
		
		session.removeAttribute("Cart");
		return "redirect:gio-hang";
		
	}
}
