package com.example.capgiBank.service;

import com.example.capgiBank.entity.Account;
import com.example.capgiBank.entity.dto.AccountDto;
import com.example.capgiBank.entity.dto.AccountResponseDto;
import com.example.capgiBank.exception.AccountNotFoundException;
import com.example.capgiBank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;
//    @Override
//   public void createAccount(AccountDto accountDto) {
//    Account account= CustomMapper.mapDtoToEntity(accountDto,new Account());
//    accountRepository.save(account);
//    }
    @Override
    public void createAccount(AccountDto accountDto) {
        Account account=modelMapper.map(accountDto,Account.class);
        accountRepository.save(account);

    }
    @Override
    public AccountResponseDto getAccountById(Integer id) {
       Account account=accountRepository.getReferenceById(id);
       AccountResponseDto accountResponseDto=modelMapper.map(account,AccountResponseDto.class);
       return accountResponseDto;
    }
    @Override
    public AccountResponseDto findById(Integer id){
        Account account=accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account not found"));
        return modelMapper.map(account,AccountResponseDto.class);
    }
    @Override
    public List<AccountResponseDto> findAll(){
        List<Account>accountList=accountRepository.findAll();
        List<AccountResponseDto> dtos = accountList.stream().map(account ->modelMapper.map(account,AccountResponseDto.class)).toList();

        return dtos;
    }

    @Override
    public AccountResponseDto updateAccount(Integer id, AccountDto req) {
        Account account=accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account not found"));
        // 🔥 Reset behavior for PUT
        modelMapper.getConfiguration().setSkipNullEnabled(false);
        modelMapper.map(req,account);
        Account savedAccount=accountRepository.save(account);
        return modelMapper.map(savedAccount,AccountResponseDto.class);
    }

    @Override
    public AccountResponseDto patchUpdateAccount(Integer id, AccountDto req) {
        Account account=accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account not found"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(req,account);
        Account savedAccount=accountRepository.save(account);
        return modelMapper.map(savedAccount,AccountResponseDto.class);
    }


    //transaction
    @Transactional
    @Override
    public void transferMoney(Integer fromId, Integer toId, Long amount) {

        //  Fetch sender account
        Account fromAccount = accountRepository.findById(fromId)
                .orElseThrow(() -> new RuntimeException("Sender account not found"));

        //  Fetch receiver account
        Account toAccount = accountRepository.findById(toId)
                .orElseThrow(() -> new RuntimeException("Receiver account not found"));

        //  Prevent self transfer
        if (fromId.equals(toId)) {
            throw new RuntimeException("Cannot transfer to same account");
        }

        //  Validate amount
        if (amount <= 0) {
            throw new RuntimeException("Invalid transfer amount");
        }

        //  Check sufficient balance
        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        //  Deduct from sender
        fromAccount.setBalance(fromAccount.getBalance() - amount);

        // 💰 Add to receiver
        toAccount.setBalance(toAccount.getBalance() + amount);

        // 💾 Save both accounts
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }



}
