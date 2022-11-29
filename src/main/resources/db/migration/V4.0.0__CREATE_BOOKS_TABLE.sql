CREATE TABLE books(
    id integer generated ALWAYS AS IDENTITY,
    name varchar(255) not null,
    author varchar(255) not null,
    date TIMESTAMP not null
)