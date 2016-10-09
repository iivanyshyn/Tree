package my.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.entity.Company;
import my.repository.CompanyRepository;
import my.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	private List<Company> companies;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public void save(String name, double invest, Company parent){
		Company company = new Company();
		company.setName(name);
		company.setInvest(invest);
		company.setParent(parent);
		companyRepository.save(company);
	}
	
	public void setCompaniesNull() {
		this.companies = new ArrayList<Company>();
	}

	public Company addCompany(Company company) {
		Company saveCompany = companyRepository.save(company);
		return saveCompany;
	}

	public void delete(String id) {
		int parseId = Integer.parseInt(id);
		companyRepository.delete(parseId);
	}

	public Company getByName(String name) {
		return companyRepository.findByName(name);
	}

	public Company editCompany(Company company) {
		Company saveCompany = companyRepository.save(company);
		return saveCompany;
	}

	public Iterable<Company> getAll() {
		return companyRepository.findAll();
	}
	
	
	public Company getById(String id){
		try {
			int parseId = Integer.parseInt(id);
			return companyRepository.findOne(parseId);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	public Iterable<Company> getAllChildren(Company parent){
		return companyRepository.findAllChildren(parent);
	}
	public Iterable<Company> getAllRoot(){
		return companyRepository.findAllRoot();
	}
	private double sumAllInvest(Iterable<Company> companies, double inv){
		for (Company company : companies) {
			inv+=company.getInvest();
			if (companyRepository.findAllChildren(company) != null)
				inv=sumAllInvest(companyRepository.findAllChildren(company), inv);
		}
		return inv;
	}
	
	public List<Company> getTree(Iterable<Company> companiesIn, int level){
		level ++;
		for (Company company : companiesIn) {
			company.setLevel(level);
			company.setAllInvest(sumAllInvest(companyRepository.findAllChildren(company), company.getInvest()));
			if (company.getInvest()==company.getAllInvest())
				company.setAllInvest(0);
			companies.add(company);
			if (companyRepository.findAllChildren(company) != null){
				
				getTree(companyRepository.findAllChildren(company), level);
			}
		}
		return companies;

	}
	


}
