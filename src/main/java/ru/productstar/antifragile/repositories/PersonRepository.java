package ru.productstar.antifragile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.productstar.antifragile.model.Person;

/**
 * Интерфейс доступа к таблице базы данных persons
 *    ------------------
 * -- Table: public.persons
 * -- DROP TABLE IF EXISTS public.persons;
 * CREATE TABLE IF NOT EXISTS public.persons
 * (
 *     personal_data_processing_consent boolean NOT NULL,
 *     id bigint NOT NULL DEFAULT nextval('persons_id_seq'::regclass),
 *     users_pkey bigint,
 *     phone character varying(50) COLLATE pg_catalog."default" NOT NULL,
 *     first_name character varying(64) COLLATE pg_catalog."default" NOT NULL,
 *     last_name character varying(64) COLLATE pg_catalog."default" NOT NULL,
 *     nickname character varying(64) COLLATE pg_catalog."default" NOT NULL,
 *     CONSTRAINT persons_pkey PRIMARY KEY (id),
 *     CONSTRAINT persons_users_pkey_key UNIQUE (users_pkey),
 *     CONSTRAINT fkixtq7vllb2ex2tl5y6k16a90u FOREIGN KEY (users_pkey)
 *         REFERENCES public.users (id) MATCH SIMPLE
 *         ON UPDATE NO ACTION
 *         ON DELETE NO ACTION
 * )
 * TABLESPACE pg_default;
 *     ----------------------
 * Created by Bazil Kopytow 21.03.2024 21:28
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
