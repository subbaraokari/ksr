package com.cts.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.model.CustomerDetails;
import com.cts.model.RechargePackage;
import com.cts.service.RechargeService;

@Controller
public class RechargeController {
	@Autowired
	private RechargeService rechargeService;
	// add an initbinder ... to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor rechargeDateEditor = new CustomDateEditor(dateFormat, true);
		dataBinder.registerCustomEditor(Date.class, rechargeDateEditor);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/")
	public ModelAndView show() {
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setPreviousRechargeDate(new Date());
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("customerDetails", customerDetails);
		return modelAndView;
	}

	@RequestMapping("/check")
	public String checkStatus(@Valid @ModelAttribute("customerDetails") CustomerDetails customerDetails,
			BindingResult result, Model model) {
		String viewName = null;
		System.out.println(customerDetails.getPreviousRechargeDate());
		String packageName = customerDetails.getPreviousSelectedPackage();
		Date previousRechargeDt = customerDetails.getPreviousRechargeDate();
		boolean active = rechargeService.checkStatus(customerDetails);
		System.out.println(active);
		if (result.hasErrors()) {
			viewName = "index";
		} else {
			if (previousRechargeDt.compareTo(new Date()) > 0) {
				System.out.println("hello");
				viewName = "error";
			} else if (active) {
				model.addAttribute("msg", "Your mobile validity is not expired");
				viewName = "index";
			} else {
				List<RechargePackage> rechargePackages = rechargeService.getAllPackagesByPlanName(packageName);
				model.addAttribute("packages", rechargePackages);
				viewName = "list";
			}
		}
		return viewName;
	}

	@RequestMapping("/detail/{pid}")
	public String showDetailPage(@PathVariable("pid") int pid, Model model) {
		System.out.println("hello");
		RechargePackage pack = rechargeService.getPackage(pid);
		model.addAttribute("pack", pack);
		System.out.println("hi");
		return "details";
	}
}
