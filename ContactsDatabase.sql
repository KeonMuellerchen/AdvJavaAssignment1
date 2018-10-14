CREATE DATABASE contacts;

USE contacts;
DROP TABLE IF EXISTS person;

CREATE TABLE IF NOT EXISTS person (

	personID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	firstName VARCHAR(20),
    lastName VARCHAR(20),
    address VARCHAR(30),
    phone VARCHAR(12),
    birthday DATE,
    image VARCHAR(40)
);

INSERT INTO person (firstName, lastName, address, phone, birthday, image) 
VALUES 
('Keon', 'Muellerchen', '32 Rosemary AVE', '647-830-0598', '1999-05-05', ''),
('Albert', 'Einstein', '99 Smartest Road', '416-555-9876', '2018-03-14', ''),
('Darian', 'Mueller', '53 Smooth Drive', '905-222-1234', '2001-10-25', '');
