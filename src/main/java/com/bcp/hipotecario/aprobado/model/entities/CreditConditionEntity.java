package com.bcp.hipotecario.aprobado.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Entity class that represents the Activity table <br/>
 * <b>Class</b>: ActivityEntity <br/>
 *
 * @author Banco de Cr&eacute;dito del Per&uacute; (BCP) <br/>
 *     <u>Service Provider</u>: Globant <br/>
 *     <u>Developed by</u>: <br/>
 *     <ul>
 *     <li>Robinson Escobar Osorio</li>
 *     </ul>
 *     <u>Changes</u>:<br/>
 *     <ul>
 *     <li>Aug 14, 2022 Creaci&oacute;n de Clase.</li>
 *     </ul>
 * @version 1.0
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Credit_Condition", schema = "coph")
@IdClass(CreditConditionPk.class)
public class CreditConditionEntity {
  @Id
  @Column(name = "activity_id", nullable = false, updatable = false)
  private String activityId;
  @Id
  @MapsId("loanApplication")
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "loan_application_id", nullable = false, updatable = false)
  private LoanApplicationEntity loanApplication;
  @Column(name = "term_years")
  private Integer termYears;
  @Column(name = "annual_dues")
  private Integer annualDues;
  @Column(name = "grace_period")
  private Integer gracePeriod;
  @Column(name = "amount_requested_currency")
  private String amountRequestedCurrency;
  @Column(name = "amount_requested")
  private Float amountRequested;
  @Column(name = "cem_type")
  private String cemType;
  @Column(name = "cem")
  private Float cem;
  @Column(name = "ltv_approved")
  private Float ltvApproved;
}