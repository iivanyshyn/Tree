package my.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import my.entity.Company;
import my.service.binder.CompanyEditor;
import my.service.impl.CompanyServiceImpl;

@Controller
public class IndexController {
	@Autowired
	private CompanyServiceImpl companyServiceImpl;
	
	@InitBinder
	protected void initBinderCompany(WebDataBinder binder){
		binder.registerCustomEditor(Company.class, new CompanyEditor(companyServiceImpl));
	}
	
	@RequestMapping("/")
	public String indexView(Model model) {
		model.addAttribute("companies", companyServiceImpl.getAll());
		model.addAttribute("parents", companyServiceImpl.getAll());
		model.addAttribute("company", new Company());
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String save(@ModelAttribute Company company) {
		companyServiceImpl.editCompany(company);
		return "redirect:/";
	}
	
	@RequestMapping("/{id}")
	public String delete(@PathVariable String id) {
		companyServiceImpl.delete(id);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("company", companyServiceImpl.getById(id));
		model.addAttribute("parents", companyServiceImpl.getAll());
		return "index";
	}
	
}
