package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.exception.ProductAddException;
import com.example.demo.exception.ProductFindException;
import com.example.demo.exception.ProductUpdateException;
import com.example.demo.services.AddProductService;
import com.example.demo.services.DeleteProductService;
import com.example.demo.services.FindingProductService;
import com.example.demo.services.UpdateProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Log
public class CatalogProductAssortment {

  private final FindingProductService findingProductService;
  private final AddProductService addProductService;
  private final UpdateProductService updateProductService;
  private final DeleteProductService deleteProductService;

  @GetMapping("/getProduct")
  public ResponseEntity<?> getProduct(
      @RequestParam(name = "name", required = false) String name,
      @RequestParam(name = "id", required = false) Long id
  ) {
    log.info("name = " + name + ", id = " + id);
    if (id == null) {
      List<ProductDTO> productDtoList = findingProductService.findProductList(name);
      if (productDtoList.isEmpty()) throw new ProductFindException(name);
      return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    } else {
      ProductDTO productDTO = findingProductService.findProduct(id);
      if (Objects.isNull(productDTO)) throw new ProductFindException(id.toString());
      return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
  }

  @PostMapping("/addProduct")
  public ResponseEntity<?> addProduct(
      @RequestBody Product product
  ) {
    ProductDTO productDTO = addProductService.addProduct(product);
    if (!Objects.isNull(productDTO)) {
      return new ResponseEntity<>(productDTO, HttpStatus.OK);
    } else throw new ProductAddException(productDTO.toString());
  }

  @PutMapping("/updateProduct")
  public ResponseEntity<?> updateProduct(
      @RequestBody ProductDTO productDTO
  ) {
    if (!Objects.isNull(updateProductService.updateProduct(productDTO))){
      return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }
    else {
      throw new ProductUpdateException(productDTO.toString());
    }
  }

  @DeleteMapping("/deleteProduct")
  public ResponseEntity<?> deleteProduct(
      @RequestBody ProductDTO productDTO
  ){
    if (!Objects.isNull(deleteProductService.deleteProduct(productDTO))){
      return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }
    else {
      throw new ProductUpdateException(productDTO.toString());
    }
  }
}
