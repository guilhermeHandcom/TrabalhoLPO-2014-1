CREATE TABLE oferta (
	cod_oferta int not null generated always AS identity,
        nome_oferta VARCHAR(80),
	nome_usuario varchar(80),
	nome_produto VARCHAR(80),
        desejo VARCHAR(80)
);

CREATE TABLE proposta (
	cod_proposta int not null generated always as identity,
	nome_user VARCHAR(50),
	desejo varchar(50)

);


CREATE TABLE grupo (
	cod_grupo int not null generated always as identity,
	titulo VARCHAR(50),
	descricao VARCHAR(80),
	fase int
	
)
select * from grupo
