DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  code VARCHAR(250) NOT NULL,
  points_Cost INT NOT NULL
);

INSERT INTO product (name,code,points_Cost) VALUES
  ('BEAN_CAN','0001',25),
  ('COKE_BOTTLE','0002',34),
  ('COKE_CAN','0003',39),
  ('ORANGE','0004',50),
  ('BANANA','0005',73),
  ('APPLE','0006',67);

DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  points_Balance INT NOT NULL
);

INSERT INTO customer (name,points_Balance) VALUES
  ('Boikanyo',25),
  ('Tumi',100),
  ('Neo',50),
  ('Charles',10),
  ('Lerato',10),
  ('Sydney',636);