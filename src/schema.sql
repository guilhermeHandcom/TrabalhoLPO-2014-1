CREATE TABLE oferta (
	cod_oferta int not null CONSTRAINT PK_OFERTA PRIMARY KEY,
	nome_user varchar(50),
	cod_produto INT 
);

CREATE TABLE proposta (
	cod_proposta int not null CONSTRAINT PK_proposta PRIMARY KEY,
	nome_user VARCHAR(50),
	desejo varchar(50)

);


CREATE TABLE grupo (
	cod_grupo int not null CONSTRAINT pk_grupo PRIMARY KEY,
	titulo VARCHAR(50),
	descricao VARCHAR(80),
	fase int,
	cod_proposta INT
	
)
