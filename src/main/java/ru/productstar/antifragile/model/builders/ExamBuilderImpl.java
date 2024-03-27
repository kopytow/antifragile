package ru.productstar.antifragile.model.builders;

import jakarta.persistence.*;
import ru.productstar.antifragile.model.Exam;
import ru.productstar.antifragile.model.Person;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * ---------------------
 *
 * @author Bazil Kopytow 26.03.2024
 */
public class ExamBuilderImpl implements Builder<Exam> {

    /**
     * id идентификатор
     */
    private Long id;
    /**
     * student студент
     */
    private Person person;
    /**
     * examDate время сдачи
     */
    private Timestamp examDate;
    /**
     * timeKeeping учёт времени
     */
    private Time timeKeeping;
    /**
     * percent оценка
     */
    private int grade;

    /**
     * Самооценка
     */
    private int self_esteem = 0;

    /**
     * Число правильных ответов.
     */
    @Column(nullable = true)
    private int number_correct_answers;

    public ExamBuilderImpl() {
    }

    public Long id() {
        return id;
    }

    public ExamBuilderImpl id(Long id) {
        this.id = id;
        return this;
    }

    public Person person() {
        return person;
    }

    public ExamBuilderImpl person(Person person) {
        this.person = person;
        return this;
    }

    public Timestamp examDate() {
        return examDate;
    }

    public ExamBuilderImpl examDate(Timestamp examDate) {
        this.examDate = examDate;
        return this;
    }

    public Time timeKeeping() {
        return timeKeeping;
    }

    public ExamBuilderImpl timeKeeping(Time timeKeeping) {
        this.timeKeeping = timeKeeping;
        return this;
    }

    public int grade() {
        return grade;
    }

    public ExamBuilderImpl grade(int grade) {
        this.grade = grade;
        return this;
    }

    public int self_esteem() {
        return self_esteem;
    }

    public ExamBuilderImpl self_esteem(int self_esteem) {
        this.self_esteem = self_esteem;
        return this;
    }

    public int number_correct_answers() {
        return number_correct_answers;
    }

    public ExamBuilderImpl number_correct_answers(int number_correct_answers) {
        this.number_correct_answers = number_correct_answers;
        return this;
    }

    @Override
    public Exam build() {
        return new Exam(this);
    }
}
