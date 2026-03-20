package com.example.capgiBank.entity.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
//@JacksonXmlRootElement
public class AccountDto {
    private String accountHoldername;

    private String holderEmail;
    private String accountSecurekey;
    private Long balance;
    private AccountType accountType;
}
