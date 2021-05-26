CREATE TABLE address (
   id IDENTITY,
   address VARCHAR(100) NOT NULL
);

CREATE TABLE usuario (
   id IDENTITY,
   code VARCHAR(10) NOT NULL,
   name VARCHAR(20) NOT NULL,
   surname VARCHAR(20) NOT NULL,
   active BOOLEAN NOT NULL,
   address_id INTEGER NOT NULL,
   FOREIGN KEY (address_id) REFERENCES address(id)
);