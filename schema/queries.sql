create table if not exists categories (
    id int primary key generated always as identity,
    name varchar(50) not null unique,
    parent_id int,
    foreign key (parent_id) references categories (id)
);

create table if not exists products (
    id int primary key generated always as identity,
    name varchar(100) not null,
    description text,
    stock int not null check (stock >= 0),
    price decimal(10, 2) not null check (price >= 0),
    cost decimal(10, 2) not null check (cost >= 0),
    category_id int not null,
    foreign key (category_id) references categories (id)
);