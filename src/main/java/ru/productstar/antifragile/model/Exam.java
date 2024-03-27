package ru.productstar.antifragile.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import ru.productstar.antifragile.model.builders.ExamBuilderImpl;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Запись о пройденном тесте.
 * Created by Bazil Kopytow 21.03.2024 21:37
 */
@Entity
@Table(name = "exams")
public class Exam implements Comparable<Exam> {
    /**
     * id идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * student студент
     */
    @ManyToOne
    @JoinColumn(name = "persons_pkey")
    private Person person;
    /**
     * examDate время сдачи
     */
    @Column(nullable = false)
    private Timestamp examDate;
    /**
     * timeKeeping учёт времени
     */
    @Column(nullable = false)
    private Time timeKeeping;
    /**
     * percent оценка
     */
    @Column(nullable = true)
    private int grade;

    /**
     * Самооценка
     */
    @Column(nullable = true)
    private int self_esteem;

    /**
     * Число правильных ответов.
     */
    @Column(nullable = true)
    private int number_correct_answers;

    /**
     * Конструктор по умолчанию. Нужен для ORM/
     */
    public Exam() {
    }

    /**
     * Конструктор по умолчанию. Нужен для ORM/
     */
    public Exam(ExamBuilderImpl builder) {
        this.id = builder.id();
        this.person = builder.person();
        this.examDate = builder.examDate();
        this.timeKeeping = builder.timeKeeping();
        this.grade = builder.grade();
        this.self_esteem = builder.self_esteem();
        this.number_correct_answers = builder.number_correct_answers();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Timestamp getExamDate() {
        return examDate;
    }

    public void setExamDate(Timestamp examDate) {
        this.examDate = examDate;
    }

    public Time getTimeKeeping() {
        return timeKeeping;
    }

    public void setTimeKeeping(Time timeKeeping) {
        this.timeKeeping = timeKeeping;
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

    public int getNumber_correct_answers() {
        return number_correct_answers;
    }

    public void setNumber_correct_answers(int level) {
        this.number_correct_answers = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exam exam)) return false;
        return getGrade() == exam.getGrade() && getSelf_esteem() == exam.getSelf_esteem() && getNumber_correct_answers() == exam.getNumber_correct_answers() && Objects.equals(getId(), exam.getId()) && Objects.equals(getPerson(), exam.getPerson()) && Objects.equals(getExamDate(), exam.getExamDate()) && Objects.equals(getTimeKeeping(), exam.getTimeKeeping());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPerson(), getExamDate(), getTimeKeeping(), getGrade(), getSelf_esteem(), getNumber_correct_answers());
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", person=" + person +
                ", examDate=" + examDate +
                ", timeKeeping=" + timeKeeping +
                ", grade=" + grade +
                ", self_esteem=" + self_esteem +
                ", number_correct_answers=" + number_correct_answers +
                '}';
    }

    @Override
    public int compareTo(@NotNull Exam o) {
        return (this.id - o.id) < 0 ? -1 : (this.id - o.id) > 0 ? 1 : 0;
    }
}
