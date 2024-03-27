package ru.productstar.antifragile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.productstar.antifragile.model.Exam;

import java.util.List;

/**
 * Интерфейс доступа к таблице базы данных exams.
 * ------------------------
 * -- Table: public.exams
 * -- DROP TABLE IF EXISTS public.exams;
 * CREATE TABLE IF NOT EXISTS public.exams
 * (
 *     percent integer,
 *     time_keeping time(6) without time zone NOT NULL,
 *     exam_date timestamp(6) without time zone NOT NULL,
 *     id bigint NOT NULL DEFAULT nextval('exams_id_seq'::regclass),
 *     persons_pkey bigint,
 *     CONSTRAINT exams_pkey PRIMARY KEY (id),
 *     CONSTRAINT exams_persons_pkey_key UNIQUE (persons_pkey),
 *     CONSTRAINT fk9bc5dvgmhuw2ngsxg3mqmhi4i FOREIGN KEY (persons_pkey)
 *         REFERENCES public.persons (id) MATCH SIMPLE
 *         ON UPDATE NO ACTION
 *         ON DELETE NO ACTION
 * )
 * TABLESPACE pg_default;
 * ------------------------
 * Created by Bazil Kopytow 21.03.2024 21:52
 */
public interface ExamRepository extends JpaRepository<Exam, Long> {
//    @Query(nativeQuery = true, value = "select * from public.exams where persons_pkey=:personId")
    List<Exam> findAllByPersonId(Long personId);
}
