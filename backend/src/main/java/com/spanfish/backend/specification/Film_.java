package com.spanfish.backend.specification;

import com.spanfish.backend.model.entity.Director;
import com.spanfish.backend.model.entity.Film;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Film.class)
public abstract class Film_ {

  public static volatile SingularAttribute<Film, Integer> id;
  public static volatile SingularAttribute<Film, String> name;
  public static volatile SingularAttribute<Film, Date> releaseDate;
  public static volatile SingularAttribute<Film, String> genre;
  public static volatile SingularAttribute<Film, Director> director;

  public static final String ID = "id";
  public static final String NAME = "name";
  public static final String RELEASE_DATE = "releaseDate";
  public static final String DIRECTOR = "director";
}
