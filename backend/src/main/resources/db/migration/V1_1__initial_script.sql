create table director
(
    id         serial       not null
        constraint director_pk
            primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    birth_date date         not null
);

alter table director
    owner to postgres;

create unique index director_id_uindex
    on director (id);

create table film
(
    id           serial  not null
        constraint film_pk
            primary key,
    director_id  integer not null
        constraint film_director_id_fk
            references director,
    name         varchar(255),
    release_date date,
    genre        varchar(255)
);

alter table film
    owner to postgres;

create unique index film_id_uindex
    on film (id);

