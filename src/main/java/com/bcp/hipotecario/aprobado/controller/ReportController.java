package com.bcp.hipotecario.aprobado.controller;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.hipotecario.aprobado.service.ReportService;

import java.io.IOException;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class ReportController {

	@Autowired
    private ReportService reportService;

    @GetMapping("/")
    public String showProducts(Model model){
        model.addAttribute("products", reportService.findAllProducts());
        return "products";
    }

    @PostMapping("/report")
    public String generateReport(@RequestParam("date") String date,
                                 @RequestParam("fileFormat") String fileFormat) throws JRException, IOException{
        LocalDate localDate = LocalDate.parse(date);
        String fileLink = reportService.generateReport(localDate, fileFormat);
        return "redirect:/"+fileLink;
    }
    
    @GetMapping("/reporte")
    public String generateReport(@RequestParam("loan") Integer loan, @RequestParam("fileFormat") String fileFormat) throws JRException, IOException{
        //LocalDate localDate = LocalDate.parse(date);
        String fileLink = reportService.generateReportAprobado(loan, fileFormat);
        return "redirect:/"+fileLink;
    }
}
