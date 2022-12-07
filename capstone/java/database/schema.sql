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
