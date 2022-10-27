package com.bcp.hipotecario.aprobado.service;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import com.bcp.hipotecario.aprobado.model.Product;
import com.bcp.hipotecario.aprobado.model.entities.CreditConditionEntity;
import com.bcp.hipotecario.aprobado.model.entities.CustomerEntity;
import com.bcp.hipotecario.aprobado.model.entities.ProductInformationEntity;
import com.bcp.hipotecario.aprobado.querydata.CreditConditionQueryData;
import com.bcp.hipotecario.aprobado.querydata.ProductInformationQueryData;
import com.bcp.hipotecario.aprobado.querydata.CustomerQueryData;
import com.bcp.hipotecario.aprobado.repository.ProductRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{

	@Autowired
    private  ProductRepository productRepository;
	
	@Autowired
	private CustomerQueryData reportQueryData;
	
	@Autowired
	private ProductInformationQueryData informationQueryData;
	
	@Autowired
	private CreditConditionQueryData creditConditionQueryData;

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
        
		/*
		 * Map parameters = new HashMap(); EntityManager em =
		 * Persistence.createEntityManagerFactory("Product");
		 * parameters.put(JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER, em);
		 * JasperRunManager.runReportToPdfFile("product", parameters);
		 */
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
       String resourceLocation = "classpath:productos.jrxml";
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
    
    private JasperPrint getJasperPrintBcp(CustomerEntity customer,ProductInformationEntity product , CreditConditionEntity credit,String resourceLocation) throws FileNotFoundException,  JRException {
        File file = ResourceUtils.getFile(resourceLocation);
        JasperReport jaspertReport = JasperCompileManager
                .compileReport(file.getAbsolutePath());
        //String fullName = customer.getNames().concat(customer.getFirstSurname().concat(customer.getSecondSurname()));
        //JRJpaQueryExecuterFactory
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Arrays.asList(customer));
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Erick");
        //parameters.put("DS1", dataSource);
        parameters.put("names", customer.getNames().concat(" "+customer.getFirstSurname().concat(" "+customer.getSecondSurname())));
        parameters.put("fecha", LocalDate.now().toString());
        parameters.put("producto", product.getProduct());
        parameters.put("finalidad", product.getPurposeCredit());
        parameters.put("monto", credit.getAmountRequestedCurrency().concat("/ " +credit.getAmountRequested().toString()));
        parameters.put("plazo", credit.getTermYears().toString().concat(" años"));
        parameters.put("periodo", credit.getGracePeriod().toString().concat(" meses"));
        parameters.put("cuotas", credit.getAnnualDues().toString().concat(" cuotas por año"));
       
        
        
        JasperPrint jasperPrint = JasperFillManager
                .fillReport(jaspertReport, parameters, new JREmptyDataSource());
        

        return jasperPrint;
    }

	@Override
	public String generateReportAprobado(Integer loanApplicationId, String fileFormat) throws JRException, IOException {
	
		   CustomerEntity name = reportQueryData.customerEntityById(loanApplicationId);
		   ProductInformationEntity product = informationQueryData.productoById(loanApplicationId);
		   CreditConditionEntity credit = creditConditionQueryData.creditConditionById(loanApplicationId, "EV-CRED"); 
		   
	       // Load the file and compile it
	       String resourceLocation = "classpath:constancia-aprobacion.jrxml";
	       JasperPrint jasperPrint = getJasperPrintBcp(name,product,credit,resourceLocation);
	       //Create a folder to store the report
	       String fileName = "/"+"products.pdf";
	       Path uploadPath = getUploadPath(fileFormat,jasperPrint,fileName);
	       // Create a private method that returns the link to the specific pdf file

	       return getPdfFileLink(uploadPath.toString());
	}
}
