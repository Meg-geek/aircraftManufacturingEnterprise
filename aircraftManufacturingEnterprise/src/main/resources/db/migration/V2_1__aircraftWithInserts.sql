create table if not exists company
(
    id   serial not null
        constraint company_pkey
            primary key,
    name varchar(255)
);

alter table company
    owner to postgres;

create table if not exists range
(
    id   serial not null
        constraint range_pkey
            primary key,
    name text   not null
);

alter table range
    owner to postgres;



create table if not exists equipment
(
    id       serial not null
        constraint equipment_pkey
            primary key,
    type     varchar(255),
    range_id integer
        constraint equipment_range_id_fk
            references range
            on update cascade on delete cascade
);

alter table equipment
    owner to postgres;

create table if not exists staff
(
    id      serial       not null
        constraint staff_pkey
            primary key,
    name    varchar(255) not null,
    surname varchar(255)
);

alter table staff
    owner to postgres;



create table if not exists engineering_staff
(
    id integer not null
        constraint engineering_staff_pkey
            primary key
        constraint engineering_staff_staff_id_fk
            references staff
            on update cascade on delete cascade
);

alter table engineering_staff
    owner to postgres;

create table if not exists guild_manager
(
    id integer not null
        constraint guild_manager_pkey
            primary key
        constraint guild_manager_engineering_staff_id_fk
            references engineering_staff
            on update cascade on delete cascade
);

alter table guild_manager
    owner to postgres;

create table if not exists guild
(
    id         serial  not null
        constraint guild_pkey
            primary key,
    company_id integer not null
        constraint guild_company_id_fk
            references company
            on update cascade on delete cascade,
    manager_id integer
        constraint guild_guild_manager_id_fk
            references guild_manager
            on update cascade on delete cascade,
    guild_name text    not null
);


alter table guild
    owner to postgres;


create table if not exists products
(
    id       serial not null
        constraint products_pkey
            primary key,
    guild_id integer
        constraint products_guild_id_fk
            references guild
            on update cascade on delete cascade
);

alter table products
    owner to postgres;

create table if not exists hang_glider
(
    type varchar(255),
    id   integer not null
        constraint hang_glider_pkey
            primary key
        constraint hang_glider_products_id_fk
            references products
            on update cascade on delete cascade
);

alter table hang_glider
    owner to postgres;

create table if not exists helicopter
(
    type varchar(255),
    id   integer not null
        constraint helicopter_pkey
            primary key
        constraint helicopter_products_id_fk
            references products
            on update cascade on delete cascade
);

alter table helicopter
    owner to postgres;

create table if not exists plane
(
    engine_amount integer,
    type          varchar(255),
    id            integer not null
        constraint plane_pkey
            primary key
        constraint plane_products_id_fk
            references products
            on update cascade on delete cascade
);

alter table plane
    owner to postgres;

create table if not exists range_guild
(
    range_id integer not null
        constraint range_guilds_range_id_fk
            references range
            on update cascade on delete cascade,
    guild_id integer not null
        constraint range_guilds_guild_id_fk
            references guild
            on update cascade on delete cascade
);

alter table range_guild
    owner to postgres;

create table if not exists rocket
(
    charge_power integer,
    id           integer not null
        constraint rocket_pkey
            primary key
        constraint rocket_products_id_fk
            references products
            on update cascade on delete cascade
);

alter table rocket
    owner to postgres;

create table if not exists site_manager
(
    id integer not null
        constraint site_manager_pkey
            primary key
        constraint site_manager_engineering_staff_id_fk
            references engineering_staff
            on update cascade on delete cascade
);

alter table site_manager
    owner to postgres;

create table if not exists site
(
    id              serial       not null
        constraint site_pkey
            primary key,
    work_type       varchar(255) not null,
    guild_id        integer      not null
        constraint site_guild_id_fk
            references guild,
    site_manager_id integer
        constraint site_site_manager_id_fk
            references site_manager
            on update cascade on delete cascade
);

alter table site
    owner to postgres;

create table if not exists brigade
(
    id         serial not null
        constraint brigade_pkey
            primary key,
    foreman_id integer,
    site_id    integer
        constraint brigade_site_id_fk
            references site
            on update cascade on delete cascade
);

create table if not exists worker
(
    id         integer not null
        constraint worker_pkey
            primary key
        constraint worker_staff_id_fk
            references staff
            on update cascade on delete cascade,
    brigade_id integer
        constraint worker_brigade_id_fk
            references brigade
            on update cascade on delete cascade
);
--
-- alter table brigade
--     add constraint brigade_worker_id_fk
--         foreign key (foreman_id) references worker
--             on update cascade on delete cascade;

alter table brigade
    owner to postgres;

create table if not exists engineers
(
    id      integer not null
        constraint engineers_pkey
            primary key
        constraint engineers_engineering_staff_id_fk
            references engineering_staff
            on update cascade on delete cascade,
    site_id integer
        constraint engineers_site_id_fk
            references site
            on update cascade on delete cascade
);

alter table engineers
    owner to postgres;

create table if not exists master
(
    id      integer not null
        constraint master_pkey
            primary key
        constraint master_engineering_staff_id_fk
            references engineering_staff
            on update cascade on delete cascade,
    site_id integer
        constraint master_site_id_fk
            references site
            on update cascade on delete cascade
);

alter table master
    owner to postgres;

create table if not exists tester
(
    id       integer not null
        constraint tester_pkey
            primary key
        constraint tester_staff_id_fk
            references staff
            on update cascade on delete cascade,
    range_id integer
        constraint tester_range_id_fk
            references range
            on update cascade on delete cascade
);

alter table tester
    owner to postgres;

create table if not exists test
(
    id         serial not null
        constraint test_pkey
            primary key,
    guild_id   integer
        constraint test_guild_id_fk
            references guild
            on update cascade on delete cascade,
    product_id integer
        constraint test_products_id_fk
            references products
            on update cascade on delete cascade,
    range_id   integer
        constraint test_range_id_fk
            references range
            on update cascade on delete cascade,
    tester_id  integer
        constraint test_tester_id_fk
            references tester
            on update cascade on delete cascade
);

alter table test
    owner to postgres;

create table if not exists equipment_test
(
    equipment_id integer not null
        constraint equipment_tests_equipment_id_fk
            references equipment
            on update cascade on delete cascade,
    test_id      integer not null
        constraint equipment_tests_test_id_fk
            references test
            on update cascade on delete cascade
);

alter table equipment_test
    owner to postgres;

create table if not exists worker
(
    id         integer not null
        constraint worker_pkey
            primary key
        constraint worker_staff_id_fk
            references staff
            on update cascade on delete cascade,
    brigade_id integer
        constraint worker_brigade_id_fk
            references brigade
            on update cascade on delete cascade
);

alter table worker
    owner to postgres;

create table if not exists turners
(
    id integer not null
        constraint turners_pkey
            primary key
        constraint turners_worker_id_fk
            references worker
            on update cascade on delete cascade
);

alter table turners
    owner to postgres;


create table if not exists locksmiths
(
    id integer not null
        constraint locksmiths_pkey
            primary key
        constraint locksmiths_worker_id_fk
            references worker
            on update cascade on delete cascade
);

create table if not exists welders
(
    id integer not null
        constraint welders_pkey
            primary key
        constraint welders_worker_id_fk
            references worker
            on update cascade on delete cascade
);

alter table welders
    owner to postgres;

create table if not exists pickers
(
    id integer not null
        constraint pickers_pkey
            primary key
        constraint pickers_worker_id_fk
            references worker
            on update cascade on delete cascade
);

alter table pickers
    owner to postgres;

create table if not exists stage
(
    id         serial not null
        constraint stage_pkey
            primary key,
    stage_name varchar(255)
);

alter table stage
    owner to postgres;

create table if not exists product_accounting
(
    product_id integer
        constraint product_accounting_products_id_fk
            references products
            on update cascade on delete cascade,
    stage_id   integer
        constraint product_accounting_stage_id_fk
            references stage
            on update cascade on delete cascade,
    site_id    integer
        constraint product_accounting_site_id_fk
            references site
            on update cascade on delete cascade,
    test_id    integer
        constraint product_accounting_test_id_fk
            references test
            on update cascade on delete cascade,
    begin_time date,
    end_time   date
);

alter table product_accounting
    owner to postgres;

create table if not exists technicians
(
    id      integer
        constraint technicians_engineering_staff_id_fk
            references engineering_staff
            on update cascade on delete cascade,
    site_id integer
        constraint technicians_site_id_fk
            references site
            on update cascade on delete cascade
);

alter table technicians
    owner to postgres;

insert into company (name)
values ('Авиастроители'),
       ('НСК АВИА'),
       ('Московский авиастроительный'),
       ('Предприятие Ивановых'),
       ('РосАвиаСтрой'),
       ('Ракетный завод');



INSERT INTO staff (surname, name)
VALUES ('Иванов', 'Иван'),
       ('Петров', 'Иван'),
       ('Кузнецов', 'Иван'),
       ('Александров', 'Иван'),
       ('Анисимов', 'Иван'),
       ('Фомичёв', 'Иван'),
       ('Сергеев', 'Иван'),
       ('Сорокин', 'Иван'),
       ('Тетерин', 'Иван'),
       ('Макаров', 'Иван'),
       ('Иванов', 'Петр'),
       ('Петров', 'Петр'),
       ('Кузнецов', 'Петр'),
       ('Александров', 'Петр'),
       ('Анисимов', 'Петр'),
       ('Фомичёв', 'Петр'),
       ('Сергеев', 'Петр'),
       ('Сорокин', 'Петр'),
       ('Тетерин', 'Петр'),
       ('Макаров', 'Петр'),
       ('Иванов', 'Виталий'),
       ('Петров', 'Виталий'),
       ('Кузнецов', 'Виталий'),
       ('Александров', 'Виталий'),
       ('Анисимов', 'Виталий'),
       ('Фомичёв', 'Виталий'),
       ('Сергеев', 'Виталий'),
       ('Сорокин', 'Виталий'),
       ('Тетерин', 'Виталий'),
       ('Макаров', 'Виталий'),
       ('Иванов', 'Борис'),
       ('Петров', 'Борис'),
       ('Кузнецов', 'Борис'),
       ('Александров', 'Борис'),
       ('Анисимов', 'Борис'),
       ('Кузнецов', 'Арсений'),
       ('Александров', 'Арсений'),
       ('Анисимов', 'Арсений'),
       ('Фомичёв', 'Арсений'),
       ('Сергеев', 'Арсений');


insert into engineering_staff
values (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9),
       (10),
       (36),
       (37),
       (38),
       (39),
       (40);


insert into guild_manager
values (1),
       (2),
       (3),
       (4),
       (5);

insert into guild (company_id, manager_id, guild_name)
values (1, 1, 'Конвертерный'),
       (2, 2, 'Энергоремонтный'),
       (3, 3, 'Подготовительный'),
       (4, 4, 'Покрасочный'),
       (5, 5, 'Подготовки составов');

ALTER SEQUENCE guild_id_seq RESTART WITH 6;

insert into site_manager
values (6),
       (7),
       (8),
       (9),
       (10);

insert into site (work_type, guild_id, site_manager_id)
values ('сборка', 1, 6),
       ('пайка', 2, 7),
       ('покраска', 3, 8),
       ('литье', 4, 9),
       ('штамповка', 5, 10);

ALTER SEQUENCE site_id_seq RESTART WITH 6;

insert into master
values (36, 1),
       (37, 2),
       (38, 3),
       (39, 4),
       (40, 5);

insert into engineers (id, site_id)
values (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (36, 1),
       (37, 2),
       (38, 3),
       (39, 4),
       (40, 5);

insert into technicians (id, site_id)
values (6, 1),
       (7, 2),
       (8, 3),
       (9, 4),
       (10, 5);

insert into brigade (site_id)
values (1),
       (2),
       (3),
       (4),
       (5);

insert into worker (id, brigade_id)
VALUES (11, 1),
       (12, 2),
       (13, 3),
       (14, 4),
       (15, 5);

update brigade
set foreman_id = 11
where id = 1;
update brigade
set foreman_id = 12
where id = 2;
update brigade
set foreman_id = 13
where id = 3;
update brigade
set foreman_id = 14
where id = 4;
update brigade
set foreman_id = 15
where id = 5;

insert into pickers
values (11),
       (12),
       (13),
       (14),
       (15);

insert into worker (id, brigade_id)
VALUES (16, 1),
       (17, 2),
       (18, 3),
       (19, 4),
       (20, 5);

insert into turners
values (16),
       (17),
       (18),
       (19),
       (20);

insert into worker (id, brigade_id)
VALUES (21, 1),
       (22, 2),
       (23, 3),
       (24, 4),
       (25, 5);

insert into locksmiths
values (21),
       (22),
       (23),
       (24),
       (25);

insert into worker (id, brigade_id)
VALUES (26, 1),
       (27, 2),
       (28, 3),
       (29, 4),
       (30, 5);

insert into locksmiths
values (26),
       (27),
       (28),
       (29),
       (30);

insert into range (name)
values ('Интернешнл'),
       ('Автотестирование'),
       ('Тест Пром'),
       ('Росавиа Тест'),
       ('ИспНскАвиа');

insert into tester (id, range_id)
values (31, 1),
       (32, 2),
       (33, 3),
       (34, 4),
       (35, 5);

insert into equipment (type, range_id)
VALUES ('Диагностическое', 1),
       ('Сканер', 2),
       ('Мотор-тестер', 3),
       ('Одометр', 4),
       ('ЭВМ', 5);

insert into products (guild_id)
values (1),
       (2),
       (3),
       (4),
       (5),
       (1),
       (2),
       (3),
       (4),
       (5),
       (1),
       (2),
       (3),
       (4),
       (5),
       (1),
       (2),
       (3),
       (4),
       (5);

insert into hang_glider
values ('учебный', 1),
       ('переходной', 2),
       ('прогулочный', 3),
       ('мачтовый паритель', 4),
       ('мотодельтаплан', 5);

insert into helicopter
values ('учебный', 10),
       ('боевой', 9),
       ('гражданский', 8),
       ('одновинтовой', 7),
       ('реактивный', 6);

insert into plane
values (100, 'Airbus A310', 15),
       (1000, 'ТУ-134', 14),
       (200, 'ИЛ-86', 13),
       (980, 'ИЛ-62', 12),
       (1050, 'Boeing-747', 11);

insert into rocket
values (12, 16),
       (19, 17),
       (70, 18),
       (300, 19),
       (108, 20);

insert into test (guild_id, product_id, range_id, tester_id)
VALUES (1, 1, 1, 31),
       (2, 2, 2, 32),
       (3, 3, 3, 33),
       (3, 3, 3, 34),
       (4, 4, 4, 35);

insert into equipment_test
values (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5);

insert into stage (stage_name)
values ('разработка аванпроекта'),
       ('рабочее проектирование'),
       ('создание макета'),
       ('постройка'),
       ('летные испытания');



insert into product_accounting (product_id, stage_id, site_id, test_id, begin_time, end_time)
VALUES (1, 1, 1, 1, '1970-01-01 00:00:01', '2000-01-08'),
       (2, 2, 2, 2, '2018-04-08', '2019-01-08'),
       (3, 3, 3, 3, '2003-01-08', '2005-01-08'),
       (4, 4, 4, 4, '2020-01-08', current_timestamp),
       (5, 5, 5, 5, current_timestamp, NULL);

insert into range_guild (range_id, guild_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 3),
       (4, 4);

ALTER SEQUENCE company_id_seq RESTART WITH 7;

ALTER SEQUENCE staff_id_seq RESTART WITH 41;

ALTER SEQUENCE stage_id_seq RESTART WITH 6;

ALTER SEQUENCE test_id_seq RESTART WITH 6;

ALTER SEQUENCE products_id_seq RESTART WITH 21;

ALTER SEQUENCE equipment_id_seq RESTART WITH 6;

ALTER SEQUENCE range_id_seq RESTART WITH 6;
ALTER SEQUENCE brigade_id_seq RESTART WITH 6;


