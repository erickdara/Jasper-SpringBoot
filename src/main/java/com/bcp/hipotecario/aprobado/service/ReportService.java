package com.bcp.hipotecario.aprobado.service;

import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.bcp.hipotecario.aprobado.model.Product;

public interface ReportService {
    String generateReport(LocalDate localDate, String fileFormat) throws JRException,IOException;
    String generateReportAprobado(Integer loanApplicationId, String fileFormat) throws JRException,IOException;
    List<Product> findAllProducts();
 }
