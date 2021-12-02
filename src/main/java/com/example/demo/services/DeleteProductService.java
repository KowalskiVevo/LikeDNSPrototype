package com.example.demo.services;

import com.example.demo.dto.ProductDTO;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DeleteProductService {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public ProductDTO deleteProduct(ProductDTO productDTO){
    try{
      productRepository.delete(productMapper.mapToEntity(productDTO));
      return productDTO;
    } catch (RuntimeException e){
      return null;
    }
  }
}
