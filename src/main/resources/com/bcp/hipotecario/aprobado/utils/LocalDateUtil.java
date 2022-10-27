/*
 * package com.bcp.hipotecario.aprobado.utils;
 * 
 * 
 * 
 * import java.time.LocalDate; import java.time.LocalDateTime; import
 * java.time.format.DateTimeFormatter; import
 * java.time.format.DateTimeParseException; import java.util.Objects;
 * 
 * import
 * com.bcp.atlas.services.mortgageloan.mortgageloanrequests.util.ExceptionUtil;
 * 
 *//**
	 * Utility class to manage DateLocal objects <br/>
	 * <b>Class</b>: LocalDateUtil <br/>
	 *
	 * @author Banco de Cr&eacute;dito del Per&uacute; (BCP) <br/>
	 *         <u>Service Provider</u>: Globant <br/>
	 *         <u>Developed by</u>: <br/>
	 *         <ul>
	 *         <li>Robinson Escobar Osorio</li>
	 *         </ul>
	 *         <u>Changes</u>:<br/>
	 *         <ul>
	 *         <li>Jun 14, 2022 Creaci&oacute;n de Clase.</li>
	 *         </ul>
	 * @version 1.0
	 */
/*
 * public class LocalDateUtil {
 * 
 *//**
	 * For default private constructor.
	 */
/*
 * private LocalDateUtil(){ }
 * 
 *//**
	 * Method to convert a {@link String} date to a {@link LocalDateTime}. Throws a
	 * {@link com.bcp.atlas.core.exception.ApiException} if the value can not
	 * convert or the value is null.
	 *
	 * @param date a {@link String} object
	 * @return A {@link LocalDateTime} object
	 */
/*
 * public static LocalDateTime stringToDateTime(String date) { try { if
 * (Objects.isNull(date)) { throw ExceptionUtil.badRequestError(); } return
 * LocalDateTime.parse(date,
 * DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); } catch
 * (DateTimeParseException e) { throw ExceptionUtil.badRequestError(); } }
 * 
 *//**
	 * Method to convert a {@link String} date to a {@link LocalDate}. Throws a
	 * {@link com.bcp.atlas.core.exception.ApiException} if the value can not
	 * convert or the value is null.
	 *
	 * @param date a {@link String} object
	 * @return A {@link LocalDate} object
	 *//*
		 * public static LocalDate stringToDate(String date) { try { if
		 * (Objects.isNull(date)) { throw ExceptionUtil.badRequestError(); } return
		 * LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")); } catch
		 * (DateTimeParseException e) { throw ExceptionUtil.badRequestError(); } } }
		 */