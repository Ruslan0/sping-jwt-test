package com.rsn.user.accounts.repository;

import com.rsn.user.accounts.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testSaveEmployee() {
        User user= new User();
        user.setName("Vasya");
        user.setPassword("11111111");
        User savedUser = userRepository.save(user);
        assertNotNull(savedUser);
        assertEquals("Vasya", savedUser.getName());
    }
}
