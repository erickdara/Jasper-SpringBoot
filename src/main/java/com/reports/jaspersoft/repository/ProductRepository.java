package com.reports.jaspersoft.repository;

import com.reports.jaspersoft.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCreatedAt(LocalDate localDate);
}
