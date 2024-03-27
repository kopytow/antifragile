package ru.productstar.antifragile.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import ru.productstar.antifragile.Main;
import ru.productstar.antifragile.model.Exam;
import ru.productstar.antifragile.model.Person;
import ru.productstar.antifragile.model.User;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Bazil Kopytow 21.03.2024 21:53
 */
@ContextConfiguration(classes = Main.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class ExamRepositoryTest {

    private final TestEntityManager manager;
    private final ExamRepository repository;
    private final PersonRepository personRepository;

    public ExamRepositoryTest(@Autowired TestEntityManager manager,
                              @Autowired ExamRepository repository,
                              @Autowired PersonRepository personRepository,
                              @Autowired UserRepository userRepository) {
        this.manager = manager;
        this.repository = repository;
        this.personRepository = personRepository;

        // Аутентификация.
        User user = new User();
        user.setEmail("ravikumar@gmail.com");
        user.setPassword("ravi2020");
        User savedUser = userRepository.save(user);
        // Пользователь.
        var person = new Person();
        person.setUser(savedUser);
        person.setFirstName("Ravi");
        person.setLastName("Kumar");
        person.setNickname("K.Ravi");
        person.setPhone("+0(000)-000-00-00");
        person.setPdpc(false);
        var savedPerson = personRepository.save(person);
    }

    @Test
    public void testCreateExam() {
        var now = Timestamp.valueOf(LocalDateTime.now());
        var person = personRepository.findById(1L);
        if (person.isPresent()) {
            var exam = new Exam();
            exam.setPerson(person.get());
            exam.setExamDate(now);
            exam.setTimeKeeping(Time.valueOf("00:17:45"));
            exam.setGrade(17);

            var savedExam = repository.save(exam);
            var existedExam = manager.find(Exam.class, savedExam.getId());
            assertTrue(existedExam.getExamDate().toString().equalsIgnoreCase(now.toString()));
        }
    }
}