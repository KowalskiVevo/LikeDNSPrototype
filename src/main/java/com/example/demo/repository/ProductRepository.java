package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  Optional<List<Product>> getAllByProductName(String name);

  Optional<Product> getAllByProductId(long id);

  Optional<Product> findAllByProductName(String name);
}
