package com.parquesoftti.c26a.repository;

import com.parquesoftti.c26a.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
