package com.spanfish.backend.service;

import java.util.List;
import com.spanfish.backend.model.request.Filter;
import com.spanfish.backend.model.responce.FilmResponse;

public interface FilmService {

  List<FilmResponse> findFilms(Filter filter);
}
