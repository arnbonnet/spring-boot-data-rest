package fr.dta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.dta.model.Customer;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customers")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("select c from Customer c where c.email like %?1")
	List<Customer> findByEmailSuffix(@Param("suffix") String suffix);
	
	List<Customer> findByEmail(@Param("email") String email);
	
	List<Customer> findByLastname(@Param("lastname") String lastname);

	List<Customer> findByFirstnameAndLastname(@Param("firstname") String firstname, @Param("lastname") String lastname);
	
	

}
