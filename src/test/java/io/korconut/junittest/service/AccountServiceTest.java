package io.korconut.junittest.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
public class AccountServiceTest {
	
	@Autowired
	AccountService accountService;
	
	List<Account> list;
	
	@Before 
	public void setUp() {
		
	}
	
	@Test
	public void serviceTest() {
		list = accountService.getAccountForUse(1L, 2L);
		for(Account account : list) {
			System.out.println(account);
			
		}
		int updateCount = accountService.transfer(2L, 1L, 50);
		assertEquals(1, updateCount);
	}
	
	
	

}
