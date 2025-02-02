package com.example.nutech.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BalanceResponse {
    private BigDecimal balance;
}
