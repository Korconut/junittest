package io.korconut.junittest.dto;

public class Account {
	
	/**
	 * 계좌 아이디
	 */
	private Long id;
	/**
	 *  계좌 잔고
	 */
	private int balance;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}
}
