DROP TABLE IF EXISTS Usr CASCADE;
DROP TABLE IF EXISTS Role;
DROP TABLE IF EXISTS GivingCourses CASCADE;
DROP TABLE IF EXISTS HavingCourses CASCADE;
DROP TABLE IF EXISTS Course; 
DROP TABLE IF EXISTS Groupe;


CREATE TABLE IF NOT EXISTS Role (
	role_id		SERIAL      PRIMARY KEY,
	role_name	VARCHAR(90) NOT NULL 
);
ALTER SEQUENCE Role_role_id_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS Usr (
	username	VARCHAR(50) PRIMARY KEY,
	/* md5 => 32 byte*/
	pswrd  		VARCHAR(32)  NOT NULL,
	first_name	VARCHAR(90)  NOT NULL,
	last_name	VARCHAR(90)	 NOT NULL,
	usr_role	INTEGER NOT NULL,
	
	CONSTRAINT fk_usr_role
		FOREIGN KEY (usr_role) REFERENCES Role(role_id) 
		ON DELETE CASCADE /*quand on suprime un utilisteur on supprime cours suivis ou donné, labo...*/
);

CREATE TABLE IF NOT EXISTS Course (
	course_name	 VARCHAR(90)  PRIMARY KEY,
	credit_etcs	 INTEGER 
);

CREATE TABLE IF NOT EXISTS Groupe (
	groupe_name			VARCHAR(90)  PRIMARY KEY,
	student_per_group	INTEGER 
);

CREATE TABLE IF NOT EXISTS GivingCourses (
	prof_username	     VARCHAR(90),
	giving_course_name	 VARCHAR(90),
	
	CONSTRAINT fk_GivingCourses
		FOREIGN KEY (prof_username)      REFERENCES Usr(username),
		FOREIGN KEY (giving_course_name) REFERENCES Course(course_name)
);

CREATE TABLE IF NOT EXISTS HavingCourses (
	student_username	 VARCHAR(90),
	having_course_name	 VARCHAR(90),
	
	CONSTRAINT fk_HavingCourses
		FOREIGN KEY (student_username)   REFERENCES Usr(username),
		FOREIGN KEY (having_course_name) REFERENCES Course(course_name)
);

