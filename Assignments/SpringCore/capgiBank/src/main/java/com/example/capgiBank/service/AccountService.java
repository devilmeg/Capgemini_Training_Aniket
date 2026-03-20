package com.example.capgiBank.service;

import com.example.capgiBank.entity.dto.AccountDto;
import com.example.capgiBank.entity.dto.AccountResponseDto;
import com.example.capgiBank.entity.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {

    void createAccount(AccountDto accountDto);

     AccountResponseDto getAccountById(Integer id);

    AccountResponseDto findById(Integer id);

    List<AccountResponseDto> findAll();

//    AccountResponseDto updateAccount(Integer id, AccountDto req);



    AccountResponseDto updateAccount(Integer id, AccountDto req);

    AccountResponseDto patchUpdateAccount(Integer id, AccountDto req);

    void transferMoney(Integer fromId, Integer toId, Long amount);
}
