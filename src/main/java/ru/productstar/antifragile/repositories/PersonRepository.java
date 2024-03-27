package ru.productstar.antifragile.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.productstar.antifragile.model.Person;

/**
 * Интерфейс доступа к таблице базы данных persons
 *    ------------------
 * -- Table: public.persons
 * -- DROP TABLE IF EXISTS public.persons;
 * create table exams
 * (
 *     grade                  integer,
 *     number_correct_answers integer,
 *     self_esteem            integer,
 *     time_keeping           time(6)      not null,
 *     exam_date              timestamp(6) not null,
 *     id                     bigserial
 *         primary key,
 *     persons_pkey           bigint
 *         constraint fk9bc5dvgmhuw2ngsxg3mqmhi4i
 *             references persons
 * );
 * TABLESPACE pg_default;
 *     ----------------------
 * Created by Bazil Kopytow 21.03.2024 21:28
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
    /**
     * Найти запись, соответствующую указанному прозвищу.
     * @param nickname прозвище
     * @return пользователя {@link Person}
     */
    Person findByNickname(String nickname);
}
