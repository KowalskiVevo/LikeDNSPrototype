package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@Builder
public class ProductDTO {
  @Nullable
  private Long productId;

  private int rfCategory;

  private String productName;

  private String description;

  private int yearStart;

  private String maker;

  private double price;

  private short reduction;
}
