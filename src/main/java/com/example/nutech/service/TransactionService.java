package com.example.nutech.service;

import com.example.nutech.dto.response.BalanceResponse;
import com.example.nutech.dto.response.ResponseDTO;

public interface TransactionService {
    ResponseDTO<BalanceResponse> getBalance(String token);
}
