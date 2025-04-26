package com.harshbisht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.harshbisht.model.UserDtls;
import com.harshbisht.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "indexPage";
	}

	@GetMapping("/register")
	public String register() {
		return "registerPage";
	}

	@GetMapping("/signin")
	public String login() {
		return "loginPage";
	}

	@PostMapping("/createUser")
	public String createUser(@ModelAttribute UserDtls user, RedirectAttributes redirectAttributes) { // will map the name given in HTML to name in UserDtls
																// (both should have the same names)
																// like email, email .... password, password
//		System.out.println(user.toString());

		boolean f = userService.checkEmail(user.getEmail());

		if (f) {
			//System.out.println("Email already exist"); 				// check for existing user
			redirectAttributes.addFlashAttribute("msg", "Email ID already exists");		// to show in the app, using th:block in html
			//session.removeAttribute("msg");		// removes the message after submit is clicked
		} else {
			UserDtls userDtls = userService.createUser(user); // calling to create user in DB
			if (userDtls != null) {
				//System.out.println("Registered Successfully");
				redirectAttributes.addFlashAttribute("msg", "Registered Successfully");
			} else {
				//System.out.println("Something wrong with server");
				redirectAttributes.addFlashAttribute("msg", "Something went wrong with the server");
			}
			//session.removeAttribute("msg");		// removes the message after submit is clicked
		}
		//session.removeAttribute("msg");

		return "redirect:/register"; // route back to register page
	}
}
