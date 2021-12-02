package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Товар")
public class Product {
  @Id
  @Column(name = "ТоварID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long productId;

  @Column(name = "rf_Категория")
  private int rfCategory;

  @Column(name = "Наименование_Товара")
  private String productName;

  @Column(name = "Описание")
  private String description;

  @Column(name = "Год_Релиза")
  private int yearStart;

  @Column(name = "Производитель")
  private String maker;

  @Column(name = "Цена_Товара")
  private double price;

  @Column(name = "Скидка")
  private short reduction;
}
