package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.IAccountDAO;
import dao.IMenusDAO;
import dao.ImplAccountDAO;
import dao.ImplMenusDAO;
import entity.Menus;
import entity.Users;

@Controller
public class CDangKy {
	
	@Autowired
	ImplAccountDAO accountDAO = new ImplAccountDAO();
	
	@Autowired
	
	private IAccountDAO account;
	
	@RequestMapping(value="/dang-ky", method = RequestMethod.GET)
	public ModelAndView DangKy() {
		ModelAndView mv = new ModelAndView("user/account/dangky");
		
		IMenusDAO dao = new ImplMenusDAO();
		List<Menus> lstmn = dao.selectAll();
		mv.addObject("lstmn", lstmn);

		mv.addObject("user", new Users());
		
		return mv;
	}
	
	@RequestMapping(value="/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateAcc(@ModelAttribute("user") Users user) {
		ModelAndView mv = new ModelAndView();
		int count = accountDAO.SaveAccount(user);
		if(count >0 ) {
			mv.addObject("msg", "Đăng ký tài khoản thành công");
		}
		else {
			mv.addObject("msgErr", "Đăng ký tài khoản thất bại");
		}
//		mv.addObject("status", true);
		mv.setViewName("user/account/dangky");
		
		return mv;
	}
	
	@RequestMapping(value="/dang-nhap", method = RequestMethod.POST)
	public String Login(@RequestParam("ten") String ten, @RequestParam("pass_word") String pass_word, Model m, HttpSession session) {
		IAccountDAO dao = new ImplAccountDAO();
		Users us = dao.AddAccount(ten, pass_word);
		if(us != null ) {
			session.setAttribute("loginInfor", us);
			return "redirect:trang-chu";
		} else {
			m.addAttribute("msgEr", "Sai tài khoản hoặc mật khẩu");
			return "user/account/dangky";
		}
		
	}
	@RequestMapping(value= "/dang-xuat", method = RequestMethod.GET)
	public String Logout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("loginInfor");
		return "redirect:"+request.getHeader("Referer");
	}
	
}
