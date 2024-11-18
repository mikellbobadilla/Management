create table if not exists categories (
    id int primary key generated always as identity,
    name varchar(50) not null unique
);

create table if not exists products (
    id int primary key generated always as identity,
    name varchar(100) not null,
    description text,
    stock int not null check (stock >= 0),
    price decimal(10, 2) not null check (price >= 0),
    cost decimal(10, 2) not null check (cost >= 0)
);

create table if not exists product_category (
    category_id int,
    product_id int,
    primary key (category_id, product_id),
    foreign key (category_id) references categories on delete cascade,
    foreign key (product_id) references products,
);