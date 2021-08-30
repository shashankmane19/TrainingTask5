package com.sm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sm.entity.Transactions;
import com.sm.repository.TransactionsRepository;

@Component
public class TransactionsDaoImpl {
	@Autowired
	TransactionsRepository transactionsRepository;

	public List<Transactions> fetchTransection() {
		return transactionsRepository.fetchTransection();
	}

	public void save(Transactions txn) {
		transactionsRepository.savee(txn);

	}

}
