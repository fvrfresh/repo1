drop table if exists  article;
create table if not exists article
(
	id int auto_increment,
	title varchar(255) not null,
	content text null not  null ,
	createdAt timestamp not null,
	htmlString text,
	category varchar (255) not null,
	description varchar(255) not null,
	constraint article_pk
		primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create unique index article_title_uindex
	on article (title);
drop table comments;

create table if not exists comments
(
	id int auto_increment,
	username varchar(255) not null,
	content text not null,
	email varchar(255) null not  null ,
	website varchar (255) not null,
	articleTitle varchar (255) not null,
	replying varchar (255),
	createdAt timestamp not null,
	constraint article_pk
		primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


alter table comments change mail email varchar(255) not null ;
desc comments;

drop table users;
create table if not exists users
(
    id int auto_increment,
    username varchar(255) not null,
    email varchar(255) null not  null ,
    website varchar (255) not null,
    constraint article_pk
        primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create unique index users_username_uindex
    on users (username);

alter table comments
drop column website;

insert into users(username, email, website) select distinct username, comments.email,website from comments;

select * from comments