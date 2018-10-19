package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController { 
	
	
	@RequestMapping(value = "/")
	public String defaultPage() {
		return "index";
	}
	
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/hello")
	public String hello(ModelMap model) {
		model.addAttribute("message", "Hello Page !");
		return "hello";
	}
	
	@RequestMapping(value = "/error")
	public String error() {
		return "error";
	}
	
	@RequestMapping(value = "/{X}")
	public String noPage() {
		return "404";
	}
	
	
   
}