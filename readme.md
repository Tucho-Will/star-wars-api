## Star Wars - Api

O projeto utiliza a api publica https://swapi.dev/  sendo assim para total funcionalidade precisa possuir acesso

Api Rest que permite disponibiliza as seguintes funcionalidades:

-Adicionar um planeta
-Listar planetas do banco de dados
-Listar planetas da API do Star Wars
-Buscar por nome no banco de dados
-Buscar por ID no banco de dados
-Remover planeta


## :hammer: Tecnologias

Foi utilizado no projeto as seguintes tecnologias

- Java 8
- Spring Boot Web Flux
- Maven
- Docker
- Apache Cassandra

## Para rodar o projeto

Para rodar o banco executar

```sh
    $ docker-compose up
```

É uma aplicação Spring Boot, sendo assim basta baixar esse projeto e rodar ele na ide de sua preferencia,
ou rodar na pasta do projeto onde se encontra o arquivo pom.xml

Na pasta target execute:

java -jar star-wars-api.jar

```sh
    mvn clean install
```

Api rodando no seguinte endereço 

> http://localhost:8080/
