package ru.productstar.antifragile.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.productstar.antifragile.model.Exam;
import ru.productstar.antifragile.model.Person;
import ru.productstar.antifragile.model.Rating;
import ru.productstar.antifragile.repositories.ExamRepository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Обработчик методов http
 * Created by Bazil Kopytow 19.03.2024 21:12
 */
@Controller
public class WebController {
    @Autowired
    private ExamRepository repository;
    @GetMapping({"/", "/home", "/greetings"})
    public String index(Model model) {
        model.addAllAttributes(java.util.Map.of("ratings", getRating()));
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    private Object[] getRating() {
        var examList = repository.findAll();
        var persons = examList.stream().map(Exam::getPerson).collect(Collectors.toCollection(ArrayList::new));
        var ratings = new ArrayList<Rating>();
        for (Person person : persons) {
            var grade = 0;
            for (Exam exam : examList)
                if (person.equals(exam.getPerson()) && grade < exam.getGrade())
                    grade = exam.getGrade();
            ratings.add(new Rating(person.getNickname(), grade));
        }
        ratings.sort(Comparator.comparingInt(Rating::percent).reversed());
        return ratings.toArray();
    }
}
