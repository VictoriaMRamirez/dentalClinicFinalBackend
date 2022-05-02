# Dental Clinic - Final - Backend I

Sistema que administra una clínica dental, la cual fue desarrollada a través de sprints. Implementa una arquitectura empresarial en capas y con inyección de dependencias.

Las capas se encuentran divididas en:
- Capa de presentación: a través de controllers usando el framework de Spring Boot MVC. Contiene una prueba desde el frontend para la vista de odontólogos en HTML y JS que permite la administración de los mismos y la invocación de APIs.
- Capa de negocio: en donde se desarrollaron las clases service con un mapeo para desacoplar el acceso a datos de la vista.
- Capa de acceso a datos con ORM: son las clases repository que se encargan de acceder a la base de datos. En este caso se utilizó la base H2 por más practicidad.
- Clases entidades de negocio: son las clases Java del sistema modelado a través del paradigma orientado a objetos.

Posee un login hecho con Spring Security, manejo de excepciones para ciertos métodos CRUD con un logueo en Log4j para su posterior ayuda en troubleshooting y testeos unitarios para mantener el correcto funcionamiento. Se utilizó JUnit y Postman especialmente para las consultas de las APIs.

## Lista de herramientas utilizadas: 
- Maven para librerías y frameworks.
- Spring Boot.
- Patrón MVC.
- Spring Data – Hibernate/JPA.
- Spring Security.
- H2 Database.
- Log4j.
- JUnit.
- Postman.
- Jackson Databind.
- ORM.
- HQL.
- Lombok.
- Excepciones.
- HTML y JS.
