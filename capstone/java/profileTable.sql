


--create table account(
--account_id int not null
--user_id int not null,
--account_type_id int not null,
--);
--alter table account
--add constraint pk_profile_id
--primary key (account_id);
--add constraint fk_user_id
--foreign key (user_id) references users(user_id);
--add constraint fk_account_type_id
--foreign key (account_type_id) references account_(user_id);
--alter table account
--add constraint pk_account_userid


create table account_type(
account_type_id int not null,
account_description varchar(10) not null
);




