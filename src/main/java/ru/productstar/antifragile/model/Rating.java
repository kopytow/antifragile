package ru.productstar.antifragile.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Рейтинг [прозвище,оценка]
 * Created by User 22.03.2024
 **/
public final class Rating {

    /**
     * Прозвище.
     */
    @JsonProperty
    private String nickname;
    /**
     * Оценка.
     */
    @JsonProperty
    private int grade;

    /**
     * Создаёт объект, инициализируя значениями.
     *
     * @param nickname прозвище
     * @param grade    оценка
     */
    @JsonCreator
    public Rating(@JsonProperty("nickname") String nickname, @JsonProperty("grade") int grade) {
        this.nickname = nickname;
        this.grade = grade;
    }

    public String nickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int grade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Rating) obj;
        return Objects.equals(this.nickname, that.nickname) &&
                this.grade == that.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, grade);
    }

    @Override
    public String toString() {
        return "Rating[" +
                "nickname=" + nickname + ", " +
                "percent=" + grade + ']';
    }

}
