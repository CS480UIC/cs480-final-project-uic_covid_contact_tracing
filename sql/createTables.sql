CREATE DATABASE uic_covid_contact_tracing;s
use uic_covid_contact_tracing;

CREATE TABLE student (
	uin INTEGER UNSIGNED NOT NULL UNIQUE,
    vaccination_status TINYINT NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    student_living_status TINYINT NOT NULL,
    student_major_name VARCHAR(30),
    dorm_id VARCHAR(10),
    PRIMARY KEY (uin)
		
);

CREATE TABLE covid_test (
	uin INTEGER UNSIGNED NOT NULL UNIQUE,
    test_date DATE NOT NULL,
    result_date DATE NOT NULL,
    test_result TINYINT NOT NULL,
    PRIMARY KEY (uin),
    FOREIGN KEY (uin) REFERENCES student(uin)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE course (
	uin INTEGER UNSIGNED NOT NULL UNIQUE,
    course_id SMALLINT UNSIGNED NOT NULL,
    course_location VARCHAR(30) NOT NULL,
    PRIMARY KEY (uin),
    FOREIGN KEY (uin) REFERENCES student(uin)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE organization (
	uin INTEGER UNSIGNED NOT NULL UNIQUE,
    organization_id SMALLINT UNSIGNED NOT NULL,
    organization_name VARCHAR(30) NOT NULL,
    PRIMARY KEY (uin),
    FOREIGN KEY (uin) REFERENCES student(uin)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE student_housing (
	uin INTEGER UNSIGNED NOT NULL UNIQUE,
    dorm_id VARCHAR(10) NOT NULL,
    room_number SMALLINT UNSIGNED NOT NULL,
    PRIMARY KEY (uin),
    FOREIGN KEY (uin) REFERENCES student(uin)
);

CREATE TABLE contact_information (
	uin INTEGER UNSIGNED NOT NULL UNIQUE,
    email_address VARCHAR(50) NOT NULL UNIQUE,
    phone_number VARCHAR(10) UNIQUE,
    address VARCHAR(50) NOT NULL,
    PRIMARY KEY (uin),
    FOREIGN KEY (uin) REFERENCES student(uin)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);