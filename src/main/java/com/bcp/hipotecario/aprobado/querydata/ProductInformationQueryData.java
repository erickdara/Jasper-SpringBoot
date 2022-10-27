package com.bcp.hipotecario.aprobado.querydata;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bcp.hipotecario.aprobado.model.entities.ProductInformationEntity;

@Repository
public interface ProductInformationQueryData extends CrudRepository<ProductInformationEntity, Integer> {
	
	@Query("SELECT p FROM ProductInformationEntity p where p.loanApplicationId = ?1")
	ProductInformationEntity productoById(Integer loanApplicationId);
}
