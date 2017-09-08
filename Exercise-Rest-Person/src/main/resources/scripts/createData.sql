/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Oakberg
 * Created: Sep 7, 2017
 */

drop database if exists hejsa;
create database hejsa;
use hejsa;
create table Person (id int, fName varchar(255), lName varchar(255) , phone varchar(255) ) ;

INSERT INTO Person (id, fName, lName, phone) VALUES (1, 'Petyr', 'Baelish', '2424');