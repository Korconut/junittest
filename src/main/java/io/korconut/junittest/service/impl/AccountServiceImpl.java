package io.korconut.junittest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.korconut.junittest.dao.AccountDao;
import io.korconut.junittest.dto.Account;
import io.korconut.junittest.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountDao accountDao;
	
	@Override
	@Transactional // read only
	public List<Account> getAccountForUse(Long senderId, Long beneficiaryId) {
		List<Account> list = new ArrayList<>();
		list.add(accountDao.selectById(senderId));
		list.add(accountDao.selectById(beneficiaryId));
		
		return list;
	}
	
	@Override
	@Transactional(readOnly=false) //read Only로 하면 안된다. 동시성이던가
	public int transfer(Long senderId, Long beneficiaryId, int amount) {
		Account account1 = new Account();
		Account account2 = new Account();
		int result = 1;
		int tmp;
		account1 = accountDao.selectById(senderId);
		tmp = account1.getBalance();
		account1.setBalance(tmp-amount);
		account2 = accountDao.selectById(beneficiaryId);
		tmp = account2.getBalance();
		account2.setBalance(tmp+amount);
		return result * accountDao.update(account1) * accountDao.update(account2);
	}

}
