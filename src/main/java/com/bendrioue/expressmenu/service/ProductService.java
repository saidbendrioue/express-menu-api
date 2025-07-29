package com.bendrioue.expressmenu.service;

import com.bendrioue.expressmenu.dto.ProductDto;
import com.bendrioue.expressmenu.exception.ProductNotFoundException;
import com.bendrioue.expressmenu.mapper.AppMapper;
import com.bendrioue.expressmenu.model.Product;
import com.bendrioue.expressmenu.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final AppMapper appMapper;

    public ProductService(ProductRepository productRepository, AppMapper appMapper) {
        this.productRepository = productRepository;
        this.appMapper = appMapper;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(appMapper::productToProductDto)
                .toList();
    }

    public ProductDto getProductById(UUID id) {
        return productRepository.findById(id)
                .map(appMapper::productToProductDto)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public ProductDto createProduct(ProductDto productDto) {
        return appMapper.productToProductDto(productRepository.save(appMapper.productDtoToProduct(productDto)));
    }

    public ProductDto updateProduct(UUID id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setAvailable(productDto.isAvailable());
        product.setImageUrl(productDto.getImageUrl());
        return appMapper.productToProductDto(productRepository.save(product));
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
