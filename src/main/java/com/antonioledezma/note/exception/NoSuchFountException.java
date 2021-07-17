package com.antonioledezma.note.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchFountException extends RuntimeException{
  public NoSuchFountException(Long id) {
    super("NotSouchFound: id=".concat(id.toString()));
  }
}
