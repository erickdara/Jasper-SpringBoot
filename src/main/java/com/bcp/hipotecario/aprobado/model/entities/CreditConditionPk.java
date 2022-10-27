package com.bcp.hipotecario.aprobado.model.entities;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * Class that represents the composite key for CreditConditionEntity <br/>
 * <b>Class</b>: CreditConditionPK <br/>
 *
 * @author Banco de Cr&eacute;dito del Per&uacute; (BCP) <br/>
 *     <u>Service Provider</u>: Globant <br/>
 *     <u>Developed by</u>: <br/>
 *     <ul>
 *     <li>Robinson Escobar Osorio</li>
 *     </ul>
 *     <u>Changes</u>:<br/>
 *     <ul>
 *     <li>Aug 21, 2022 Creaci&oacute;n de Clase.</li>
 *     </ul>
 * @version 1.0
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CreditConditionPk implements Serializable {
  private static final long serialVersionUID = 5215628785547679326L;
  private String activityId;
  private Integer loanApplication;
}
