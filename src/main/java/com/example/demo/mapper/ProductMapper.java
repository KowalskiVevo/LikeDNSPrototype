package com.example.demo.mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
  public ProductDTO mapToDto(Product product) {
    return ProductDTO.builder()
        .description(product.getDescription())
        .productName(product.getProductName())
        .productId(product.getProductId())
        .maker(product.getMaker())
        .rfCategory(product.getRfCategory())
        .price(product.getPrice())
        .reduction(product.getReduction())
        .yearStart(product.getYearStart())
        .build();
  }

  public Product mapToEntity(ProductDTO productDto) {
    Product product = new Product();
    product.setProductId(productDto.getProductId());
    product.setProductName(productDto.getProductName());
    product.setPrice(productDto.getPrice());
    product.setDescription(productDto.getDescription());
    product.setReduction(productDto.getReduction());
    product.setMaker(productDto.getMaker());
    product.setYearStart(productDto.getYearStart());
    product.setRfCategory(productDto.getRfCategory());
    return product;
  }
}
