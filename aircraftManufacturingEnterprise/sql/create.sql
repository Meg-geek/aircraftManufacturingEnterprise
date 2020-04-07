create table company
(
    id   serial not null
        constraint company_pkey
            primary key,
    name varchar(255)
);

create table range
(
    id integer not null
        constraint range_pkey
            primary key
);


create table equipment
(
    id       integer not null
        constraint equipment_pkey
            primary key,
    type     varchar(255),
    range_id integer
        constraint fkr3oaeegmo2jixmuyrlaub4v6
            references range
);


create table staff
(
    id      integer not null
        constraint staff_pkey
            primary key,
    name    varchar(255),
    surname varchar(255)
);



create table engineering_staff
(
    id integer not null
        constraint engineering_staff_pkey
            primary key
        constraint fkqxr4ntk72nw6r68qhxpp0u7fi
            references staff
);


create table guild_manager
(
    id integer not null
        constraint guild_manager_pkey
            primary key
        constraint fkeqkrmfy25j94cjnmftixg8efi
            references engineering_staff
);


create table guild
(
    id         serial not null
        constraint guild_pkey
            primary key,
    company_id integer
        constraint fkks2ni5t1x1pxbrugj7p7cc7k
            references company,
    manager_id integer
        constraint fkouye7wj3te2t2f1p7070itfii
            references guild_manager
);


create table products
(
    id       integer not null
        constraint products_pkey
            primary key,
    guild_id integer
        constraint fkma36stsbb5yoowiff8aq28vmi
            references guild
);


create table hang_glider
(
    type varchar(255),
    id   integer not null
        constraint hang_glider_pkey
            primary key
        constraint fkqec0ddxk5ufivrtfqa4stfjl7
            references products
);


create table helicopter
(
    type varchar(255),
    id   integer not null
        constraint helicopter_pkey
            primary key
        constraint fkkux26nqa8ejt5jhjim3s45ovp
            references products
);


create table plane
(
    engine_amount integer,
    type          varchar(255),
    id            integer not null
        constraint plane_pkey
            primary key
        constraint fkqd78ebdh040fxt9j4bv8ltxri
            references products
);


create table range_guilds
(
    range_id  integer not null
        constraint fks0atv890c2kbfl4mevs4dkyra
            references range,
    guilds_id integer not null
        constraint fk5e73lss9dr34p9scspnbshvh4
            references guild
);


create table rocket
(
    charge_power integer,
    id           integer not null
        constraint rocket_pkey
            primary key
        constraint fkq2i5uhmeypk4b8dtys6vx137q
            references products
);


create table site_manager
(
    id integer not null
        constraint site_manager_pkey
            primary key
        constraint fklu8yl1cf6si948unn7asy4ux6
            references engineering_staff
);

create table site
(
    id              integer not null
        constraint site_pkey
            primary key,
    work_type       varchar(255),
    guild_id        integer
        constraint fk4geouy8oxcg1bw7qew8ugsmcf
            references guild,
    site_manager_id integer
        constraint fk73jk6e0lfnysyhaut89ae91t1
            references site_manager
);


create table brigade
(
    id         integer not null
        constraint brigade_pkey
            primary key,
    foreman_id integer,
    site_id    integer
        constraint fkbns3318059pmtp16svoprbrsp
            references site
);


create table engineers
(
    id      integer not null
        constraint engineers_pkey
            primary key
        constraint fklkmckw37sr7jwdf70g8sexhix
            references engineering_staff,
    site_id integer
        constraint fkob1wucb77wuerxlws9qto2q13
            references site
);


create table master
(
    id      integer not null
        constraint master_pkey
            primary key
        constraint fkoodgdhqw0l99oyo141ke9cw9c
            references engineering_staff,
    site_id integer
        constraint fk89ua6x1gswig3knebxiv34dv7
            references site
);


create table tester
(
    id       integer not null
        constraint tester_pkey
            primary key
        constraint fkrr90b5hthyjps29peat6dy6vk
            references staff,
    range_id integer
        constraint fkp6i3dlix323dn1epvtaqahdfl
            references range
);


create table test
(
    id         integer not null
        constraint test_pkey
            primary key,
    guild_id   integer
        constraint fk10lar9cy9ct1f0cl6vldbnslb
            references guild,
    product_id integer
        constraint fkhivu10kwlf2hrk3sd5m3n5wrr
            references products,
    range_id   integer
        constraint fkckja7g4yys00igy0038n0ku90
            references range,
    tester_id  integer
        constraint fkeysb1pqaaao9d49mmsoc3tlnc
            references tester
);


create table equipment_tests
(
    equipment_id integer not null
        constraint fk1nx5vwgybyook20yv2ead6lvn
            references equipment,
    tests_id     integer not null
        constraint fk2aeyp7ks21q254kmhap26v3s3
            references test
);


create table test_equipment
(
    test_id      integer not null
        constraint fktqb8hv9h0u24tp0k9qejh5c6s
            references test,
    equipment_id integer not null
        constraint fk2mrnu7hyhoi2hy6bem9jcn67h
            references equipment
);


create table worker
(
    id         integer not null
        constraint worker_pkey
            primary key
        constraint fkakepsglr9e1rk611xjqt9h48q
            references staff,
    brigade_id integer
        constraint fk37ai8wwfuqi1c8cmefx5ycsw3
            references brigade
);


alter table brigade
    add constraint fk1txl75ynx7f74mi5yy0bcfcrn
        foreign key (foreman_id) references worker;

create table turners
(
    id integer not null
        constraint turners_pkey
            primary key
        constraint fkblgigqmtpyum5b9nh6jlek8f7
            references worker
);


create table welders
(
    id integer not null
        constraint welders_pkey
            primary key
        constraint fknagu37o4cv3iwqyt70hslgpnw
            references worker
);


create table pickers
(
    id integer not null
        constraint pickers_pkey
            primary key
        constraint fk95bwn7yqy35r1ija7cvwue3g5
            references worker
);


create table stage
(
    id         integer not null
        constraint stage_pkey
            primary key,
    stage_name varchar(255)
);


create table product_accounting
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


