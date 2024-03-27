package ru.productstar.antifragile.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.productstar.antifragile.model.builders.PersonalCardBuilderImpl;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Личная карточка
 * Created by Bazil Kopytow 21.03.2024 21:15
 */
public class PersonalCard {

    /**
     * Имя
     */
    @JsonProperty
    private String username;
    /**
     * Прозвище
     */
    @JsonProperty
    private String nickname;
    /**
     * Количество правильных ответов
     */
    @JsonProperty
    private int number_correct_answers;
    /**
     * Скорость прохождения теста
     */
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm")
    private Time timekeeping;
    /**
     * Дата прохождения теста
     */
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    private Timestamp exam_date;
    /**
     * Мой средний результат
     */
    @JsonProperty
    private int grade;
    /**
     * Самооценка
     */
    @JsonProperty
    private int self_esteem;
    /**
     * Результат других
     */
    @JsonProperty
    private int other_grade;

    /**
     * Конструктор без параметров для json.
     */
    public PersonalCard() {
    }

    /**
     * Конструктор создаёт объект, который конструируется построителем {@link PersonalCardBuilderImpl}.
     */
    public PersonalCard(PersonalCardBuilderImpl builder) {
        this.username = builder.username();
        this.nickname = builder.nickname();
        this.number_correct_answers = builder.number_correct_answers();
        this.timekeeping = builder.timekeeping();
        this.exam_date = builder.exam_date();
        this.grade = builder.grade();
        this.self_esteem = builder.self_esteem();
        this.other_grade = builder.other_grade();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getNumber_correct_answers() {
        return number_correct_answers;
    }

    public void setNumber_correct_answers(int number_correct_answers) {
        this.number_correct_answers = number_correct_answers;
    }

    public Time getTimekeeping() {
        return timekeeping;
    }

    public void setTimekeeping(Time timekeeping) {
        this.timekeeping = timekeeping;
    }

    public Timestamp getExam_date() {
        return exam_date;
    }

    public void setExam_date(Timestamp exam_date) {
        this.exam_date = exam_date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSelf_esteem() {
        return self_esteem;
    }

    public void setSelf_esteem(int self_esteem) {
        this.self_esteem = self_esteem;
    }

    public int getOther_grade() {
        return other_grade;
    }

    public void setOther_grade(int other_grade) {
        this.other_grade = other_grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalCard that)) return false;
        return getNumber_correct_answers() == that.getNumber_correct_answers()
                && getGrade() == that.getGrade()
                && getSelf_esteem() == that.getSelf_esteem()
                && getOther_grade() == that.getOther_grade()
                && Objects.equals(getUsername(), that.getUsername())
                && Objects.equals(getNickname(), that.getNickname())
                && Objects.equals(getTimekeeping(), that.getTimekeeping())
                && Objects.equals(getExam_date(), that.getExam_date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getUsername(),
                getNickname(),
                getNumber_correct_answers(),
                getTimekeeping(),
                getExam_date(),
                getGrade(),
                getSelf_esteem(),
                getOther_grade());
    }

    @Override
    public String toString() {
        return "PersonalCard{" +
                "firstname='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", number_correct_answers=" + number_correct_answers +
                ", timekeeping=" + timekeeping +
                ", exam_date=" + exam_date +
                ", grade=" + grade +
                ", self_esteem=" + self_esteem +
                ", other_grade=" + other_grade +
                '}';
    }
}
