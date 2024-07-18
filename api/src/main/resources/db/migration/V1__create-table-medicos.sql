create table medicos (
        id bigint not null auto_increment,
        crm varchar(100) not null,
        email varchar(100) not null unique,
        bairro varchar(100) not null,
        cep varchar(9) not null,
        cidade varchar(100) not null,
        complemento varchar(100),
        logradouro varchar(100) not null,
        numero varchar(20),
        uf varchar(2) not null,
        especialidade varchar(100) not null,
        nome varchar(100) not null,
        primary key (id)
);