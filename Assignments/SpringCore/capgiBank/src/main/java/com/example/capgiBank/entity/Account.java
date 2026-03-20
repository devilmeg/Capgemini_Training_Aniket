package com.example.capgiBank.entity;


import com.example.capgiBank.entity.dto.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer accountId;

    private String accountHoldername;

    private String holderEmail;
    private String accountSecurekey;
    private Long balance;
    private AccountType accountType;
}
