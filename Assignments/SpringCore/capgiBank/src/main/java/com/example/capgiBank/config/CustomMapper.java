package com.example.capgiBank.config;

import com.example.capgiBank.entity.Account;
import com.example.capgiBank.entity.dto.AccountDto;
import com.example.capgiBank.entity.dto.AccountResponseDto;

public final class CustomMapper {



    // ✅ DTO -> Entity
    public static Account mapDtoToEntity(AccountDto accountDto,Account account) {

        account.setAccountHoldername(accountDto.getAccountHoldername());
        account.setAccountType(accountDto.getAccountType());
        account.setBalance(accountDto.getBalance());
        account.setAccountSecurekey(accountDto.getAccountSecurekey());
        account.setHolderEmail(accountDto.getHolderEmail());
        return account;
    }

    // ✅ Entity -> Response DTO
    public static AccountResponseDto mapAccountToResponsedto(Account account,AccountResponseDto accountResponseDto) {

        accountResponseDto.setAccountHoldername(account.getAccountHoldername());
        accountResponseDto.setAccountType(account.getAccountType());
        accountResponseDto.setBalance(account.getBalance());
        accountResponseDto.setAccountType(account.getAccountType());
        return accountResponseDto;
    }
}