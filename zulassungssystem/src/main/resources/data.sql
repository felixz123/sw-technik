DROP TABLE IF EXISTS Bewerber;
 
CREATE TABLE Bewerber (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);
 
INSERT INTO Bewerber (first_name, last_name, email) VALUES
  ('Aliko', 'Dangote', 'abc@example.com'),
  ('Bill', 'Gates', 'xyz@example.com'),
  ('Folrunsho', 'Alakija', 'asdf@example.com');