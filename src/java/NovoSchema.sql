CREATE TABLE oferta(
    id int not null GENERATED ALWAYS AS IDENTITY primary key ,
    titulo varchar(50) not null,
    descricao varchar(150) not null,
    ofertante varchar(20) not null,
    grupo varchar(15) not null
);

CREATE TABLE proposta(
    id int not null GENERATED ALWAYS AS IDENTITY primary key ,
    ofertante varchar(20) not null,
    desejo varchar(50) not null,
    oferta varchar(50) not null
)