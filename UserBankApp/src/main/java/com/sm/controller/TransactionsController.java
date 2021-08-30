package com.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sm.entity.Transactions;
import com.sm.service.TransactionsServiceImpl;

@Controller
@RequestMapping("/transactions")
public class TransactionsController {
	@Autowired
	TransactionsServiceImpl transactionServiceImpl;

	@PostMapping("/transactions")
	public ResponseEntity<Boolean> save(Transactions txn) {
		return ResponseEntity.ok(transactionServiceImpl.save(txn));

	}

	@GetMapping("/transactions")
	public ResponseEntity<List<Transactions>> fetchTransection() {
		return ResponseEntity.ok(transactionServiceImpl.fetchTransection());

	}

}
