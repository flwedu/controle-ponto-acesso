# controle-ponto-acesso

Projeto de um sistema de controle de ponto e acesso com Spring Boot criado para o **Santander Bootcamp | Fullstack Developer**, em parceria com a [Digital Innovation One](https://web.digitalinnovation.onelink) em 2021.

## Finalidades

Projeto utilizado para demonstrar o uso de ferramentas para facilitar a construção de uma API Rest.

O projeto utiliza um banco de dados simples H2 em memória, que deve ser configurado no `spring.datasource.url` dentro do arquivo `src/main/resources/application.properties`.

Por padrão, está configurado para rodar em [http://localhost:8081/](http://localhost:8081), mas a porta também pode ser alterada no arquivo `application.properties` citado anteriormente.

## Ferramentas utilizadas para construção do projeto

- **Java SDK 11**;
- **Spring Boot**;
- **Gradle** para gestão de dependências;
- **Hibernate Envers** para auditoria;
- **Lombok** para reduzir a quantidade de código digitado;
- **Swagger** para documentar os endpoints.
