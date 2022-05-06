# Dental Clinic - Final Project - Backend I

The system administers a dental clinic that implements a business architecture in layers with dependency injections.

Layers are divided in:
- Presentation layer: through controllers using Spring Boot MVC framework. It contains a small part of frontend to test the view of dentists that allows APIs’ invocation for their administration.
- Business layer: where the service classes were developed with a mapping to decouple data access from the view.
- ORM data access layer: are the repository classes that are responsible for accessing the database. In this case, it was used H2 Database for more practicality.
- Business feature classes: are the Java classes of the system modelled through object-oriented paradigm.

The system possesses a login done with Spring Security, exceptions’ handling for certain CRUD methods with a logging messages thanks to Log4j for posterior help in troubleshooting and unit tests to keep the correct functioning of the software. Junit and Postman were the chosen tools for testing.

## Login:
- URL: localhost8081/login.
- Username: victoria.
- Password: victoria.

### List of used tools: 
- Maven for libraries and frameworks.
- Spring Boot | Spring Data – Hibernate/JPA | Spring Security.
- MVC Pattern.
- H2 Database.
- Log4j.
- JUnit | Postman.
- Jackson Databind.
- ORM.
- HQL.
- Exceptions
- HTML | JS.

### ESPAÑOL

# Clínica Dental - Proyecto Final - Backend I

Sistema que administra una clínica dental, la cual fue desarrollada a través de sprints. Implementa una arquitectura empresarial en capas y con inyección de dependencias.

Las capas se encuentran divididas en:
- Capa de presentación: a través de controllers usando el framework de Spring Boot MVC. Contiene una prueba desde el frontend para la vista de odontólogos en HTML y JS que permite la administración de los mismos y la invocación de APIs.
- Capa de negocio: en donde se desarrollaron las clases service con un mapeo para desacoplar el acceso a datos de la vista.
- Capa de acceso a datos con ORM: son las clases repository que se encargan de acceder a la base de datos. En este caso se utilizó la base H2 por más practicidad.
- Clases entidades de negocio: son las clases Java del sistema modelado a través del paradigma orientado a objetos.

Posee un login hecho con Spring Security, manejo de excepciones para ciertos métodos CRUD con un logueo en Log4j para su posterior ayuda en troubleshooting y testeos unitarios para mantener el correcto funcionamiento. Se utilizó JUnit y Postman especialmente para las consultas de las APIs.

## Acceso:
- URL: localhost8081/login.
- Usuario: victoria.
- Contraseña: victoria.

### Lista de herramientas utilizadas: 
- Maven para librerías y frameworks.
- Spring Boot | Spring Data – Hibernate/JPA | Spring Security.
- Patrón MVC.
- H2 Database.
- Log4j.
- JUnit | Postman.
- Jackson Databind.
- ORM.
- HQL.
- Exceptions
- HTML | JS.
