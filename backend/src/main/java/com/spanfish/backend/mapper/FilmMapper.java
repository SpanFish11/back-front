package com.spanfish.backend.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.spanfish.backend.model.entity.Film;
import com.spanfish.backend.model.responce.FilmResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface FilmMapper {

  @Mapping(target = "directorFirstName", source = "director.firstName")
  @Mapping(target = "directorLastName", source = "director.lastName")
  @Mapping(target = "directorBirthDate", source = "director.birthDate")
  @Mapping(target = "filmName", source = "name")
  @Mapping(target = "filmReleaseDate", source = "releaseDate")
  @Mapping(target = "filmGenre", source = "genre")
  FilmResponse toDto(Film film);
}
