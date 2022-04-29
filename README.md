# Dental Clinic - Final - Backend I

Sistema desarrollado a través de sprints que implementa una arquitectura empresarial en capas y con inyección de dependencias. El sistema administra una clínica dental en la cual podemos encontrar pacientes, odontólogos y turnos.

Las capas se encuentran divididas en:
- Capa de presentación: a través de controllers usando el framework de Spring Boot MVC. Tiene una pequeña prueba de la vista de odontólogos con HTML y JS donde se realiza una invocación de APIs con JS.
- Capa de negocio: en donde se desarrollaron las clases service con un mapeo para desacoplar el acceso a datos de la vista.
- Capa de acceso a datos con ORM: son las clases repository que se encargan de acceder a la base de datos. En este caso se utilizó la base H2 por más practicidad.
- Clases entidades de negocio: son las clases Java del sistema modelado a través del paradigma orientado a objetos.

También se puede encontrar un login hecho con Spring Security, manejo de excepciones para ciertos métodos CRUD con un logueo en Log4j por troubleshooting y testeos unitarios con JUnit. Se utilizó Postman para las consultas de las APIs.

## Lista de herramientas utilizadas: 
- Maven para librerías y frameworks.
- Spring Boot.
- Patrón MVC.
- Spring Data – Hibernate.
- Spring Security.
- H2 Database.
- Log4j.
- JUnit.
- Postman.
- Jackson Databind.
- ORM.
- HQL.
- JPA Repository.
- Lombok.
- Excepciones.
- HTML y JS.
