create table users(
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(50) not null,
    enabled boolean not null
);

create table authorities (
    username varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);

create table custom_users(
    email varchar_ignorecase(50) not null primary key,
    secret varchar_ignorecase(50) not null,
);

create table custom_roles (
    email varchar_ignorecase(50) not null,
    role varchar_ignorecase(50) not null,
    constraint fk_authorities_custom_users foreign key(email) references custom_users(email)
);