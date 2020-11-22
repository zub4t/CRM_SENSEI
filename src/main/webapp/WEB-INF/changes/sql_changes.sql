/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  marco
 * Created: 2/nov/2020
 */
/*
Criação da Bd
*/
create database CRM;
use CRM;
create  table main_menu(id int not null auto_increment, nme varchar(255) not null, lvl int(3) not null, parent_id int , primary key(id), foreign key(parent_id) references main_menu(id) );
INSERT INTO `crm`.`main_menu` (`nme`, `lvl`) VALUES ('Gestão', '0');
INSERT INTO `crm`.`main_menu` (`nme`, `lvl`, `parent_id`) VALUES ('funcionários ', '1', '1');
INSERT INTO `crm`.`main_menu` (`nme`, `lvl`, `parent_id`) VALUES ('projetos', '1', '1');

create  table employee(id int not null auto_increment, nme varchar(255) not null, tel int, email varchar(150) , primary key(id) );
create  table usr(id int not null auto_increment, usrnme varchar(255) not null, pass varchar(150) , foreign key(id) references employee(id));
insert into employee (nme,tel,email) values("marco","913648628","marcoaraujo96@gmail.com");
insert into usr(id,usrnme,pass) values(1,"sushll","admin");
create table project (id int primary key not null auto_increment, n_process  varchar(50) , customer_nme varchar(255) ,expected_sale DECIMAL(10,2), effective_sale DECIMAL(10,2),
effective_purchase DECIMAL(10,2));
create table assingment (id int not null auto_increment primary key, dsc varchar(255) not null);
create table project_employee(project_id int not null, employee_id int not null, assingment_id int not null, spend_time time , foreign key(project_id) references project(id), foreign key(employee_id) references employee(id),foreign key(assingment_id) references assingment(id));