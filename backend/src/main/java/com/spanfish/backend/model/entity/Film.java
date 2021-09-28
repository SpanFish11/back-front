package com.spanfish.backend.model.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
@Entity
@Table(name = "film")
public class Film implements Serializable {

  @Serial private static final long serialVersionUID = 3326721008311381027L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "release_date")
  private Date releaseDate;

  @Column(name = "genre")
  private String genre;

  @ManyToOne
  @JoinColumn(name = "director_id")
  @JsonManagedReference
  private Director director;
}
