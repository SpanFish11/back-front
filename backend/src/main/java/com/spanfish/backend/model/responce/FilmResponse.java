package com.spanfish.backend.model.responce;

import java.util.Date;
import lombok.Data;

@Data
public class FilmResponse {

  private String directorFirstName;
  private String directorLastName;
  private Date directorBirthDate;
  private String filmName;
  private Date filmReleaseDate;
  private String filmGenre;
}
