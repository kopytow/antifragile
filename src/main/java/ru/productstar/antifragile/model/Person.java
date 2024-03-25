package ru.productstar.antifragile.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Запись о студенте.
 * Created by Bazil Kopytow 21.03.2024 21:15
 */
@Entity
@Table(name = "persons")
public class Person implements Comparable<Person> {

    /**
     * Идентификатор, первичный ключ.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Аутентификация пользователя.
     */
    @OneToOne
    @JoinColumn(name = "users_pkey")
    private User user;

    /**
     * Имя.
     */
    @Column(nullable = false, length = 64)
    private String firstName;

    /**
     * Фамилия.
     */
    @Column(nullable = false, length = 64)
    private String lastName;

    /**
     * Номер елефона.
     */
    @Column(nullable = false, length = 50)
    private String phone;

    /**
     * Прозвище.
     */
    @Column(nullable = false, length = 64)
    private String nickname;

    /**
     * Personal Data Processing Consent - согласие на обработку персональных данных.
     */
    private boolean personalDataProcessingConsent;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isPersonalDataProcessingConsent() {
        return personalDataProcessingConsent;
    }

    public void setPersonalDataProcessingConsent(boolean personalDataProcessingConsent) {
        this.personalDataProcessingConsent = personalDataProcessingConsent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return isPersonalDataProcessingConsent() == person.isPersonalDataProcessingConsent() && Objects.equals(getId(), person.getId()) && Objects.equals(getUser(), person.getUser()) && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getPhone(), person.getPhone()) && Objects.equals(getNickname(), person.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getFirstName(), getLastName(), getPhone(), getNickname(), isPersonalDataProcessingConsent());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", user=" + user +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", personalDataProcessingConsent=" + personalDataProcessingConsent +
                '}';
    }

    @Override
    public int compareTo(@NotNull Person o) {
        return (this.id - o.id) < 0 ? -1 : (this.id - o.id) > 0 ? 1 : 0;
    }
}
