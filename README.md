# API de Gestão de Vagas

API REST em Java e Spring Boot para um sistema de Gestão de Vagas. O foco inicial do projeto é construir um serviço de cadastro de candidatos, com validações e tratamento de erros.

## Features:

* **Cadastro de Candidato:** Endpoint `POST /candidate/` para receber dados de novos candidatos (nome, username, email, senha).
* **Validação de Dados:** Utiliza `Spring Boot Validation` para garantir a integridade dos dados, checando campos como `@Email`, `@Length` (para senha) e `@Pattern` (para username).
* **Tratamento de Erros:** As exceções de validação são capturadas globalmente (`@ControllerAdvice`) e retornadas em um formato JSON mais claro para o usuário.
* **Prevenção de Duplicidade:** O sistema verifica se o `username` ou `email` já existem no banco antes de criar um novo registro, lançando uma exceção personalizada (`UserFoundException`) caso encontre duplicatas.
* **Persistência de Dados:** O novo candidato é salvo em um banco de dados **PostgreSQL** utilizando `Spring Data JPA`.

## Tecnologias Utilizadas:

O projeto foi construído com as seguintes tecnologias:

* **Java 21**
* **Spring Boot** (Spring Web, Spring Data JPA, Spring Boot Validation)
* **PostgreSQL** (Banco de dados relacional)
* **Hibernate**
* **Lombok**
* **Maven**
