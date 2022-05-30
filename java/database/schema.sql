BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE family_member (
    family_id serial NOT NULL,
    family_name varchar(50) NOT NULL,
    CONSTRAINT PK_family_member PRIMARY KEY (family_id)
);

CREATE TABLE user_family (
    user_id int NOT NULL,
    family_id int NOT NULL,
    is_Parent boolean NOT NULL,
    CONSTRAINT PK_user_family PRIMARY KEY (user_id, family_id),
    CONSTRAINT fk_user_family FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT fk_user_family_member FOREIGN KEY (family_id) REFERENCES family_member (family_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
