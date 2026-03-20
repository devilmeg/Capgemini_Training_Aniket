package com.example.capgiBank.controller;

import com.example.capgiBank.constants.AccountConstant;
import com.example.capgiBank.entity.Account;
import com.example.capgiBank.entity.dto.AccountDto;
import com.example.capgiBank.entity.dto.AccountResponseDto;
import com.example.capgiBank.entity.dto.ResponseDto;
import com.example.capgiBank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.capgiBank.constants.AccountConstant;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;


    @PostMapping(value = "/xml",consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto>createAccount(@RequestBody AccountDto accountDto) {
        accountService.createAccount(accountDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.MESSAGE_200,null));

    }
//    @GetMapping("/byId/{id}")
//    public ResponseEntity<ResponseDto>getAccountById(@PathVariable Integer id) {
//    AccountResponseDto accountDto=accountService.getAccountById(id);
//    return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.MESSAGE_200,accountDto));
//    }
@GetMapping("/exception")
public ResponseEntity<ResponseDto>exceptionHandlingfindById(@RequestParam Integer id) {
    AccountResponseDto accountDto=accountService.findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.MESSAGE_200,accountDto));
}


    @GetMapping
    public ResponseEntity<ResponseDto>findAll() {
        List<AccountResponseDto>accountResponseDtoList=accountService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.MESSAGE_200,accountResponseDtoList));
    }
//
//    @GetMapping("/byId/{id}")
//    public ResponseEntity<ResponseDto>getAccountById(@PathVariable Integer id) {
//        AccountResponseDto accountDto = accountService.getAccountById(id);
//
//    }

@PutMapping("/put/{id}")
    public ResponseEntity<ResponseDto>updateAccount(@PathVariable Integer id,@RequestBody AccountDto req){
        AccountResponseDto accountResponseDto=accountService.updateAccount(id,req);

        return ResponseEntity.ok(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.MESSAGE_200,accountResponseDto));

}
@PatchMapping("/patch/{id}")
    public ResponseEntity<ResponseDto>patchAccount(@PathVariable Integer id,@RequestBody AccountDto req){
        AccountResponseDto accountResponseDto=accountService.patchUpdateAccount(id,req);
        return ResponseEntity.ok(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.MESSAGE_200,accountResponseDto));
}

    @PostMapping("/transfer")
    public ResponseEntity<ResponseDto>transferAccount(@RequestParam Integer fromId,@RequestParam Integer toId,@RequestBody Long amount){
        accountService.transferMoney(fromId,toId,amount);
        return ResponseEntity.ok(new ResponseDto(AccountConstant.STATUS_200,"Account transfer",null));

    }

}
