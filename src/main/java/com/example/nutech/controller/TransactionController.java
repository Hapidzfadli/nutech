package com.example.nutech.controller;

import com.example.nutech.dto.response.BalanceResponse;
import com.example.nutech.dto.response.ResponseDTO;
import com.example.nutech.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Tag(name = "3. Module Transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Operation(
            summary = "Get Balance",
            description = "Balance"
    )
    @GetMapping("/balance")
    public ResponseEntity<ResponseDTO<BalanceResponse>> getBalance(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.ok(new ResponseDTO<>(108, "Token tidak valid atau kadaluwarsa", null));
        }
        String token = authHeader.replace("Bearer ", "");
        ResponseDTO<BalanceResponse>  response = transactionService.getBalance(token);
        return ResponseEntity.ok(response);
    }
}
