package com.example.demo.util;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.User;

import java.util.Optional;

public class Test {
  public static void main(String[] args) throws NotFoundException {
    User user=null;
    Optional.ofNullable(user).orElseThrow(()->new NotFoundException(""));
  }



}
