package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
  @GetMapping("/")
  public String helloWorld() {
    return "Fetty Wap says: 'Hey, what's up, hello from Spring!'";
  }
}
