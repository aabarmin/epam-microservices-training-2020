package com.epam.training.microservices.banking.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TransactionsApplication {
  public static void main(String[] args) {
    SpringApplication.run(TransactionsApplication.class, args);
  }
}
