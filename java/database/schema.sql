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

CREATE TABLE family (
    family_id serial NOT NULL,
    family_name varchar(50) unique NOT NULL,
    CONSTRAINT PK_family PRIMARY KEY (family_id)
);

CREATE TABLE family_member (
    user_id int NOT NULL,
    family_id int NOT NULL,
    is_Parent boolean NOT NULL,
    CONSTRAINT PK_family_member PRIMARY KEY (user_id),
    CONSTRAINT FK_family_member_user FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT FK_family_member_family FOREIGN KEY (family_id) REFERENCES family (family_id)
);

CREATE TABLE book (
    book_id serial NOT NULL,
    title varchar(50)  NOT NULL,
    author varchar(50)  NOT NULL,
    isbn varchar(50) ,
    format varchar(50)  NOT NULL,
    CONSTRAINT PK_book PRIMARY KEY (book_id)
);

CREATE TABLE user_book (
    book_id int NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT FK_book_log_id FOREIGN KEY (book_id)  REFERENCES book (book_id),
    CONSTRAINT FK_book_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE reading_log (
    readingLog_id serial NOT NULL,
    minutes int  NOT NULL,
    read_aloud varchar(50)  NOT NULL,
    date date NOT NULL ,
    starting_page int  NOT NULL,
    end_page int  NOT NULL,
    book_id int NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT PK_reading_log_id PRIMARY KEY (readingLog_id),
    CONSTRAINT FK_book_reading_log_id FOREIGN KEY (book_id)  REFERENCES book (book_id),
    CONSTRAINT FK_book_reading_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
