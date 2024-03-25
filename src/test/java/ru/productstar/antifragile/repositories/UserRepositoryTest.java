package ru.productstar.antifragile.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import ru.productstar.antifragile.Main;
import ru.productstar.antifragile.model.User;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Bazil Kopytow 21.03.2024 20:57
 */
@ContextConfiguration(classes = Main.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager manager;
    @Autowired
    private UserRepository repository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("ravikumar@gmail.com");
        user.setPassword("ravi2020");

        User savedUser = repository.save(user);

        User existUser = manager.find(User.class, savedUser.getId());

        assertTrue(user.getEmail().equalsIgnoreCase(existUser.getEmail()));
    }

}
