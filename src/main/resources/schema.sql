create table if not exists Taco_Order(
    id              bigserial,
    delivery_Name   varchar(50)  not null,
    delivery_Street varchar(50)  not null,
    delivery_City   varchar(50)  not null,
    delivery_State  varchar(20)  not null,
    delivery_Zip    varchar(10)  not null,
    cc_number       varchar(255) not null,
    cc_expiration   varchar(5)   not null,
    cc_cvv          varchar(3)   not null,
    placed_at       timestamp    not null,
    primary key (id)
);

create table if not exists Taco(
    id            bigserial,
    name          varchar(50) not null,
    taco_order_id bigint references Taco_Order (id),
    created_at    timestamp   not null,
    primary key (id)
);

create table if not exists Ingredient_Ref(
    ingredient bigserial,
    taco       bigint     not null,
    taco_key   bigint     not null
);

create table if not exists Ingredient(
    id   bigserial,
    name varchar(25) not null,
    type varchar(10) not null,
    PRIMARY KEY (id)
);

alter table Ingredient_Ref
    add foreign key (ingredient) references Ingredient (id);

create table if not exists Taco_Ingredient(
    taco_id       bigint REFERENCES Taco(id) ON UPDATE CASCADE ON DELETE CASCADE,
    ingredient_id bigint REFERENCES Ingredient(id) ON UPDATE CASCADE,
    CONSTRAINT Taco_Ingredient_pkey PRIMARY KEY (taco_id, ingredient_id)
);

-- create table if not exists User_Taco (
--                                      id              serial NOT NULL,
--                                      username        varchar(50) not null,
--                                      password        varchar(500) not null,
--                                      fullname        varchar(50) not null,
--                                      street          varchar(50)  not null,
--                                      city            varchar(50)  not null,
--                                      state           varchar(255) not null,
--                                      zip             varchar(20)  not null,
--                                      phone_Number    varchar(20)  not null,
--                                      primary key (id)
-- );
