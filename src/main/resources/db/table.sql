create table user_tb(
    id int auto_increment primary key,
    username varchar not null unique,
    password varchar not null,
    email varchar not null,
    created_at timestamp 
);

create table board_tb(
    id int auto_increment primary key,
    title varchar not null,
    userId varchar not null unique,
    created_at timestamp
);