package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/quantri")
public class CTrangChu {
	
	@RequestMapping("")
	public String index() {
		
		return "admin/quantri/index";
	}
}
