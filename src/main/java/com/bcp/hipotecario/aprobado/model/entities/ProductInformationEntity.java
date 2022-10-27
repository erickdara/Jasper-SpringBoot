package com.bcp.hipotecario.aprobado.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * <br/> Clase service que contiene los metodos necesarios para tramitar la data
 * y logica de negocio que consumira la clase REST MortgageLoanRequestsController<br/>
 * <b>Class</b>: ProductInformationEntity<br/>
 * Copyright: &copy; 2022 Banco de Cr&eacute;dito del Per&uacute;.<br/>
 * Company: Banco de Cr&eacute;dito del Per&uacute;.<br/>
 *
 * @author Banco de Cr&eacute;dito del Per&uacute; (BCP) <br/>
 * <u>Service Provider</u>: Globant <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Erickson Marcos</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Jun 17, 2022 Creaci&oacute;n de Clase.</li>
 * </ul>
 * @version 1.0
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product_Information", schema = "coph")
public class ProductInformationEntity {
  @Id
  @Column(name = "loan_application_id")
  private Integer loanApplicationId;
  @Column(name = "credit_type")
  private String creditType;
  @Column(name = "product")
  private String product;
  @Column(name = "subproduct")
  private String subproduct;
  @Column(name = "purpose_credit")
  private String purposeCredit;
  @Column(name = "detail_purpose_credit")
  private String detailPurposeCredit;
  @Column(name = "second_mortgage")
  private String secondMortgage;
  @Column(name = "first_home")
  private String firstHome;
  @MapsId
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "loan_application_id")
  private LoanApplicationEntity loanApplication;
}