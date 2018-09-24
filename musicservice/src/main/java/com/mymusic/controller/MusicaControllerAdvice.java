package com.mymusic.controller;

import static org.springframework.http.ResponseEntity.badRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = MusicaController.class)
public class MusicaControllerAdvice {

  @ExceptionHandler(Exception.class)
  public ResponseEntity handleException(Exception exception) {
    return badRequest().body(exception.getMessage());
  }
}
