package com.petstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.petstore.dao.UserDAO;
import com.petstore.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserDAOTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private UserDAO userDao;
	
	@Test
	public void whenFindByName_thenReturnUser() {
		User user = new User();
		user.setUsername("test1");
		user.setPassword("test1");
		entityManager.persist(user);
		entityManager.flush();
		
		User result = userDao.findByUsername("test1");
		
		assertThat(result.getUsername()).isEqualTo(user.getUsername());
	}
	
}
