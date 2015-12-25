package cz.jiripinkas.jba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.jiripinkas.jba.entity.User;
import cz.jiripinkas.jba.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("name", "saurabh");
		System.out.println("reached users");
		return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String user(Model model, @PathVariable int id) {
		User user = userService.findOne(id);
		model.addAttribute("user", user);
		return "user-detail";
	}
}
