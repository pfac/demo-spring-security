create table roles (
    id int primary key auto_increment,
    name varchar_ignorecase(50) not null
);

create table authorities (
    role_id int,
    attribute_value varchar_ignorecase(50),
    constraint pk_authorities primary key(role_id, attribute_value),
    constraint fk_authorities_roles foreign key(role_id) references roles(id)
);