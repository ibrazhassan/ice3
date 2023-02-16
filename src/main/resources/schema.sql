CREATE TABLE student (
     id LONG PRIMARY KEY AUTO_INCREMENT,
     first_name VARCHAR(30),
     last_name VARCHAR(30),
     program_name VARCHAR(30),
     program_year INTEGER,
     program_coop BOOLEAN,
     program_internship BOOLEAN
);
