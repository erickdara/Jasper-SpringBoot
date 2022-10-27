package com.bcp.hipotecario.aprobado.model.entities;

//package com.bcp.atlas.services.mortgageloan.mortgageloanrequests.model.entities;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class that represents the Loan_Application table <br/>
 * <b>Class</b>: LoanApplicationEntity <br/>
 *
 * @author Banco de Cr&eacute;dito del Per&uacute; (BCP) <br/>
 *         <u>Service Provider</u>: Globant <br/>
 *         <u>Developed by</u>: <br/>
 *         <ul>
 *         <li>Robinson Escobar Osorio</li>
 *         </ul>
 *         <u>Changes</u>:<br/>
 *         <ul>
 *         <li>Aug 14, 2022 Creaci&oacute;n de Clase.</li>
 *         </ul>
 * @version 1.0
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Loan_Application", schema = "coph")
public class LoanApplicationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loan_application_id", unique = true, nullable = false, updatable = false)
	private Integer loanApplicationId;

	@Column(name = "seller_user")
	private String sellerUser;

	@Column(name = "referrer_user")
	private String referrerUser;

	@Column(name = "agency_code")
	private String agencyCode;

	@Column(name = "branch_code")
	private String branchCode;

	@Column(name = "notary_id")
	private Integer notaryId;
	
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@Column(name = "final_date")
	private LocalDateTime finalDate;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "loanApplication")
	@PrimaryKeyJoinColumn
	private ProductInformationEntity productInformationEntity;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "loanApplication")
	@PrimaryKeyJoinColumn
	private CreditInformationEntity creditInformation;

}