package com.bcp.hipotecario.aprobado.model.entities;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * <br/> Clase service que contiene los metodos necesarios para tramitar la data
 * y logica de negocio que consumira la clase REST MortgageLoanRequestsController<br/>
 * <b>Class</b>: CustomerEntity<br/>
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
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Customer", schema = "coph")
public class CustomerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private Integer customerId;
  
  @Column(name = "customer_cic")
  private String customerCic;
  
  @Column(name = "customer_idc")
  private String customerIdc;
  
  @Column(name = "document_type")
  private Integer documentType;
  
  @Column(name = "document_number")
  private String documentNumber;
  
  @Column(name = "customer_type")
  private String customerType;
  
  @Column(name = "names")
  private String names;
  
  @Column(name = "first_surname")
  private String firstSurname;
  
  @Column(name = "second_surname")
  private String secondSurname;
  
  @Column(name = "date_birth")
  private LocalDate dateBirth;
  
  @Column(name = "gender")
  private String gender;
  
  @Column(name = "civil_status")
  private String civilStatus;
  
  @Column(name = "age_years")
  private Integer ageYears;
  
  @Column(name = "nationality")
  private String nationality;
  
  @Column(name = "telephone")
  private String telephone;
  
  @Column(name = "mobile")
  private String mobile;
  
  @Column(name = "email")
  private String email;
  
  @Column(name = "education_level")
  private String educationLevel;
  
  @Column(name = "profession")
  private String profession;
  
  @Column(name = "employment_situation")
  private String employmentSituation;
  
  @Column(name = "occupation")
  private String occupation;
  
  @Column(name = "segment")
  private String segment;
  
  @Column(name = "customer_pyme")
  private String customerPyme;
  
  @Column(name = "debtor")
  private String debtor;
  
  @Column(name = "total_gross_monthly_income")
  private Float totalGrossMonthlyIncome;
  
  @Column(name = "total_gross_monthly_income_currency")
  private String totalGrossMonthlyIncomeCurrency;
  
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "loan_Application_Id",  nullable = false, updatable = false)
  private LoanApplicationEntity loanApplication;

}
