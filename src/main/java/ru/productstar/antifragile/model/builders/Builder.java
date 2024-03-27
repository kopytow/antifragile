package ru.productstar.antifragile.model.builders;

/**
 * Интерфейс шаблона построитель.
 * ---------------------
 *
 * @author Bazil Kopytow 26.03.2024
 */
public interface Builder<T> {
    T build();
}
