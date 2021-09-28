package com.spanfish.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.spanfish.backend.model.entity.Film;

public interface FilmRepository
    extends JpaRepository<Film, Integer>, JpaSpecificationExecutor<Film> {}
