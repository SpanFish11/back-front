package com.spanfish.backend.model.responce;

import lombok.Data;

import java.util.Date;

@Data
public class FilmResponse {

  private String directorFirstName;
  private String directorLastName;
  private Date directorBirthDate;
  private String filmName;
  private Date filmReleaseDate;
  private String filmGenre;
}
