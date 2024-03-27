package ru.productstar.antifragile.services;

import ru.productstar.antifragile.model.Exam;
import ru.productstar.antifragile.model.PersonalCard;
import ru.productstar.antifragile.model.Rating;

import java.util.Collection;
import java.util.List;

/**
 * Интерфейс обслуживания рейтингов.
 * ---------------------
 *
 * @author Bazil Kopytow 26.03.2024
 */
public interface RatingService {
    /**
     * Получит список рейтингов в порядке убывания.
     * @param limit число возвращаемых рейтингов
     * @return список рейтингов, тип элемента {@link Rating}
     */
    Collection<Rating> getTopRating(int limit);

    /**
     * Найти тест по идентификатору ползователя.
     *
     * @param personId идентификатор
     * @return тест {@link Exam}
     */
    List<Exam> getExamByPersonId(long personId);

    /**
     * Получить средний рейтинг.
     * @return средний рейтинг
     */
    int getAverageRating();

    /**
     * Получить личную карточку по идентификатору пользователя.
     * @param personId идентификатор
     * @return личная карточка {@link PersonalCard}
     */
    PersonalCard getPersonalCardByPersonId(long personId);

    /**
     * Создать личную карточку по шаблону.
     * В передаваемом шаблоне значение поля "Результат других" равен нулю.
     * Выполняет сохранение записи об пройденном тесте.
     * @param card шаблон личной карточки
     * @return личную карточку {@link PersonalCard}
     */
    PersonalCard createPersonalCard(PersonalCard card);

    /**
     * Сохранить запись о пройденном тесте.
     * @param exam пройденный тест {@link Exam}
     * @return сохранённый базе данных тест {@link Exam}
     */
    Exam saveExam(Exam exam);
}
