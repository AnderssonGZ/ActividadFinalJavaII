package com.parquesoftti.c26a.service;

import com.parquesoftti.c26a.model.Order;
import com.parquesoftti.c26a.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(Long id);
    public Product save(Product order);
    public Product update(Long id, Product order);
    public void delete(Long id);
}
