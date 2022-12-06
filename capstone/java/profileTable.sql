create table profile(
profileID serial,
userID int not null,
name varchar(40) not null,
email varchar(40) not null,
goals varchar(50) not null,

constraint uq_profileID unique(profileID)
);


