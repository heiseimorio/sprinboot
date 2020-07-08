package com.example.demo.controller.ValidatingFormInput;

import javax.validation.Valid;

import com.example.demo.ValidatingFormInput.PersonForm;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class WebController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/ValidatingFormInput/results").setViewName("ValidatingFormInput/results");
	}

	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "ValidatingFormInput/form";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "ValidatingFormInput/form";
		}

		return "redirect:/ValidatingFormInput/results";
	}
}