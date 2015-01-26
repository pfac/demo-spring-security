create table users (
    email varchar_ignorecase(50) not null primary key,
    secret varchar_ignorecase(50) not null,
);

create table authorities (
    username varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key(username) references users(email)
);