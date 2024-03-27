package ru.productstar.antifragile.model.builders;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.productstar.antifragile.model.PersonalCard;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * ---------------------
 *
 * @author Bazil Kopytow 26.03.2024
 */
public class PersonalCardBuilderImpl implements Builder<PersonalCard> {

    /**
     * Имя
     */
    private String username;
    /**
     * Прозвище
     */
    private String nickname;
    /**
     * Количество правильных ответов
     */
    private int number_correct_answers;
    /**
     * Скорость прохождения теста
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm")
    private Time timekeeping;
    /**
     * Дата прохождения теста
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    private Timestamp exam_date;
    /**
     * Мой средний результат
     */
    private int grade;
    /**
     * Самооценка
     */
    private int self_esteem;
    /**
     * Результат других
     */
    private int other_grade;

    public String username() {
        return username;
    }

    public PersonalCardBuilderImpl username(String username) {
        this.username = username;
        return this;
    }

    public String nickname() {
        return nickname;
    }

    public PersonalCardBuilderImpl nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public int number_correct_answers() {
        return number_correct_answers;
    }

    public PersonalCardBuilderImpl number_correct_answers(int number_correct_answers) {
        this.number_correct_answers = number_correct_answers;
        return this;
    }

    public Time timekeeping() {
        return timekeeping;
    }

    public PersonalCardBuilderImpl timekeeping(Time timekeeping) {
        this.timekeeping = timekeeping;
        return this;
    }

    public Timestamp exam_date() {
        return exam_date;
    }

    public PersonalCardBuilderImpl exam_date(Timestamp exam_date) {
        this.exam_date = exam_date;
        return this;
    }

    public int grade() {
        return grade;
    }

    public PersonalCardBuilderImpl grade(int grade) {
        this.grade = grade;
        return this;
    }

    public int self_esteem() {
        return self_esteem;
    }

    public PersonalCardBuilderImpl self_esteem(int self_esteem) {
        this.self_esteem = self_esteem;
        return this;
    }

    public int other_grade() {
        return other_grade;
    }

    public PersonalCardBuilderImpl other_grade(int other_grade) {
        this.other_grade = other_grade;
        return this;
    }

    @Override
    public PersonalCard build() {
        return new PersonalCard(this);
    }
}
