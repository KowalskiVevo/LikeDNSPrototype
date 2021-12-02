package com.example.demo.services;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.exception.ProductFindException;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class FindingProductService {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public List<ProductDTO> findProductList(String name) {
    try {
      Optional<List<Product>> optionalProductList = productRepository.getAllByProductName(name);
      if (optionalProductList.isEmpty()) {
        return null;
      } else {
        List<Product> products = optionalProductList.get();
        List<ProductDTO> productDTO = products.stream().map(product -> productMapper.mapToDto(product)).collect(Collectors.toList());
        return productDTO;
      }
    } catch (Exception e){
      throw new ProductFindException("name = " + name);
    }
  }

  public ProductDTO findProduct(long id) {
    try {
      Optional<Product> optionalProduct = productRepository.getAllByProductId(id);
      if (optionalProduct.isEmpty()) {
        return null;
      } else {
        Product product = optionalProduct.get();
        ProductDTO productDTO = productMapper.mapToDto(product);
        return productDTO;
      }
    } catch (Exception e){
      throw new ProductFindException("id = " + id);
    }
  }
}
