package com.iampfac.howto.spring.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class CustomLdapJdbcUserDetailsService extends JdbcDaoImpl implements JdbcUserDetailsService {

	/**
	 * Retrieves the authorities associated with an LDAP group.
	 * 
	 * @param groupDn
	 *            Distinguished Name of the LDAP group.
	 * 
	 * @return A list with all the authorities granted to the users belonging to
	 *         groupDn.
	 */
	@Override
	public List<GrantedAuthority> loadGroupAuthorities(String groupDn) {
		final String query = "select r.name from authorities a, roles r where a.attribute_value = ? and a.role_id = r.id";
		final Object[] params = new String[] { groupDn };
		return getJdbcTemplate().query(query, params, new RowMapper<GrantedAuthority>() {

			@Override
			public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
				final String roleName = rs.getString(1);
				return new SimpleGrantedAuthority(roleName);
			}
			
		});
	}

}
