package com.spanfish.backend.mapper;

import com.spanfish.backend.model.entity.Film;
import com.spanfish.backend.model.responce.FilmResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmMapper {

  @Mappings({
    @Mapping(target = "directorFirstName", source = "director.firstName"),
    @Mapping(target = "directorLastName", source = "director.lastName"),
    @Mapping(target = "directorBirthDate", source = "director.birthDate"),
    @Mapping(target = "filmName", source = "name"),
    @Mapping(target = "filmReleaseDate", source = "releaseDate"),
    @Mapping(target = "filmGenre", source = "genre")
  })
  FilmResponse toDto(Film film);

  List<FilmResponse> toList(List<Film> films);
}
