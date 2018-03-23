-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema legohouse
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema legohouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `legohouse` DEFAULT CHARACTER SET utf8 ;
USE `legohouse` ;

-- -----------------------------------------------------
-- Table `legohouse`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legohouse`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `legohouse`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legohouse`.`orders` (
  `ordernumber` INT(11) NOT NULL AUTO_INCREMENT,
  `userID` INT(11) NOT NULL,
  `height` INT(11) NOT NULL,
  `width` INT(11) NOT NULL,
  `length` INT(11) NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'Pending',
  PRIMARY KEY (`ordernumber`),
  INDEX `UserID_idx` (`userID` ASC),
  CONSTRAINT `userID`
    FOREIGN KEY (`userID`)
    REFERENCES `legohouse`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



-- CREATE DATABASE  IF NOT EXISTS `useradmin`;
-- 
-- 
-- USE `useradmin`;
-- 
-- DROP TABLE IF EXISTS `users`;
-- CREATE TABLE `users` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `email` varchar(90) NOT NULL,
--   `password` varchar(45) NOT NULL,
--   `role` varchar(20) NOT NULL DEFAULT 'customer',
--   PRIMARY KEY (`id`),
--   UNIQUE KEY `email_UNIQUE` (`email`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
-- 
-- LOCK TABLES `users` WRITE;
-- INSERT INTO `users` VALUES 
-- (1,'jens@somewhere.com','jensen','customer'),
-- (2,'ken@somewhere.com','kensen','customer'),
-- (3,'robin@somewhere.com','batman','employee');
-- UNLOCK TABLES;