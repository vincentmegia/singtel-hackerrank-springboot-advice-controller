package com.hackerrank.restcontrolleradvice.controller;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzResponse;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import com.hackerrank.restcontrolleradvice.enums.FizzBuzzEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

  @RequestMapping(value = "/controller_advice/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FizzBuzzResponse> getFizzBuzzResponse(@PathVariable("code") String code)
          throws FizzException, BuzzException, FizzBuzzException {
    if (FizzBuzzEnum.FIZZ.getValue().equals(code)) {
      throw new FizzException("Fizz Exception has been thrown", "Internal Server Error");
    } else if (FizzBuzzEnum.BUZZ.getValue().equals(code)) {
      throw new BuzzException("Buzz Exception has been thrown", "Bad Request");
    } else if (FizzBuzzEnum.FIZZBUZZ.getValue().equals(code)) {
      throw new FizzBuzzException("FizzBuzz Exception has been thrown", "Insufficient Storage");
    }
    return new ResponseEntity(new FizzBuzzResponse("Successfully completed fizzbuzz test", 200), HttpStatus.OK);
  }
}
