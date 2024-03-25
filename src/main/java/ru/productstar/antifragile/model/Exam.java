package ru.productstar.antifragile.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.sql.Time;
import java.sql.Timestamp;

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
    @OneToOne
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
    int grade;

    public Exam() {
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

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", person=" + person +
                ", examDate=" + examDate +
                ", timeKeeping=" + timeKeeping +
                ", percent=" + grade +
                '}';
    }

    @Override
    public int compareTo(@NotNull Exam o) {
        return (this.id - o.id) < 0 ? -1 : (this.id - o.id) > 0 ? 1 : 0;
    }
}
