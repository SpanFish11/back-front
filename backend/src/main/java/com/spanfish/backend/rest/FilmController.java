package com.spanfish.backend.rest;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spanfish.backend.model.request.Filter;
import com.spanfish.backend.model.responce.FilmResponse;
import com.spanfish.backend.service.FilmService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/films")
public class FilmController {

  private final FilmService filmService;

  @GetMapping
  public ResponseEntity<List<FilmResponse>> findFilms(final Filter filter) {
    return ok(filmService.findFilms(filter));
  }
}
