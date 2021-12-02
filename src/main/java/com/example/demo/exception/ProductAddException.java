package com.example.demo.exception;

public class ProductAddException extends RuntimeException {
  public ProductAddException(String message){
    super("Не удалось добавить товар: " + message);
  }
}
