package com.sm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sm.entity.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
	
    @Query("from Transactions")
	List<Transactions> fetchTransection();
    
    @Query("from Transactions")
	void savee(@Param("txn")Transactions txn);

}
