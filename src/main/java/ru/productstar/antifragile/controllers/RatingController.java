package ru.productstar.antifragile.controllers;

import org.springframework.web.bind.annotation.*;
import ru.productstar.antifragile.model.PersonalCard;
import ru.productstar.antifragile.model.Rating;
import ru.productstar.antifragile.services.RatingService;

import java.util.Collection;

/**
 * Обработчик методов http
 * Created by Bazil Kopytow 19.03.2024 21:12
 */
@RestController
public class RatingController {
    /**
     * Репозиторий оценок.
     */
    private final RatingService service;

    public RatingController(RatingService service) {
        this.service = service;
    }

    @GetMapping("/ratings")
    public Collection<Rating> ratings(@RequestParam(defaultValue = "5") Integer limit) {
        return service.getTopRating(limit);
    }

    @GetMapping("/ratings/card/{id}")
    public PersonalCard getPersonalCard(@PathVariable int id) {
        return service.getPersonalCardByPersonId(id);
    }

    @PostMapping("/ratings")
    public PersonalCard create(@RequestBody PersonalCard card) {
        return service.createPersonalCard(card);
    }
}
