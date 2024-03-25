package ru.productstar.antifragile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.productstar.antifragile.model.User;

/**
 * Интерфейс доступа к таблице базы данных users
 *    -------------------
 * -- Table: public.users
 * -- DROP TABLE IF EXISTS public.users;
 * CREATE TABLE IF NOT EXISTS public.users
 * (
 *     id bigint NOT NULL DEFAULT nextval('users_id_seq'::regclass),
 *     email character varying(64) COLLATE pg_catalog."default" NOT NULL,
 *     password character varying(64) COLLATE pg_catalog."default" NOT NULL,
 *     CONSTRAINT users_pkey PRIMARY KEY (id),
 *     CONSTRAINT users_email_key UNIQUE (email),
 *     CONSTRAINT users_password_key UNIQUE (password)
 * )
 * TABLESPACE pg_default;
 *     -------------------------
 * Created by Bazil Kopytow 21.03.2024 18:54
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
