CREATE USER application_user;
CREATE USER application_owner;

ALTER USER application_user WITH PASSWORD 'application_user';
ALTER USER application_owner WITH PASSWORD 'application_owner';

CREATE SCHEMA test_schema;

GRANT admin TO application_owner;
