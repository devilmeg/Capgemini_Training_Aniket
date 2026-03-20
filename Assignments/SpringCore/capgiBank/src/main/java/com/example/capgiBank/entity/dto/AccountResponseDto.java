package com.example.capgiBank.entity.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AccountResponseDto {
    private Long balance;
    private AccountType accountType;
    private Integer accountId;
    private String accountHoldername;


}
