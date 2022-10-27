package com.bcp.hipotecario.aprobado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcp.hipotecario.aprobado.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCreatedAt(LocalDate localDate);
}
