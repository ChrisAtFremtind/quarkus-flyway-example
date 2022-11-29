# test-flyaway Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Running the application
Requires a connection to the provided database setup located at `/main/docker/docker-compose.yml`.
The docker-compose script runs a initial data sql script located in the same folder which creates two users, a schema and grants admin access for the applicaiton_owner user.

To run the docker-compose: 
```shell
docker-compose -f ./src/main/docker/docker-compose.yml up -d
```

## Endpoints

`api/user` - prints the user which inserted the initial data into the `testTable` table.
`api/book`- lists all books.
`api/book/{id}` - returns book with specific id.

## Related Guides

- Flyway ([guide](https://quarkus.io/guides/flyway)): Handle your database schema migrations
- JDBC Driver - H2 ([guide](https://quarkus.io/guides/datasource)): Connect to the H2 database via JDBC
- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A JAX-RS implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Agroal - Database connection pool ([guide](https://quarkus.io/guides/datasource)): Pool JDBC database connections (included in Hibernate ORM)
