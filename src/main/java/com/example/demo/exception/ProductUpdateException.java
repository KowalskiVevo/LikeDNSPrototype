package com.example.demo.exception;

public class ProductUpdateException extends RuntimeException {
  public ProductUpdateException(String message){
    super("Не удалось обновить товар: " + message);
  }
}
