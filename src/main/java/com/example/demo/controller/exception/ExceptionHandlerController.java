package com.example.demo.controller.exception;

import com.example.demo.exception.ProductAddException;
import com.example.demo.exception.ProductDeleteException;
import com.example.demo.exception.ProductFindException;
import com.example.demo.exception.ProductUpdateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
@Slf4j
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
  @ExceptionHandler(ProductFindException.class)
  public final ResponseEntity handleProductFindFailed(ProductFindException e){
    log.error(e.getMessage());
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ProductAddException.class)
  public final ResponseEntity handleProductAddFailed(ProductAddException e){
    log.error(e.getMessage());
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ProductUpdateException.class)
  public final ResponseEntity handleProductUpdateFailed(ProductUpdateException e){
    log.error(e.getMessage());
    return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ProductDeleteException.class)
  public final ResponseEntity handleProductDeleteFailed(ProductDeleteException e){
    log.error(e.getMessage());
    return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
