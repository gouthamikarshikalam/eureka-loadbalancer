package com.example.orderService.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.StringJoiner;

@RestController
public class OrderController {

  private final RestTemplate restTemplate;

  public OrderController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping("/order")
  public String orderOnce() {
    String res = restTemplate.getForObject("http://user-service/hello", String.class);
    return "order-service -> " + res;
  }

  @GetMapping("/order/test")
  public String orderMany(@RequestParam(defaultValue = "10") int count) {
    StringJoiner sj = new StringJoiner("\n");
    for (int i = 1; i <= count; i++) {
      String res = restTemplate.getForObject("http://user-service/hello", String.class);
      sj.add(i + ") " + res);
    }
    return sj.toString();
  }
}