package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IQuanTriDAO;
import dao.ImplQuanTriDAO;
import entity.QuanTri;

@Controller
@RequestMapping("/admin/login")
public class CQuanTri {
	
	@RequestMapping("")
	public String ShowloginForm() {
		return "admin/login";
	}
	
	@RequestMapping(value = {"","/"}, method = RequestMethod.POST)
	public String login(@RequestParam String tai_khoan, @RequestParam String mat_khau, HttpSession session, Model m) {
		IQuanTriDAO dao = new ImplQuanTriDAO();
		QuanTri qt = dao.loginQuanTri(tai_khoan, mat_khau);
		if(qt != null ) {
			session.setAttribute("login", qt);
			return "admin/quantri/index";
		}
		else {
			m.addAttribute("msg", "Sai tài khoản hoặc mật khẩu");
			return "admin/login";
		}
	}
}
