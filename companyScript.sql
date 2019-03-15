drop database company;
create DATABASE if not exists company;
use company;
-- department: table
CREATE TABLE `department`
(
  `idDepartment` int(11) NOT NULL AUTO_INCREMENT,
  `name`         varchar(255) DEFAULT NULL,
  `status`       bit(1)  NOT NULL,
  PRIMARY KEY (`idDepartment`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- workers: table
CREATE TABLE `workers`
(
  `id`                        int(11) NOT NULL AUTO_INCREMENT,
  `age`                       int(11) NOT NULL,
  `availability`              ENUM('FULL_TIME','PART_TIME') NULL DEFAULT NULL,
  `fullName`                  varchar(255) DEFAULT NULL,
  `departmentId_idDepartment` int(11)      DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4tbe088p9hhfycx9txu7ujunt` (`departmentId_idDepartment`),
  CONSTRAINT `FK4tbe088p9hhfycx9txu7ujunt` FOREIGN KEY (`departmentId_idDepartment`) REFERENCES `department` (`idDepartment`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- No native definition for element: FK4tbe088p9hhfycx9txu7ujunt (index)

insert into company.department (name, status) values ('department1',true);
insert into company.department (name, status) values ('department2',false);
insert into company.department (name, status) values ('department3',true);
insert into company.department (name, status) values ('department4',true);

insert into company.workers (age, availability, fullName, departmentId_idDepartment) VALUES (18,'FULL_TIME','Vasya_J',1);
insert into company.workers (age, availability, fullName, departmentId_idDepartment) VALUES (22,'FULL_TIME','Kolya_M',1);
insert into company.workers (age, availability, fullName, departmentId_idDepartment) VALUES (51,'PART_TIME','Olya_K',2);
insert into company.workers (age, availability, fullName, departmentId_idDepartment) VALUES (16,'PART_TIME','Serj_Q',2);
insert into company.workers (age, availability, fullName, departmentId_idDepartment) VALUES (26,'FULL_TIME','John_F',2);
insert into company.workers (age, availability, fullName, departmentId_idDepartment) VALUES (25,'FULL_TIME','Josh_M',3);
insert into company.workers (age, availability, fullName, departmentId_idDepartment) VALUES (22,'FULL_TIME','Ivan',3);
insert into company.workers (age, availability, fullName, departmentId_idDepartment) VALUES (33,'PART_TIME','Alina_F',3);
insert into company.workers (age, availability, fullName, departmentId_idDepartment) VALUES (34,'FULL_TIME','Malina_F',3);
insert into company.workers (age, availability, fullName, departmentId_idDepartment) VALUES (35,'FULL_TIME','Karina_F',4);

