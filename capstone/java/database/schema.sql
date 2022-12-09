DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS profile;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

create table profile(
profile_id serial,
user_id int not null,
name varchar(40),
email varchar(40),
goals varchar(50));

alter table profile
add constraint pk_profile_id 
primary key (profile_id);

alter table profile
add constraint fk_user_id
foreign key (user_id) references users(user_id);


CREATE TABLE IF NOT EXISTS public."Equipment"
(
    equipment_id integer NOT NULL,
    equipmentdescriptors "char",
    CONSTRAINT "Equipment_pkey" PRIMARY KEY (equipment_id)
)

TABLESPACE pg_default;

ALTER TABLE public."Equipment"
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public."Log"
(
    entry_id integer NOT NULL,
    user_id integer,
    "isCheckedIn" boolean,
    metrics integer,
    CONSTRAINT "Log_pkey" PRIMARY KEY (entry_id),
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public."Log"
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public."Schedule"
(
    event_id integer NOT NULL,
    "eventDate" date,
    "eventDescription" character(1) COLLATE pg_catalog."default",
    CONSTRAINT "Schedule_pkey" PRIMARY KEY (event_id)
)

TABLESPACE pg_default;

ALTER TABLE public."Schedule"
    OWNER to postgres;

    CREATE TABLE IF NOT EXISTS public.equipmentusage
    (
        "useEntryID" integer NOT NULL,
        user_id integer,
        equipment_id integer,
        weight integer,
        reps integer,
        "dateUsed" date,
        CONSTRAINT equipmentusage_pkey PRIMARY KEY ("useEntryID"),
        CONSTRAINT equipment_id FOREIGN KEY ("useEntryID")
            REFERENCES public."Equipment" (equipment_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
            NOT VALID,
        CONSTRAINT user_id FOREIGN KEY (user_id)
            REFERENCES public.users (user_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

    ALTER TABLE public.equipmentusage
        OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.goals
(
    goal_id integer NOT NULL,
    user_id integer,
    "goalDescriptors" "char",
    CONSTRAINT goals_pkey PRIMARY KEY (goal_id),
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.goals
    OWNER to postgres;
