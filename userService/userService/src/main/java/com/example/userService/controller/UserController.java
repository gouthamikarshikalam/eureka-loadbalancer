package com.example.userService.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Value("${server.port}")
  private String port;

  @Value("${eureka.instance.instance-id:${spring.application.name}:${random.value}}")
  private String instanceId;

  @GetMapping({"/", "/index"})
  public String index() {
    return "user-service is up. Try /hello";
  }

  @GetMapping("/hello")
  public String hello() {
    return "Hello from user-service | port=" + port + " | instanceId=" + instanceId;
  }
}