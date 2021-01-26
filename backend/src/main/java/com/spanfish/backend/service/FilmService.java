package com.spanfish.backend.service;


import com.spanfish.backend.model.entity.Film;
import com.spanfish.backend.model.request.Filter;

import java.util.List;

public interface FilmService {

  List<Film> findFilms(Filter filter);
}
