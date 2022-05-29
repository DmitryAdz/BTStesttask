CREATE DATABASE university
WITH 
OWNER = postgres
ENCODING = 'UTF8'
CONNECTION LIMIT = -1;
CREATE TABLE students_groups (
id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
name_group VARCHAR(20) NOT NULL
);

CREATE TABLE auditorium (
	id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	numb_auditorium INT NOT NULL
);

CREATE TABLE working_days (
	id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	working_day VARCHAR(20) NOT NULL
);

CREATE TABLE students_surnames (
	id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	surname VARCHAR(40) NOT NULL
);

CREATE TABLE students_names (
	id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name VARCHAR(40) NOT NULL
);

CREATE TABLE lectures (
	id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	lecture VARCHAR(30) NOT NULL
);

CREATE TABLE students (
	id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	id_surname INT NOT NULL,
	id_name INT NOT NULL,
	id_group INT NOT NULL,
	CONSTRAINT fk_surname 
	FOREIGN KEY (id_surname)
	REFERENCES students_surnames (id),
	CONSTRAINT fk_name 
	FOREIGN KEY (id_name)
	REFERENCES students_names (id),
	CONSTRAINT fk_group 
	FOREIGN KEY (id_group)
	REFERENCES students_groups (id)
);

CREATE TABLE timetable (
	id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	id_day INT NOT NULL,
	id_lecture INT NOT NULL,
	id_auditorium INT NOT NULL,
	id_group INT NOT NULL,
	CONSTRAINT fk_day 
	FOREIGN KEY (id_day)
	REFERENCES working_days (id),
	CONSTRAINT fk_lecture 
	FOREIGN KEY (id_lecture)
	REFERENCES lectures (id),
	CONSTRAINT fk_auditorium 
	FOREIGN KEY (id_auditorium)
	REFERENCES auditorium (id),
	CONSTRAINT fk_group
	FOREIGN KEY (id_group)
	REFERENCES students_groups (id)
);

INSERT INTO public.auditorium(numb_auditorium)	VALUES (3002);
INSERT INTO public.auditorium(numb_auditorium)	VALUES (1540);
INSERT INTO public.auditorium(numb_auditorium)	VALUES (13);

INSERT INTO public.students_groups(name_group)	VALUES ('math_300');
INSERT INTO public.students_groups(name_group)	VALUES ('prog_420');
INSERT INTO public.students_groups(name_group)	VALUES ('net_77');

INSERT INTO public.students_names(name)	VALUES ('Ivan');
INSERT INTO public.students_names(name)	VALUES ('Petya');
INSERT INTO public.students_names(name)	VALUES ('Vasya');

INSERT INTO public.students_surnames(surname) VALUES ('Ivanov');
INSERT INTO public.students_surnames(surname) VALUES ('Petrov');
INSERT INTO public.students_surnames(surname) VALUES ('Vasilev');

INSERT INTO public.lectures(lecture) VALUES ('Mathematic');
INSERT INTO public.lectures(lecture) VALUES ('Programming');
INSERT INTO public.lectures(lecture) VALUES ('Networks');

INSERT INTO public.working_days(working_day) VALUES ('Monday');
INSERT INTO public.working_days(working_day) VALUES ('Tuesday');
INSERT INTO public.working_days(working_day) VALUES ('Wednesday');

INSERT INTO public.students(id_surname, id_name, id_group)	VALUES (1, 2, 3);
INSERT INTO public.students(id_surname, id_name, id_group)	VALUES (2, 1, 2);
INSERT INTO public.students(id_surname, id_name, id_group)	VALUES (3, 3, 1);

INSERT INTO public.timetable(id_day, id_lecture, id_auditorium, id_group) VALUES (1, 2, 3, 1);
INSERT INTO public.timetable(id_day, id_lecture, id_auditorium, id_group) VALUES (2, 1, 2, 3);
INSERT INTO public.timetable(id_day, id_lecture, id_auditorium, id_group) VALUES (3, 3, 1, 2);
INSERT INTO public.timetable(id_day, id_lecture, id_auditorium, id_group) VALUES (1, 1, 2, 1);
INSERT INTO public.timetable(id_day, id_lecture, id_auditorium, id_group) VALUES (1, 3, 1, 1);
INSERT INTO public.timetable(id_day, id_lecture, id_auditorium, id_group) VALUES (1, 3, 1, 2);
INSERT INTO public.timetable(id_day, id_lecture, id_auditorium, id_group) VALUES (1, 3, 1, 3);



