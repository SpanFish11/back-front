package com.spanfish.backend.model.entity;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
@Entity
@Table(name = "director")
public class Director implements Serializable {

  @Serial private static final long serialVersionUID = -1417909865535655496L;

  @Id
  @GeneratedValue(strategy = AUTO)
  private Integer id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "birth_date")
  private Date birthDate;

  @OneToMany(mappedBy = "director")
  @JsonBackReference
  private List<Film> films;
}
