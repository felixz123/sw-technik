DROP TABLE IF EXISTS Bewerber;
 
CREATE TABLE Bewerber (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  access_role VARCHAR(250),
  acc_password VARCHAR(250)
);
 
INSERT INTO Bewerber (first_name, last_name, email, access_role, acc_password) VALUES
  ('Aliko', 'Dangote', 'abc@example.com', 'ROLE_BEWERBER', 'blah'),
  ('Bill', 'Gates', 'xyz@example.com', 'ROLE_ZULASSUNG', 'zulpw'),
  ('Folrunsho', 'Alakija', 'asdf@example.com', 'ROLE_UNTERSTUETZER', 'untpw');