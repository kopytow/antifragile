package ru.productstar.antifragile.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.productstar.antifragile.model.Exam;
import ru.productstar.antifragile.model.PersonalCard;
import ru.productstar.antifragile.model.Rating;
import ru.productstar.antifragile.model.builders.ExamBuilderImpl;
import ru.productstar.antifragile.model.builders.PersonalCardBuilderImpl;
import ru.productstar.antifragile.repositories.ExamRepository;
import ru.productstar.antifragile.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Обслуживание рейтинга.
 * ---------------------
 *
 * @author Bazil Kopytow 26.03.2024
 */
@Service
@Transactional//(readOnly = true)
public class RatingServiceImpl implements RatingService {

    /**
     * Репозиторий оценок.
     */
    private final ExamRepository repository;
    /**
     * Репозиторий пользователя.
     */
    private final PersonRepository personRepository;

    /**
     * Конструктор, создаёт экземпляр класса, инициализируя внедряемыми зависимостями.
     * @param repository репозиторий оценок
     * @param personRepository репозиторий пользователя
     */
    public RatingServiceImpl(ExamRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    @Override
    public Collection<Rating> getTopRating(int limit) {
        var examList = repository.findAll()
                .stream().collect(Collectors.groupingBy(Exam::getPerson));
        var ratings = new ArrayList<Rating>();
        examList.forEach((key, value) -> {
            var grade = value.stream().mapToInt(Exam::getGrade).filter(exam -> exam >= 0).max().orElse(0);
            ratings.add(new Rating(key.getNickname(), grade));
        });
        ratings.sort(Comparator.comparingInt(Rating::grade).reversed());
        return ratings;
    }

    @Override
    public List<Exam> getExamByPersonId(long personId) {
        var person = personRepository.findById(personId);
        if (person.isPresent()) {
            return repository.findAllByPersonId(person.get().getId());
        }
        return List.of();
    }

    @Override
    public int getAverageRating() {
        var average = repository.findAll().stream().flatMapToInt(exam -> IntStream.of(exam.getGrade())).average().orElse(0);
        return (int) (Math.ceil(average * 100) / 100);
    }

    @Override
    public PersonalCard getPersonalCardByPersonId(long personId) {
        var exam = getExamByPersonId(personId);
        var average = getAverageRating();
        var builder = new PersonalCardBuilderImpl();

        if (!exam.isEmpty()) {
            var e = exam.stream().max(Comparator.comparing(Exam::getGrade)).orElseThrow();
            builder
                    .exam_date(e.getExamDate())
                    .number_correct_answers(e.getNumber_correct_answers())
                    .nickname(e.getPerson().getNickname())
                    .timekeeping(e.getTimeKeeping())
                    .username(e.getPerson().getFirstName())
                    .grade(e.getGrade())
                    .other_grade(average)
                    .self_esteem(e.getSelf_esteem());
        }
        return builder.build();
    }

    @Override
    public PersonalCard createPersonalCard(PersonalCard card) {
        var person = personRepository.findByNickname(card.getNickname());
        var average = getAverageRating();
        var exam = repository.save(new ExamBuilderImpl()
                .person(person)
                .examDate(card.getExam_date())
                .timeKeeping(card.getTimekeeping())
                .grade(card.getGrade())
                .number_correct_answers(card.getNumber_correct_answers())
                .self_esteem(card.getSelf_esteem())
                .build());
        card.setOther_grade(average);
        return card;
    }

    @Override
    public Exam saveExam(Exam exam) {
        return repository.save(exam);
    }
}
