CREATE TABLE usuario (
   id IDENTITY,
   code VARCHAR(10) NOT NULL,
   name VARCHAR(20) NOT NULL,
   surname VARCHAR(20) NOT NULL,
   active BOOLEAN NOT NULL
);

CREATE TABLE address (
   id IDENTITY,
   usuario_id INTEGER NOT NULL,
   address VARCHAR(100) NOT NULL,
   FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);