package com.sm.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sm.entity.Account;
import com.sm.entity.Transactions;
import com.sm.repository.AccountRepository;

@Component
public class FundTransferDaoImpl {
	@Autowired
	AccountRepository accountRepositoryImpl;

	public boolean fromAccount(long sourceAccNo, double amount) {
		Account souAccount = accountRepositoryImpl.findByIdd(sourceAccNo);
		double afterdeductAmt = souAccount.getBalance() - amount;
		accountRepositoryImpl.sendMonyFrom(sourceAccNo, afterdeductAmt);
		return true;

	}

	public boolean toAccount(long destAccNo, double amount) {
		Account souAccount = accountRepositoryImpl.findByIdd(destAccNo);
		double newAmt = souAccount.getBalance() + amount;
		accountRepositoryImpl.sendMonyTo(destAccNo, newAmt);
		return true;

	}

	public boolean fundTransfer(long sourceAccNo, long destAccNo, double amount) {

		boolean result = false;

		// sending amount from source account
		fromAccount(sourceAccNo, amount);

		// sending amount to target account
		toAccount(destAccNo, amount);

		if (result != true) {
			Date date = new Date();
			Account account = new Account();
			account.setAccountNo(sourceAccNo);

			Transactions texn = new Transactions(date, null, account);
			texn.setDate(date);
			texn.setTransactionType("debit");
			texn.setAccount(account);

			result = true;
		}
		return result;

	}

}
