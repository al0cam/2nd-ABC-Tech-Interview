create table if not exists racun (
    racun_id integer primary key,
    iban varchar(20),
    tip_racuna integer,
    valuta varchar(3),
    klijent_id integer,
    datum_otvaranja date,
    datum_zatvaranja date
);

-- For some reason the @GeneratedValue annotation doesn't work;
-- I have to manually create the sequence and set the value of the primary key
-- all rights were granted to the user so there shouln't be any issue with that and 
-- the annotations were used correctly which leaves the bug to be random or a lack of understanding
create sequence if not exists racun_seq start 4 increment 1;

-- For some reason the following inserts don't work in the dockerized psql; on the regular psql they work fine
-- insert into racun values(1,'HR3455345442',1,'USD',1,'21.12.2012','16.3.2020');
-- insert into racun values(2,'DE3232366551',1,'EUR',2,'15.6.2001',NULL);
-- insert into racun values(3,'HR2134666632',2,'EUR',1,'17.3.2020',NULL);

-- insert into racun values(1,'HR3455345442',1,'HRK',1,to_date('21.12.2012','dd.mm.yyyy'),to_date('16.3.2020','dd.mm.yyyy')) ON CONFLICT DO NOTHING;
-- insert into racun values(2,'DE3232366551',1,'EUR',2,to_date('15.6.2001','dd.mm.yyyy'),NULL) ON CONFLICT DO NOTHING;
-- insert into racun values(3,'HR2134666632',2,'EUR',1,to_date('17.3.2020','dd.mm.yyyy'),NULL) ON CONFLICT DO NOTHING;

insert into racun values(1,'HR3455345442',1,'HRK',1,to_date('21.12.2012','dd.mm.yyyy'),to_date('16.3.2020','dd.mm.yyyy')) ON CONFLICT DO NOTHING;
insert into racun values(2,'DE3232366551',1,'EUR',2,to_date('15.6.2001','dd.mm.yyyy'),NULL) ON CONFLICT DO NOTHING;
insert into racun values(3,'HR2134666632',2,'EUR',1,to_date('17.3.2020','dd.mm.yyyy'),NULL) ON CONFLICT DO NOTHING;
