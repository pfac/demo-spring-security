package com.iampfac.howto.spring.security.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class CustomUsersJdbcUserDetailsService extends JdbcDaoImpl {

	public static final String DEF_USERS_BY_USERNAME_QUERY = "select email,secret from users where email = ?";

	public CustomUsersJdbcUserDetailsService() {
		super();
		setUsersByUsernameQuery(DEF_USERS_BY_USERNAME_QUERY);
	}

	@Override
	public List<UserDetails> loadUsersByUsername(String email) throws UsernameNotFoundException {
		final RowMapper<UserDetails> mapper = new RowMapper<UserDetails>() {
			
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				String email = rs.getString(1);
				String secret = rs.getString(2);
				return new User(email, secret, AuthorityUtils.NO_AUTHORITIES);
			}

		};
		final Object[] args = new String[] { email };
		return getJdbcTemplate().query(getUsersByUsernameQuery(), args, mapper);
	}
}