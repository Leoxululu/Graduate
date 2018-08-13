package com.my.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.factory.DaoFactory;
import com.my.domain.User;

public class DaoFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetInstance() {
		DaoFactory instance = new DaoFactory();
		assertEquals(instance, DaoFactory.getInstance());
	}

	@Test
	public void testCreateDao() {
		DaoFactory instance = new DaoFactory();
		List<User> user=(List<User>) instance.createDao(User.class);
		assertNotNull(user);
	}

}
