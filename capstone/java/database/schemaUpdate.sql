-- RUN BEFORE ALL OTHERS
INSERT INTO users (username,password_hash,role)
VALUES ('nespinosa','$2a$10$kIqYBS.PY3sYg96F0TO0zeKMhAIL46gq6cAMhc7v4GeEa95zKNSGe','ROLE_USER'),
('jjusto','$2a$10$kIqYBS.PY3sYg96F0TO0zeKMhAIL46gq6cAMhc7v4GeEa95zKNSGe','ROLE_USER'),
('sraju','$2a$10$kIqYBS.PY3sYg96F0TO0zeKMhAIL46gq6cAMhc7v4GeEa95zKNSGe','ROLE_USER'),
('cwillie','$2a$10$kIqYBS.PY3sYg96F0TO0zeKMhAIL46gq6cAMhc7v4GeEa95zKNSGe','ROLE_USER'),
('mdorismond','$2a$10$kIqYBS.PY3sYg96F0TO0zeKMhAIL46gq6cAMhc7v4GeEa95zKNSGe','ROLE_USER'),
('kbram','$2a$10$kIqYBS.PY3sYg96F0TO0zeKMhAIL46gq6cAMhc7v4GeEa95zKNSGe','ROLE_ADMIN'),
('ichow','$2a$10$kIqYBS.PY3sYg96F0TO0zeKMhAIL46gq6cAMhc7v4GeEa95zKNSGe','ROLE_USER'),
('jparker','$2a$10$kIqYBS.PY3sYg96F0TO0zeKMhAIL46gq6cAMhc7v4GeEa95zKNSGe','ROLE_USER');

--RUN AFTER PROFILE TABLE PERMISSIONS HAVE BEEN GRANTED
GRANT USAGE, SELECT ON SEQUENCE profile_profile_id_seq TO final_capstone_appuser;

BEGIN TRANSACTION;


DROP TABLE IF EXISTS profile;
DROP TABLE IF EXISTS equipment;
DROP TABLE IF EXISTS gym_log;

CREATE TABLE profile (
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


INSERT INTO profile (user_id, name, email, goals)
VALUES (1, 'Test User', 'tuser@gmail.com', 'Test it all'),
(2, 'Test Admin', 'tadmin@gmail.com', 'Admin it up'),
(3, 'Nicholas Espinosa', 'nespinosa@gmail.com', 'Get Fit'),
(4, 'Jeff Justo', 'jjusto@gmail.com', 'Get Strong'),
(5, 'Sriram Raju', 'sraju@gmail.com', 'Lose 20 lbs'),
(6, 'Caelen Willie', 'cwillie@gmail.com', 'Get Fit'),
(7, 'Madalyn Dorismond', 'mdorismond@gmail.com', 'Finish 5k'),
(8, 'Ken Bram', 'kbram@gmail.com', 'Beat Dr. Chow in wrestling'),
(9, 'Issac Chow', 'ichow@gmail.com', 'Beat Ken in wrestling'),
(10, 'Justin Parker', 'jparker@gmail.com', 'I just want all of this to be over');


CREATE TABLE equipment
(
equipment_id serial,
equipment_name varChar(50),
description varChar(1000),
img_src varChar(1000),
instruction_src varChar(1000),

CONSTRAINT PK_equipment PRIMARY KEY (equipment_id)
);


INSERT INTO equipment (equipment_name, description, img_src, instruction_src)
VALUES ('LEG PRESS HACK SQUAT MACHINE', 'The Leg Press Hack Squat Machine is the ultimate lower body strength training machine that combines leg press, hack squat, forward thrust, and calf raises.', 'https://www.titan.fitness/dw/image/v2/BDBZ_PRD/on/demandware.static/-/Sites-masterCatalog_Titan/default/dw47f28680/images/hi-res/Fitness/401486_01.jpg?sw=1001&sh=1000', 'https://www.inspireusafoundation.org/wp-content/uploads/2021/10/hack-squat-musculature.gif'),
('FUNCTIONAL TRAINER', 'Achieve a total body workout with the double stack Functional Trainer. Perform over 1,000 explosive, interactive strength training positions.', 'https://www.titan.fitness/dw/image/v2/BDBZ_PRD/on/demandware.static/-/Sites-masterCatalog_Titan/default/dw73026ce6/images/hi-res/Fitness/400883_01.jpg?sw=1001&sh=1000', 'https://www.inspireusafoundation.org/wp-content/uploads/2022/11/cable-rear-delt-row.gif'),
('LAT TOWER ', 'Take your fitness workout to the next level with the tough and dependable Lat Tower.', 'https://www.titan.fitness/dw/image/v2/BDBZ_PRD/on/demandware.static/-/Sites-masterCatalog_Titan/default/dwa129300b/images/hi-res/Fitness/400467_01.jpg?sw=1001&sh=1000', 'https://www.inspireusafoundation.org/wp-content/uploads/2022/08/wide-grip-lat-pulldown.gif'),
('TITAN SERIES POWER RACK', 'Customize your TITAN Series Power Rack with your choice in custom color options, 90 or 100-inch uprights, 36 or 42-inch depth side bracings, and J-Hook Style.', 'https://www.titan.fitness/dw/image/v2/BDBZ_PRD/on/demandware.static/-/Sites-masterCatalog_Titan/default/dwd9332b28/images/hi-res/Fitness/401302_01.jpg?sw=1001&sh=1000', 'https://www.inspireusafoundation.org/wp-content/uploads/2022/03/barbell-rack-pull.gif'),
('PREACHER CURL STATION', 'The Preacher Curl Station will drastically improve your curling form, reduce elbow stress, and target your biceps.', 'https://www.titan.fitness/dw/image/v2/BDBZ_PRD/on/demandware.static/-/Sites-masterCatalog_Titan/default/dwc4eea763/images/hi-res/Fitness/401480_01.jpg?sw=1001&sh=1000', 'https://www.inspireusafoundation.org/wp-content/uploads/2022/03/barbell-preacher-curl.gif'),
('WALL MOUNTED PULL-UP BAR', 'Mount the Ceiling Wall-Mount Pull-Up Bar at any width up to 52-inches with supplied 32 mm diameter bar.', 'https://www.titan.fitness/dw/image/v2/BDBZ_PRD/on/demandware.static/-/Sites-masterCatalog_Titan/default/dwa9833f31/images/hi-res/Fitness/400510_01.jpg?sw=1001&sh=1000', 'https://www.inspireusafoundation.org/wp-content/uploads/2022/10/pull-up.gif'),
('T-3 SERIES YOKE', 'The yoke walk is a popular strongman event that has the athlete support a yoke, loaded with lots of weight, on his or her back, and then run with it for time.', 'https://www.titan.fitness/dw/image/v2/BDBZ_PRD/on/demandware.static/-/Sites-masterCatalog_Titan/default/dwa17989a9/images/hi-res/Fitness/400253_01.jpg?sw=1001&sh=1000', 'https://www.inspireusafoundation.org/wp-content/uploads/2022/08/sled-push-muscles.gif'),
('KG CAST IRON KETTLEBELLS', 'Competition style Kettlebells.', 'https://www.titan.fitness/dw/image/v2/BDBZ_PRD/on/demandware.static/-/Sites-masterCatalog_Titan/default/dw8f87d9dc/images/hi-res/Fitness/KBCST_04.jpg?sw=1001&sh=1000', 'https://www.inspireusafoundation.org/wp-content/uploads/2021/12/how-to-kettlebell-deadlift.gif'),
('PLATE LOADED FLY MACHINE', 'The Plate-Loaded Pec Fly and Reverse Delt Machine combines two machines in one to offer a complete upper body workout.', 'https://www.titan.fitness/dw/image/v2/BDBZ_PRD/on/demandware.static/-/Sites-masterCatalog_Titan/default/dw5058b97d/images/hi-res/Fitness/401494_01.jpg?sw=1001&sh=1000', 'https://www.inspireusafoundation.org/wp-content/uploads/2022/10/reverse-pec-dec-machine.gif')


CREATE TABLE gym_log
(
log_id serial,
user_id int,
check_in timestamp,
check_out timestamp,
difference interval,
CONSTRAINT PK_gym_log_id PRIMARY KEY (log_id),
CONSTRAINT FK_gym_log_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);


INSERT INTO gym_log (user_id, check_in, check_out, difference)
VALUES (3, '2018-03-29T13:34:00.000Z', '2018-03-29T14:35:00.000Z', null),
(3, '2018-03-30T16:34:00.000Z', '2018-03-30T17:35:00.000Z', null),
(3, '2018-05-29T13:34:00.000Z', '2018-05-29T14:35:00.000Z', null),
(3, '2018-06-29T13:34:00.000Z', '2018-06-29T14:35:00.000Z', null),
(3, '2018-07-29T13:34:00.000Z', '2018-07-29T14:35:00.000Z', null),
(3, '2018-08-29T13:34:00.000Z', '2018-08-29T14:35:00.000Z', null);

UPDATE gym_log set difference = age(check_out,check_in);

CREATE TABLE IF NOT EXISTS public.equipment_log
(
entry_id SERIAL,
user_id integer,
equipment_check_in timestamp,
equipment_check_out timestamp,
equipment_time_interval integer,
equipment_id integer,
weight integer,
reps integer,

CONSTRAINT PK_equipment_log_id PRIMARY KEY (entry_id),
CONSTRAINT FK_equipment_id FOREIGN KEY (equipment_id) REFERENCES equipment (equipment_id),
CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

INSERT INTO equipment_log (user_id, equipment_id, equipment_check_in, equipment_check_out, equipment_time_interval, weight, reps)
VALUES (3, 1, '2022-12-13 09:30:00.000', '2022-12-13 10:30:00.000', 60, 100, 6),
(3, 4, '2022-12-12 08:30:00.000', '2022-12-12 9:30:00.000', 60, 100, 6),
(3, 5, '2022-12-10 09:30:00.000', '2022-12-10 11:00:00.000', 90, 250, 4),
(3, 7, '2022-12-11 09:30:00.000', '2022-12-11 10:00:00.000', 30, 200, 6),
(3, 7, '2022-12-08 09:30:00.000', '2022-12-08 10:00:00.000', 30, 195, 7),
(3, 8, '2022-12-09 10:30:00.000', '2022-12-09 11:00:00.000', 30, 100, 4),
(3, 2, '2022-12-06 09:30:00.000', '2022-12-06 10:30:00.000', 60, 200, 6),
(3, 2, '2022-12-03 10:30:00.000', '2022-12-03 11:30:00.000', 60, 300, 5);

COMMIT TRANSACTION;

--CREATE TABLE IF NOT EXISTS public."Schedule"
--(
--    event_id integer NOT NULL,
--    "eventDate" date,
--    "eventDescription" character(1) COLLATE pg_catalog."default",
--    CONSTRAINT "Schedule_pkey" PRIMARY KEY (event_id)
--)
--
--TABLESPACE pg_default;
--
--ALTER TABLE public."Schedule"
--    OWNER to postgres;
--
--    CREATE TABLE IF NOT EXISTS public.equipmentusage
--    (
--        "useEntryID" integer NOT NULL,
--        user_id integer,
--        equipment_id integer,
--        weight integer,
--        reps integer,
--        "dateUsed" date,
--        CONSTRAINT equipmentusage_pkey PRIMARY KEY ("useEntryID"),
--        CONSTRAINT equipment_id FOREIGN KEY ("useEntryID")
--            REFERENCES public."Equipment" (equipment_id) MATCH SIMPLE
--            ON UPDATE NO ACTION
--            ON DELETE NO ACTION
--            NOT VALID,
--        CONSTRAINT user_id FOREIGN KEY (user_id)
--            REFERENCES public.users (user_id) MATCH SIMPLE
--            ON UPDATE NO ACTION
--            ON DELETE NO ACTION
--    )
--
--    TABLESPACE pg_default;
--
--    ALTER TABLE public.equipmentusage
--        OWNER to postgres;
--
--CREATE TABLE IF NOT EXISTS public.goals
--(
--    goal_id integer NOT NULL,
--    user_id integer,
--    "goalDescriptors" "char",
--    CONSTRAINT goals_pkey PRIMARY KEY (goal_id),
--    CONSTRAINT user_id FOREIGN KEY (user_id)
--        REFERENCES public.users (user_id) MATCH SIMPLE
--        ON UPDATE NO ACTION
--        ON DELETE NO ACTION
--)
--
--TABLESPACE pg_default;
--
--ALTER TABLE public.goals
--    OWNER to postgres;
