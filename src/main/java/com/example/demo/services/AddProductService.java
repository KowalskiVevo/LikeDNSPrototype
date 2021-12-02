package com.example.demo.services;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AddProductService {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public ProductDTO addProduct(Product product) {
    try{
      productRepository.save(product);
      return productMapper.mapToDto(product);
    }catch (RuntimeException e){
      return null;
    }
  }
}
