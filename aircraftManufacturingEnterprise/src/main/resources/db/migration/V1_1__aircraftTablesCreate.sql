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
        constraint guild_engineering_staff_id_fk
            references engineering_staff
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
    type   varchar(255),
    id     integer not null
        constraint helicopter_pkey
            primary key
        constraint helicopter_products_id_fk
            references products
            on update cascade on delete cascade,
    weight integer
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
            on update cascade on delete cascade,
    type         text
);


alter table rocket
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
        constraint site_engineering_staff_id_fk
            references engineering_staff
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

alter table brigade
    add constraint brigade_worker_id_fk
        foreign key (foreman_id) references worker
            on update cascade on delete cascade;

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
