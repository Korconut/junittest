package io.korconut.junittest.service;

import java.util.List;

import io.korconut.junittest.dto.Account;

public interface AccountService {
	
	public List<Account> getAccountForUse(Long senderId, Long beneficiaryId);
	public int transfer(Long senderId, Long beneficiaryId, int amount);

}
