create schema controle_acesso;
create schema deployer;

create table controle_acesso.usuario(
	id bigserial not null primary key,
	nome varchar (100) not null,
	login varchar (50)  not null,
	senha varchar (200)  not null,
	dt_cadastro timestamp without time zone,
	fk_usuario_cadastro bigint references controle_acesso.usuario(id)
);

create table deployer.servidor(
	id bigserial not null primary key,
	nome varchar (100) not null,
	label varchar (20),
	url text not null,
	dt_cadastro timestamp without time zone,
	fk_usuario_cadastro bigint references controle_acesso.usuario(id)
);

create table deployer.aplicacao(
	id bigserial not null primary key,
	caminho_contexto varchar (30) not null,
	dt_cadastro timestamp without time zone,
	fk_usuario_cadastro bigint references controle_acesso.usuario(id),
	fk_servidor bigint references goploy.servidor(id),
	fk_servlet_container bigint references goploy.servlet_container(id)
);

create table deployer.servlet_container(
	id bigserial not null primary key,
	nome varchar (100) not null,
	label varchar (20) not null,
	usuario varchar (50)  not null,
	senha varchar (200)  not null,
	dt_cadastro timestamp without time zone,
	fk_servidor bigint references goploy.servidor(id),
	fk_usuario_cadastro bigint references controle_acesso.usuario(id)
);
