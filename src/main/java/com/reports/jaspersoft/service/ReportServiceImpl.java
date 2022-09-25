package com.reports.jaspersoft.service;

import com.reports.jaspersoft.model.Product;
import com.reports.jaspersoft.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{

	@Autowired
    private  ProductRepository productRepository;

    private JasperPrint getJasperPrint(List<Product> phoneCollection, String resourceLocation) throws FileNotFoundException,  JRException {
        File file = ResourceUtils.getFile(resourceLocation);
        JasperReport jaspertReport = JasperCompileManager
                .compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(phoneCollection);
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Erick");
        parameters.put("DS1", dataSource);
        
        JasperPrint jasperPrint = JasperFillManager
                .fillReport(jaspertReport, parameters, new JREmptyDataSource());

        return jasperPrint;
    }

    private Path getUploadPath(String fileFormat, JasperPrint jasperPrint, String fileName) throws IOException, JRException{
        String uploadDir = StringUtils.cleanPath("./generated-reports");
        Path uploadPath = Paths.get(uploadDir);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        // Generate the report and save it in the just created folder
        if (fileFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(
                jasperPrint, uploadPath+fileName
            );
        }
        return uploadPath;
    }

    private String getPdfFileLink(String uploadPath){
        return uploadPath+"/"+"products.pdf";
    }


    @Override
    public String generateReport(LocalDate localDate, String fileFormat) throws JRException, IOException {
       List<Product> phoneCollection = productRepository.findAllByCreatedAt(localDate);
       // Load the file and compile it
       String resourceLocation = "classpath:products.jrxml";
       JasperPrint jasperPrint = getJasperPrint(phoneCollection,resourceLocation);
       //Create a folder to store the report
       String fileName = "/"+"products.pdf";
       Path uploadPath = getUploadPath(fileFormat,jasperPrint,fileName);
       // Create a private method that returns the link to the specific pdf file

       return getPdfFileLink(uploadPath.toString());


    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
