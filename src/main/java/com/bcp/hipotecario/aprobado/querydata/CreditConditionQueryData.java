package com.bcp.hipotecario.aprobado.querydata;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bcp.hipotecario.aprobado.model.entities.CreditConditionEntity;
import com.bcp.hipotecario.aprobado.model.entities.CreditConditionPk;

@Repository
public interface CreditConditionQueryData extends CrudRepository<CreditConditionEntity, CreditConditionPk> {
	
	@Query("SELECT c FROM CreditConditionEntity c JOIN FETCH c.loanApplication l WHERE l.loanApplicationId = ?1 AND c.activityId = ?2")
	CreditConditionEntity creditConditionById(Integer loanApplicationId, String activityId);

}
