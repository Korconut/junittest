package io.korconut.junittest.dao;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import io.korconut.junittest.dto.Account;

import static io.korconut.junittest.dao.AccountDaoSqls.*;

@Repository
public class AccountDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Account> rowMapper = BeanPropertyRowMapper.newInstance(Account.class);
	
	
	public AccountDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("account")
				.usingGeneratedKeyColumns("id");
	}
	
	public Long insert(Account account) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(account);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public Account selectById(Long id ) {
		try {
			Map<String, ?> params = Collections.singletonMap("id", id);
			return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public int update(Account account) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(account);
		return jdbc.update(UPDATE, params);
	}
	
	
	
	

}
