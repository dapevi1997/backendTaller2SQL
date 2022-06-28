-- -----------------------------------------------------
-- Schema agenda
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS agenda DEFAULT CHARACTER SET utf8 ;
USE agenda ;
-- -----------------------------------------------------
-- Table contact
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS contact (
  con_id INT NOT NULL AUTO_INCREMENT,
  con_name VARCHAR(100) NOT NULL,
  con_number VARCHAR(10) NOT NULL,
  con_email VARCHAR(70) NOT NULL,
  con_birthday DATE NOT NULL,
  PRIMARY KEY (con_id),
  UNIQUE INDEX con_name_UNIQUE (con_name ASC) VISIBLE,
  UNIQUE INDEX con_number_UNIQUE (con_number ASC) VISIBLE)
ENGINE = InnoDB;

alter table contact
    add deleted boolean default 0 null;

insert into contact( con_name, con_number, con_email, con_birthday, deleted)
values ('Daniel Pérez','3215915567','dapevi97@gmail.com','1997-07-04',0);
