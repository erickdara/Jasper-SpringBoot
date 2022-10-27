package com.bcp.hipotecario.aprobado.model.entities;

import java.time.LocalDateTime;
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
@Table(name = "Credit_Information", schema = "coph")
public class CreditInformationEntity {
  @Id
  @Column(name = "loan_application_id")
  private Integer loanApplicationId;
  @Column(name = "credit_currency")
  private String creditCurrency;
  @Column(name = "day_payment_date")
  private Integer dayPaymentDate;
  @Column(name = "months_saving")
  private Integer monthsSaving;
  @Column(name = "initial_quota")
  private Float initialQuota;
  @Column(name = "monthly_payment")
  private Float monthlyPayment;
  @Column(name = "migration_bank_name")
  private String migrationBankName;
  @Column(name = "flag_exchange_rate")
  private String flagExchangeRate;
  @Column(name = "balance_amount")
  private Float balanceAmount;
  @Column(name = "balance_currency")
  private String balanceCurrency;
  @Column(name = "amount_financing")
  private Float amountFinancing;
  @Column(name = "number_operations")
  private Integer numberOperations;
  @Column(name = "debit_balance_usd")
  private Float debitBalanceUsd;
  @Column(name = "debit_balance_pen")
  private Float debitBalancePen;
  @Column(name = "debit_position")
  private Float debitPosition;
  @Column(name = "exchange_rate_guideline")
  private Float exchangeRateGuideline;
  @Column(name = "pre_approval_date")
  private LocalDateTime preApprovalDate;
  @Column(name = "financing_percentage")
  private Float financingPercentage;
  @Column(name = "account_selection")
  private String accountSelection;
  @Column(name = "account_type")
  private String accountType;
  @Column(name = "account_number")
  private String accountNumber;
  @Column(name = "account_number_dashes")
  private String accountNumberDashes;
  @Column(name = "co_ownership_credit")
  private String coOwnershipCredit;
  @Column(name = "shipping_method_ec")
  private String shippingMethodEc;
  @Column(name = "autonomy_approver")
  private String autonomyApprover;
  @Column(name = "area_responsible")
  private String areaResponsible;
  @Column(name = "visit_number_pyme")
  private Integer visitNumberPyme;
  @Column(name = "exchange_rate_disb")
  private Float exchangeRateDisb;
  @Column(name = "exchange_rate_conformity")
  private String exchangeRateConformity;
  @MapsId
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "loan_application_id")
  private LoanApplicationEntity loanApplication;
}