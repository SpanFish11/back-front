package com.spanfish.backend.repository;

import com.spanfish.backend.model.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FilmRepository
    extends JpaRepository<Film, Integer>, JpaSpecificationExecutor<Film> {}
