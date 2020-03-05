# Tecnologias
 - Spring
 - Spring Data
 - REST
 - PostgreSQL
 - Docker
 - Flyway
 - JUnit
 - Swagger
 - Postman

# Passo a passo para executar o projeto

1. Baixe as dependências do projeto:

```sh
	mvn install
```

2. Iniciando o Banco de dados com o docker
docker run --name zup-postgres-db -p 5432:5432 -e POSTGRES_DB=postgres-zup-challenge -e POSTGRES_PASSWORD=zup@123 -d postgres

3. Iniciar a aplicação
```sh
	mvn spring-boot:run
```

## Outras considerações

 - Ao iniciar a aplicação, o spring irá rodar as migrations do flyway em `src/main/resources/db/migrations` para criar as tabelas
 - Quando a aplicação subir, será possível acessar a documentação das APIS no swagger em http://localhost:8080/swagger-ui.html.
 - O arquivo com as collections do postman se encontra em : `src/main/resources/ZupChallenge.postman_collection.json`
