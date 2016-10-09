package my.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import my.service.impl.CompanyServiceImpl;

@Controller
public class CompanyController {
	@Autowired
	private CompanyServiceImpl companyServiceImpl;
	
	@RequestMapping("/company")
	public String companyView(Model model) {
		companyServiceImpl.setCompaniesNull();
		model.addAttribute("companies", companyServiceImpl.getTree(companyServiceImpl.getAllRoot(),-1));
		return "company";
	}
	
	

}
