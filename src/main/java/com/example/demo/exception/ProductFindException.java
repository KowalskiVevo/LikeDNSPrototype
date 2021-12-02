package com.example.demo.exception;

public class ProductFindException extends RuntimeException {
  public ProductFindException(String message){
    super("Не удалось найти товар с параметром " + message);
  }
}
