package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.TransactionsDaoImpl;
import com.sm.entity.Transactions;

@Service
public class TransactionsServiceImpl {
	@Autowired
	TransactionsDaoImpl transactionsDaoImpl;
	
	public List<Transactions> fetchTransection() {
		return transactionsDaoImpl.fetchTransection();
		
	}
	
	public boolean save(Transactions txn) {
		transactionsDaoImpl.save(txn);
		return true;
		
	}
	
	

}
