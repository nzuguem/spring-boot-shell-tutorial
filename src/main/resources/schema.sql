DROP TABLE IF EXISTS fruit;

CREATE TABLE fruit (
  id varchar(255) NOT NULL,
  name varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (id)
);