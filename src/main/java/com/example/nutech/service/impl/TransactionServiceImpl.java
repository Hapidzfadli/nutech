package com.example.nutech.service.impl;

import com.example.nutech.dto.response.BalanceResponse;
import com.example.nutech.dto.response.ResponseDTO;
import com.example.nutech.entity.Balance;
import com.example.nutech.entity.User;
import com.example.nutech.repository.BalanceRepository;
import com.example.nutech.repository.UserRepository;
import com.example.nutech.security.JwtUtils;
import com.example.nutech.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BalanceRepository balanceRepository;

    @Override
    public ResponseDTO<BalanceResponse> getBalance(String token) {
        if (token == null || token.isEmpty() || !jwtUtils.validateToken(token)) {
            return new ResponseDTO<>(108, "Token tidak valid atau kadaluwarsa", null);
        }
        String email = jwtUtils.extractEmail(token);
        User user = userRepository.findByEmail(email);

        Balance balance = balanceRepository.findByUser(user);
        BalanceResponse newBalance = new BalanceResponse();
        newBalance.setBalance(balance.getBalance());
        return new ResponseDTO<>(200, "Get Balance Berhasil", newBalance);
    }
}
