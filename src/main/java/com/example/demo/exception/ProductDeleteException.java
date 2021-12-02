package com.example.demo.exception;

public class ProductDeleteException extends RuntimeException {
  public ProductDeleteException(String message){
    super("Не удалось удалить товар: " + message);
  }
}
