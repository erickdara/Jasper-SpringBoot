package com.bcp.hipotecario.aprobado.querydata;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bcp.hipotecario.aprobado.model.entities.CustomerEntity;

@Repository
public interface CustomerQueryData extends CrudRepository<CustomerEntity, Integer> {
	
	@Query("SELECT c FROM CustomerEntity c JOIN FETCH c.loanApplication l WHERE l.loanApplicationId = ?1")
	CustomerEntity customerEntityById(Integer loanApplicationId);

}