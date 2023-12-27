create table tb_anfitriao(
    id int auto_increment primary key,
    nome varchar(100) not null,
    nacionalidade varchar(100)
); 

create table tb_acomodacao(
    id int auto_increment primary key,
    nome varchar(100) not null,
    localizacao varchar(100),
    numero_registro int,
    qtd_quartos_disp int,
    anfitriao_id int,
    FOREIGN KEY (anfitriao_id) REFERENCES tb_anfitriao(id)
); 

create table tb_hospede(
    id int auto_increment primary key,
    nome varchar(100) not null,
    data_registro date
); 

create table tb_reserva(
    id int auto_increment primary key,
    data_inicio date,
    data_fim date,
    acomodacao_id int,
    hospede_id int,
    FOREIGN KEY (acomodacao_id) REFERENCES tb_acomodacao(id),
    FOREIGN KEY (hospede_id) REFERENCES tb_hospede(id)
); 