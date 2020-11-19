DROP TABLE IF EXISTS bewerber;
 
CREATE TABLE bewerber (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);
 
INSERT INTO bewerber (first_name, last_name, email) VALUES
  ('Aliko', 'Dangote', 'abc@example.com'),
  ('Bill', 'Gates', 'xyz@example.com'),
  ('Folrunsho', 'Alakija', 'asdf@example.com');