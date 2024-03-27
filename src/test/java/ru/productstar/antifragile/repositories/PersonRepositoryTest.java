package ru.productstar.antifragile.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import ru.productstar.antifragile.Main;
import ru.productstar.antifragile.model.Person;
import ru.productstar.antifragile.model.User;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Bazil Kopytow 21.03.2024 21:30
 */
@ContextConfiguration(classes = Main.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class PersonRepositoryTest {

    private final TestEntityManager manager;

    private final UserRepository userRepository;

    private final PersonRepository repository;

    public PersonRepositoryTest(@Autowired TestEntityManager manager, @Autowired UserRepository userRepository, @Autowired PersonRepository repository) {
        this.manager = manager;
        this.userRepository = userRepository;
        this.repository = repository;

        User user = new User();
        user.setEmail("ravikumar@gmail.com");
        user.setPassword("ravi2020");
        User savedUser = userRepository.save(user);
    }

    @Test
    public void testCreatePerson() {
        var user = userRepository.findById(1L);
        if (user.isPresent()) {
            var person = new Person();
            person.setUser(user.get());
            person.setFirstName("Ravi");
            person.setLastName("Kumar");
            person.setNickname("K.Ravi");
            person.setPhone("+0(000)-000-00-00");
            person.setPdpc(false);

            var savedPerson = repository.save(person);
            var existedPerson = manager.find(Person.class, savedPerson.getId());
            assertEquals(existedPerson.getFirstName(), savedPerson.getFirstName());
        }
    }
}