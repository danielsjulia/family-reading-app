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
    title varchar(50) NOT NULL,
    author varchar(50) NOT NULL,
    isbn varchar(50),
    CONSTRAINT PK_book PRIMARY KEY (book_id)
);

CREATE TABLE user_book (
    book_id int NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT PK_book_log PRIMARY KEY (book_id, user_id),
    CONSTRAINT FK_book_log_id FOREIGN KEY (book_id)  REFERENCES book (book_id),
    CONSTRAINT FK_book_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE reading_log (
    readingLog_id serial NOT NULL,
    minutes int  NOT NULL,
    format varchar(50)  NOT NULL,
    date date NOT NULL ,
    starting_page int,
    end_page int,
    book_id int NOT NULL,
    user_id int NOT NULL,
    notes varchar(280),
    CONSTRAINT PK_reading_log_id PRIMARY KEY (readingLog_id),
    CONSTRAINT FK_book_reading_log_id FOREIGN KEY (book_id)  REFERENCES book (book_id),
    CONSTRAINT FK_book_reading_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE prize (
    prize_id serial NOT NULL,
    prize_name VARCHAR(50) NOT NULL,
    description VARCHAR (280) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    milestone INT NOT NULL,
    isActive boolean NOT NULL,
    numberOfWinners INT NOT NULL,
    CONSTRAINT PK_prize PRIMARY KEY (prize_id)
);

CREATE TABLE prize_user (
    prize_id INT NOT NULL,
    user_id INT NOT NULL,
    reachedGoal boolean not null,
    reachedDate date,
    CONSTRAINT pk_prize_user PRIMARY KEY (
        prize_id, user_id
    ),
    CONSTRAINT fk_prize_user_prize FOREIGN KEY (prize_id) REFERENCES prize(prize_id),
    CONSTRAINT fk_prize_user_reading_log FOREIGN KEY (user_id) REFERENCES family_member(user_id)

);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO family(family_name) VALUES('Test-Fam');

INSERT INTO family_member(user_id,family_id,is_Parent) VALUES(1,1,true);



INSERT INTO book (title, author, isbn)
VALUES('Curious George My Favorite Things', 'Rey, H. A.', '9780547428932');
INSERT INTO book (title, author, isbn)
VALUES('Dino Duckling,  Murray', 'Alison', '9780316513159');
INSERT INTO book (title, author, isbn)
VALUES('Chugga-Chugga Choo-Choo', 'Lewis, Kevin Kirk', '9780786804290');
INSERT INTO book (title, author, isbn)
VALUES('If Animals Kissed Good Night'  ,'Paul, Ann Whitford Walker' ,'9780374300210');
INSERT INTO book (title, author, isbn)
VALUES('If Animals Tried to Be Kind Paul',' Ann Whitford Walker', '9780374313425');
INSERT INTO book (title, author, isbn)
VALUES ('Kafka by the Shore','Haruki Murakami','9781400079278');
INSERT INTO book (title, author, isbn)
VALUES ('The Old Man and the Sea','Ernest Hemingway','9780684830490');

INSERT INTO user_book(user_id,book_id) VALUES (1,1);

INSERT INTO reading_log(book_id, user_id, minutes,format, date, starting_page, end_page, notes)
VALUES(1,1,30,'Paper','6-4-22',1,30,'listening');


COMMIT TRANSACTION;
