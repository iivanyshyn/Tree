package my.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import my.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
	@Query("select c from Company c where c.name = :name")
	Company findByName(@Param("name") String name);
	
	@Query("select c from Company c where parent_id = :parent")
	Iterable<Company> findAllChildren(@Param("parent") Company parent);
	
	@Query("select c from Company c where parent_id = NULL")
	Iterable<Company> findAllRoot();

}
