package com.example.springboot.product.services;

import com.example.springboot.product.dtos.ProductRecordDto;
import com.example.springboot.product.models.ProductModel;
import com.example.springboot.product.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductModel saveProduct(ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return productRepository.save(productModel);
    }

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductModel> getOneProduct(UUID id) {
        return productRepository.findById(id);
    }

    public ProductModel updateProduct(ProductModel productModel, ProductRecordDto productRecordDto) {
        BeanUtils.copyProperties(productRecordDto, productModel);
        return productRepository.save(productModel);
    }

    public void deleteProduct(ProductModel productModel) {
        productRepository.delete(productModel);
    }
}
