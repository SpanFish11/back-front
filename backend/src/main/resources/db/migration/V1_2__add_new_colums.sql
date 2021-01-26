INSERT INTO public.director (first_name, last_name, birth_date)
VALUES ('Steven', 'Spielberg', '1946-12-18');
INSERT INTO public.director (first_name, last_name, birth_date)
VALUES ('Christopher', 'Nolan', '1970-07-30');
INSERT INTO public.director (first_name, last_name, birth_date)
VALUES ('Steven', 'Soderbergh', '1963-01-14');
INSERT INTO public.director (first_name, last_name, birth_date)
VALUES ('Martin', 'Scorsese', '1942-11-17');

INSERT INTO public.film (director_id, name, release_date, genre)
VALUES (1, 'Schindler''s List', '1993-11-30', 'Historical drama');
INSERT INTO public.film (director_id, name, release_date, genre)
VALUES (1, 'Ready Player One', '2018-03-11', 'Fantasy');
INSERT INTO public.film (director_id, name, release_date, genre)
VALUES (2, 'Batman Begins', '2005-05-31', 'Action');
INSERT INTO public.film (director_id, name, release_date, genre)
VALUES (4, 'The Family', '2013-09-10', 'Crime');
INSERT INTO public.film (director_id, name, release_date, genre)
VALUES (4, 'The Wolf of Wall Street', '2013-12-17', 'Biography');