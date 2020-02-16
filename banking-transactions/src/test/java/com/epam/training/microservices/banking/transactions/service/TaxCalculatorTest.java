package com.epam.training.microservices.banking.transactions.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TaxCalculatorTest {
  @InjectMocks
  private TaxCalculator unitUnderTest;

  @ParameterizedTest
  @CsvSource({
          "100, 0, 100",
          "100, 5, 105"
  })
  void withTax(Long amount, Long tax, Long withTax) {
    assertEquals(withTax, unitUnderTest.withTax(amount, tax));
  }
}