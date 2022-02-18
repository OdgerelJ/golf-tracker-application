BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS golf_courses CASCADE;
DROP TABLE IF EXISTS temp_golf_courses CASCADE;
DROP TABLE IF EXISTS scores CASCADE;
DROP TABLE IF EXISTS leagues CASCADE;
DROP TABLE IF EXISTS matches CASCADE;
DROP TABLE IF EXISTS leagues_matches CASCADE;
DROP TABLE IF EXISTS users_leagues CASCADE;
DROP TABLE IF EXISTS users_matches CASCADE;
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
	email_address varchar(50) NOT NULL,
	zipcode int,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE golf_courses (
        course_id serial,
        course_name varchar(50) NOT NULL,
        par_score int NOT NULL DEFAULT(72),
        address varchar(50) NOT NULL,
        city varchar(30) NOT NULL,
        state_name varchar(20) NOT NULL,
        zipcode int,
        lat numeric,
        lng numeric,
        CONSTRAINT pk_golf_courses PRIMARY KEY (course_id)
        
);
CREATE TABLE matches (
 match_id serial,
 match_name VARCHAR(50) NOT NULL,
 tee_time varchar(20) NOT NULL,
 PRIMARY KEY (match_id)
);

CREATE TABLE scores (
        score_id serial NOT NULL,
        user_id int NOT NULL,
        score int NOT NULL,
        course_id int NOT NULL,
        golf_date date NOT NULL,
        match_id int NOT NULL, 
        CONSTRAINT pk_scores PRIMARY KEY(score_id),
        CONSTRAINT fk_matches FOREIGN KEY (match_id) REFERENCES matches(match_id),
        CONSTRAINT fk_golf_courses FOREIGN KEY (course_id) REFERENCES golf_courses(course_id)
);

CREATE TABLE leagues(
        league_id serial,
        league_name varchar(50) NOT NULL,
        members int NOT NULL,
        course_id int NOT NULL,
        CONSTRAINT pk_leagues PRIMARY KEY (league_id)
);

CREATE TABLE temp_golf_courses (
course_id serial,
        course_name varchar(50) NOT NULL,
        address varchar(50) NOT NULL,
        city varchar(30) NOT NULL,
        state_name varchar(20) NOT NULL,
        zipcode int,
        lat numeric,
        lng numeric
        );

CREATE TABLE users_leagues (
  user_id int NOT NULL,
  league_id int NOT NULL,
  PRIMARY KEY (user_id, league_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id) ON UPDATE CASCADE,
  FOREIGN KEY (league_id) REFERENCES leagues(league_id) ON UPDATE CASCADE
);

CREATE TABLE users_matches (
  user_id int NOT NULL,
  match_id int NOT NULL,
  PRIMARY KEY (user_id, match_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id) ON UPDATE CASCADE,
  FOREIGN KEY (match_id) REFERENCES matches(match_id) ON UPDATE CASCADE
);

CREATE TABLE leagues_matches (
league_id int NOT NULL,
match_id int NOT NULL,
PRIMARY KEY (league_id, match_id),
FOREIGN KEY (league_id) REFERENCES leagues(league_id) ON UPDATE CASCADE,
FOREIGN KEY (match_id) REFERENCES matches(match_id) ON UPDATE CASCADE
);

ALTER TABLE leagues
        ADD CONSTRAINT fk_leagues FOREIGN KEY(course_id) REFERENCES golf_courses(course_id);  

INSERT INTO users (username,password_hash,role, email_address) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'user@user.com');
INSERT INTO users (username,password_hash,role, email_address) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 'admin@admin.com');
INSERT INTO matches(match_name, tee_time) VALUES ('NON LEAGUE GAME', '2022-02-08 09:00:00');  

COMMIT TRANSACTION;