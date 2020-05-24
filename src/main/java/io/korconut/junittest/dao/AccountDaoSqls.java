package io.korconut.junittest.dao;

public class AccountDaoSqls {
	public static final String DELETE_BY_ID = "DELETE FROM account WHERE id = :id";
	public static final String UPDATE = "UPDATE account SET balance = :balance WHERE id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) FROM account";
	public static final String SELECT_BY_ID = "SELECT id, balance FROM account WHERE id = :id";
}
