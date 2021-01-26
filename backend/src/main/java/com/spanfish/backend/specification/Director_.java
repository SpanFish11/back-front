package com.spanfish.backend.specification;

import com.spanfish.backend.model.entity.Director;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Director.class)
public abstract class Director_ {

  public static volatile SingularAttribute<Director, Integer> id;
  public static volatile SingularAttribute<Director, String> firstName;
  public static volatile SingularAttribute<Director, String> lastName;
  public static volatile SingularAttribute<Director, Date> birthDate;

  public static final String ID = "id";
  public static final String FIRST_NAME = "firstName";
  public static final String LAST_NAME = "lastName";
  public static final String BIRTHDAY = "birthDate";
}
