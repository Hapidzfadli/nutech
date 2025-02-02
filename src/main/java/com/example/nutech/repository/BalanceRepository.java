package com.example.nutech.repository;

import com.example.nutech.entity.Balance;
import com.example.nutech.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository  extends JpaRepository<Balance, Long> {
    Balance findByUser(User user);
}
