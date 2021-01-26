## Before use

You need install:

```
- jdk 11 (Recomend AdoptOpenJDK)
- PostgreSQL (version 10 - 13 )
```

After installing PostgreSQL, you need to create a database `postgres` (after the first installation, this is the default
database).

## Setup Modules

#### Windows

Install Node.js [from here](https://nodejs.org/en/)

```
npm install -g @vue/cli
```

## Project setup

```
spring-boot-vuejs
├─┬ backend     → backend module with Spring Boot code
│ ├── src
│ └── pom.xml
├─┬ frontend    → frontend module with Vue.js code
│ ├── src
│ └── pom.xml
└── pom.xml     → Maven parent pom managing both modules
```

## Backend Module

[Go to](https://start.spring.io/) and initialize a Spring Boot app with `Web`, `Lombok`, `Data` and `PostgreSQL Driver`.
Place the zip’s contents in the backend folder.

Copy to the pom the code to copy the content from the Frontend for later serving with the built-in Tomcat:

```xml

<build>
    <sourceDirectory>${project.basedir}/src/main/java</sourceDirectory>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <mainClass>com.spanfish.backend.BackendApplication</mainClass>
                <excludes>
                    <exclude>
                        <groupId>org.projectlombok</groupId>
                        <artifactId>lombok</artifactId>
                    </exclude>
                </excludes>
            </configuration>
        </plugin>
        <plugin>
            <artifactId>maven-resources-plugin</artifactId>
            <executions>
                <execution>
                    <id>copy Vue.js frontend content</id>
                    <phase>generate-resources</phase>
                    <goals>
                        <goal>copy-resources</goal>
                    </goals>
                    <configuration>
                        <outputDirectory>src/main/resources/public</outputDirectory>
                        <overwrite>true</overwrite>
                        <resources>
                            <resource>
                                <directory>${project.parent.basedir}/frontend/target/dist</directory>
                                <includes>
                                    <include>static/</include>
                                    <include>index.html</include>
                                    <include>favicon.ico</include>
                                </includes>
                            </resource>
                        </resources>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

## Frontend Module

Create a `frontend` with the following command:

```
vue create frontend
```

Install with default preset.

Add the following lines to the `pom.xml`:

```xml

<build>
    <plugins>
        <plugin>
            <groupId>com.github.eirslett</groupId>
            <artifactId>frontend-maven-plugin</artifactId>
            <version>1.11.0</version>
            <executions>
                <!-- Install our node and npm version to run npm/node scripts-->
                <execution>
                    <id>install node and npm</id>
                    <goals>
                        <goal>install-node-and-npm</goal>
                    </goals>
                    <configuration>
                        <nodeVersion>v14.15.4</nodeVersion>
                    </configuration>
                </execution>
                <!-- Install all project dependencies -->
                <execution>
                    <id>npm install</id>
                    <goals>
                        <goal>npm</goal>
                    </goals>
                    <!-- optional: default phase is "generate-resources" -->
                    <phase>generate-resources</phase>
                    <!-- Optional configuration which provides for running any npm command -->
                    <configuration>
                        <arguments>install</arguments>
                    </configuration>
                </execution>
                <!-- Build and minify static files -->
                <execution>
                    <id>npm run build</id>
                    <goals>
                        <goal>npm</goal>
                    </goals>
                    <configuration>
                        <arguments>run build</arguments>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

[Info about frontend-maven-plugin](https://github.com/eirslett/frontend-maven-plugin).

## First App run

Inside the root directory, do a:

```
mvn clean install
```

Run our complete Spring Boot App:

```
mvn --projects backend spring-boot:run
```

Now go to http://localhost:8080 and have a look at your first Vue.js Spring Boot App.

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
mvnw spring-boot:run
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
