package com.jh.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.jh.s6.AbstractTest;

public class DBConnectTest extends AbstractTest{
	
	@Inject
	private DriverManagerDataSource dataSource;
	
	@Test
	public void test() throws Exception{
		Connection con = dataSource.getConnection();
		assertNotNull(con);
	}

}
