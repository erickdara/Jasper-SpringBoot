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
 * Class that represents the composite key for ActivityEntity <br/>
 * <b>Class</b>: ActivityEntityPk <br/>
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
@EqualsAndHashCode
@ToString
public class ActivityEntityPk implements Serializable {

  private static final long serialVersionUID = 521562855689679326L;

  private String activityId;

  private Integer loanApplication;

}
