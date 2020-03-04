
-- Drop table

-- DROP TABLE public.endereco;

CREATE TABLE endereco (
	id bigserial NOT NULL,
	cep varchar(255) NULL,
	cidade varchar(255) NULL,
	logradouro varchar(255) NULL,
	nome varchar(255) NULL,
	rua varchar(255) NULL,
	CONSTRAINT endereco_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.cliente;

CREATE TABLE cliente (
	id bigserial NOT NULL,
	cpf varchar(255) NULL,
	data_atualizacao timestamp NULL,
	data_criacao timestamp NULL,
	data_nascimento date NULL,
	nome varchar(255) NULL,
	endereco_id int8 NULL,
	CONSTRAINT cliente_pkey PRIMARY KEY (id),
	CONSTRAINT fk64nr9yt889by5lufr1boo5i4s FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

