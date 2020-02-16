package com.epam.training.microservices.banking.transactions.service;

import com.epam.training.microservices.banking.transactions.model.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
  @Mock
  private AccountService accountService;
  @Mock
  private TaxCalculator taxCalculator;
  @InjectMocks
  private TransactionService unitUnderTest;

  @Test
  public void check_contextStarts() {
    assertAll(
            () -> assertNotNull(unitUnderTest)
    );
  }

  @Test
  public void withdraw_throwsAnExceptionIfAccountNotFound() {
    when(accountService.findOne(anyLong())).thenReturn(null);

    assertThrows(
            NoAccountException.class,
            () -> unitUnderTest.withdraw(10L, 10L)
    );
  }

  @Test
  public void withdraw_throwsAnExceptionIfNotEnoughMoney() {
    final Account account = mock(Account.class);
    when(accountService.findOne(anyLong())).thenReturn(account);
    when(account.getAccountAmount()).thenReturn(10L);

    assertThrows(
            NotEnoughMoneyException.class,
            () -> unitUnderTest.withdraw(10L, 100L)
    );
  }

  @Test
  public void withdraw_shouldDecreaseAmountOfMoney() {
    final Account account = new Account();
    account.setAccountAmount(100L);

    when(accountService.findOne(anyLong())).thenReturn(account);

    final ArgumentCaptor<Account> accountCaptor = ArgumentCaptor.forClass(Account.class);

    final boolean result = unitUnderTest.withdraw(10L, 50L);

    verify(accountService, times(1)).save(accountCaptor.capture());

    assertTrue(result);
    assertEquals(50L, accountCaptor.getValue().getAccountAmount());
  }
}