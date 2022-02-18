--This file populates leagues , users_leagues table 
--and SELECT statement for displaying league information



----Insert data into leagues
INSERT INTO leagues (league_name, members, course_id)
VALUES ('Fantastic 4', 4, 1);

INSERT INTO leagues (league_name, members, course_id)
VALUES ('Fantastic 3', 3, 2);
----Insert data into users- Used front end to create four players


-----Insert data into users_leagues
INSERT INTO users_leagues (user_id, league_id)
VALUES (3,1);
INSERT INTO users_leagues (user_id, league_id)
VALUES (4,1);
INSERT INTO users_leagues (user_id, league_id)
VALUES (5,1);
INSERT INTO users_leagues (user_id, league_id)
VALUES (6,1);


INSERT INTO users_leagues (user_id, league_id)
VALUES (3,2);
INSERT INTO users_leagues (user_id, league_id)
VALUES (4,2);
INSERT INTO users_leagues (user_id, league_id)
VALUES (5,2);



-----SELECT league_name , members, course_name, users.username |||||golf_courses.course_name,
SELECT league_name , members, users.username, golf_courses.course_name FROM leagues JOIN users_leagues ON leagues.league_id = users_leagues.league_id JOIN users ON users_leagues.user_id = users.user_id JOIN golf_courses ON leagues.league_id = golf_courses.course_id WHERE leagues.league_id = ?;





