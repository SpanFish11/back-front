## Before use

You need install:

```
- jdk 17
- PostgreSQL (Recomend 13)
- Node.js
```

After installing PostgreSQL, you need to create a database `postgres` (after the first installation, this is the default
database).

## First App run

Inside the root directory, do a:

```
mvn clean install
```

Run our complete Spring Boot App:

```
mvn --projects backend spring-boot:run
```

Now go to http://localhost:8080

## Run Frontend Module

Inside the root directory, do a:

```
cd frontend
npm run serve
```

## Run Backend Module

Inside the root directory, do a:

```
mvn --projects backend spring-boot:run
```

Go to http://localhost:8080/swagger-ui/index.html#/ or use `postman`.

Use HTTP GET method to endpoint http://localhost:8080/api/v1/films

This endpoint supports the following query params:

```
dir - to search for films by names of directors (string)
from - to search for films by release year. Release year <= films  (numbers)
until - to search for films by release year. Release year >= films (numbers)
```

You can combine these parameters.

## Запуск приложения без frontend модуля

Для запуска модуля потребуется установленные программы из раздела `Before use`. 
Внутри корневого каталога выполните:

```
mvn spring-boot:run
```

Затем после успешного старта приложения можно использовать http://localhost:8080/swagger-ui/index.html#/ или `postman`.

Для получения спика фильмов требуется отправить гет запрос на следующий эндпоинт:

```
http://localhost:8080/api/v1/films
```

Данный эндпоинт поддерживает следующие параметры запроса:

`dir` - для поиска фильмов по фамилии режиссера. Возможет поиск по отдельным комбинациям букв `sp` или `o`.

`from` - для поиска фильмов по году выпуска. Происходит поиск фильмов выпущенных после этого (включительно) года.

`until` - для поиска фильмов по году выпуска. Происходит поиск фильмов выпущенных до данного года (включительно).

Данные параметры можно комбинировать.

## Запуск приложения с frontend модулем

Для запуска приложения потребуется установленные программы из раздела `Before use`. 
Внутри корневого каталога выполните:

```
mvn clean install
mvn --projects backend spring-boot:run
```

Приложение готово для использования.
После успешного запуска требуется перейти http://localhost:8080.


P.S.: Прощу прощения за сумбурное описание и странную форму поставки приложения. Код приложения достуен по адресу https://github.com/SpanFish11/back-front.git
