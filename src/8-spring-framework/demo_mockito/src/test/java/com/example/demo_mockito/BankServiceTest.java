package com.example.demo_mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) // Pure Mockito sandbox — no heavy Spring booting required!
public class BankServiceTest {

    @Mock
    private BankRepository mockRepo; 

    @InjectMocks
    private BankService service; 

    @Test
    void testDeposit() {
        // Arrange
        BankAccount account = new BankAccount("123", 500.0);
        when(mockRepo.findByAccountNumber("123")).thenReturn(account);

        // Act
        service.deposit("123", 200.0);

        // Assert
        assertEquals(700.0, account.getBalance());
        verify(mockRepo).save(account); 
    }

    @Test
    void testWithdrawSuccess() {
        // Arrange
        BankAccount account = new BankAccount("123", 500.0);
        when(mockRepo.findByAccountNumber("123")).thenReturn(account);

        // Act
        service.withdraw("123", 200.0);

        // Assert
        assertEquals(300.0, account.getBalance());
        verify(mockRepo).save(account);
    }

    @Test
    void testWithdrawInsufficientFunds() {
        // Arrange
        BankAccount account = new BankAccount("123", 100.0);
        when(mockRepo.findByAccountNumber("123")).thenReturn(account);

        // Act & Assert
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> service.withdraw("123", 200.0));

        assertEquals("Insufficient funds", ex.getMessage());
        verify(mockRepo, never()).save(account); 
    }
}
