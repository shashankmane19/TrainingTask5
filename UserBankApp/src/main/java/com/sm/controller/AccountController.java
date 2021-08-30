package com.sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sm.entity.Account;
import com.sm.service.AccountServiceImpl;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@PostMapping("/fundtransfer")
	public ResponseEntity<String> fundTransfer(@RequestParam("sourceAccNo") long sourceAccNo,@RequestParam("destAccNo") long destAccNo, @RequestParam("amount") double amount){
		accountServiceImpl.fundTransfer(sourceAccNo,destAccNo,amount);
		return ResponseEntity.ok("Fund Transfer Successfully");
	}
	
	 @PostMapping("/fundtransferto") public ResponseEntity<Boolean>
	 toAccount(@RequestParam long destAccNo,@RequestParam double amount) {
	 return ResponseEntity.ok(accountServiceImpl.toAccount(destAccNo,amount));
	  
	  }

	
	 @GetMapping("/fundtransfer") public ResponseEntity<Boolean>
	 fromAccount(@RequestParam long sourceAccNo,@RequestParam double amount) {
	 return ResponseEntity.ok(accountServiceImpl.fromAccount(sourceAccNo,amount));
	  
	  }

}
