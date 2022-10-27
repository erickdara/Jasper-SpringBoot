package com.bcp.hipotecario.aprobado.model.entities;

import java.time.LocalDateTime;
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
@Table(name = "Activity", schema = "coph")
@IdClass(ActivityEntityPk.class)
public class ActivityEntity {

  @Id
  @Column(name = "activity_id", nullable = false, updatable = false)
  private String activityId;

  @Id
  @MapsId("loanApplication")
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "loan_application_id", nullable = false, updatable = false)
  private LoanApplicationEntity loanApplication;

  @Column(name = "next_activity")
  private String nextActivity;

  @Column(name = "stage")
  private String stage;

  @Column(name = "status")
  private String status;

  @Column(name = "reason_rejection")
  private String reasonRejection;

  @Column(name = "comments")
  private String comments;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "role")
  private String role;

  @Column(name = "create_date")
  private LocalDateTime createDate;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

}
