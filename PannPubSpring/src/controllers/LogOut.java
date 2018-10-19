package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogOut {
	
	
	@RequestMapping(value = "/logOut") 
	public String logOut(HttpServletRequest request, ModelMap model) { 
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:index";
	} 
}
