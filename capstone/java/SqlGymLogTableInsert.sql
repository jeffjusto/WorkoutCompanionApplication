CREATE TABLE gym_log
(
log_id serial,
user_id varChar(50),
description varChar(1000),
img_src varChar(1000),

CONSTRAINT PK_gym_log_id PRIMARY KEY (log_id),
CONSTRAINT FK_gym_log_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);
