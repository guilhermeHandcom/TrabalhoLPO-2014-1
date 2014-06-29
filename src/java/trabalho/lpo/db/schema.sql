
CREATE TABLE grupo (
    cod_grupo int not null generated always as identity primary key,
    titulo VARCHAR(50),
    descricao VARCHAR(80),
    fase int
    
);

    CREATE TABLE oferta (
        cod_oferta int not null generated always AS identity primary key,
             nome_oferta VARCHAR(80),
         nome_usuario varchar(80),
         nome_produto VARCHAR(80),
            cod_grupob int,
            constraint fk_oferta foreign key (cod_grupob) references grupo(cod_grupo)
     );
     
     CREATE TABLE proposta (
         cod_proposta int not null generated always as identity,
         nome_user VARCHAR(50),
        desejo varchar(50),
            cod_ofertaa int, 
            cod_ofertab int,
            cod_grupoa int,
    constraint fk_proposta foreign key (cod_ofertaa) references oferta(cod_oferta),
    constraint fk_propostaa foreign key (cod_grupoa) references grupo(cod_grupo)
     
     );

select * from grupo
