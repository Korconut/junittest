package io.korconut.junittest.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.korconut.junittest.config.ApplicationConfig;
import io.korconut.junittest.dto.Account;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class AccountDaoTest {
	
	
	@Autowired
	AccountDao accountDao;
	
	Account account;
	
	@Before
	public void setUp() {
		//account = new Account();
		
		//account.setId(1L);
		//account.setBalance(120);
	}
	
	@Test
	public void daoTest() {
		//accountDao.insert(account);
		
		account = accountDao.selectById(1L);
		assertEquals(120, account.getBalance());
		
	}

}
