package my.service;

import my.entity.Company;

public interface CompanyService {
	
	Company addCompany(Company company);
	void delete(String id);
	Company getByName(String name);
	Company editCompany(Company company);
	Iterable<Company> getAll();

}
