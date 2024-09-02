package com.parquesoftti.c26a.service;

import com.parquesoftti.c26a.model.Product;
import com.parquesoftti.c26a.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product productTmp = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
        productTmp.setProductName(product.getProductName());
        productTmp.setPrice(product.getPrice());
        return productRepository.save(productTmp) ;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
