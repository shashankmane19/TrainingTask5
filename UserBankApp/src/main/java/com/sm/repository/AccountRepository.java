package com.sm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sm.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    
	@Query("from Account where accountNo=:soruceAccno and balance=:amount")
	void sendMonyFrom(@Param("soruceAccno")long sourceAccno,@Param("amount") double amount);
    
	@Query("from Account where accountNo=:destAccno and balance=:amount")
	void sendMonyTo(@Param("destAccno")long destAccno,@Param("amount")double amount);
	
	@Query("from Account where aid=:sourceAccountId")
	Account findByIdd(@Param("sourceAccountId")long sourceAccountId);


}
