package my.service.binder;

import java.beans.PropertyEditorSupport;

import my.service.impl.CompanyServiceImpl;

public class CompanyEditor extends PropertyEditorSupport{
	
	private final CompanyServiceImpl companyServiceImpl;

	public CompanyEditor(CompanyServiceImpl companyServiceImpl) {
		this.companyServiceImpl = companyServiceImpl;
	}
	
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(companyServiceImpl.getById(text));
	}

}
