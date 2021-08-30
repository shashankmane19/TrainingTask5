package com.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.FundTransferDaoImpl;

@Service
public class AccountServiceImpl {
	@Autowired
	FundTransferDaoImpl fundTransferDaoImpl;

	public boolean fromAccount(long sourceAccNo, double amount) {
		return fundTransferDaoImpl.fromAccount(sourceAccNo, amount);

	}

	public boolean toAccount(long destAccNo, double amount) {
		return fundTransferDaoImpl.toAccount(destAccNo, amount);

	}

	public boolean fundTransfer(long sourceAccNo, long destAccNo, double amount) {
		return fundTransferDaoImpl.fundTransfer(sourceAccNo, destAccNo, amount);

	}

}
