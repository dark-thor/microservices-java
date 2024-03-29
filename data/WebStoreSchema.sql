-- MySQL Script generated by MySQL Workbench
-- Sat 27 Aug 2016 09:29:00 PM IST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema WebStore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `WebStore` DEFAULT CHARACTER SET utf8 ;
USE `WebStore` ;

-- -----------------------------------------------------
-- Table `WebStore`.`address_suggest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WebStore`.`address_suggest` ;

CREATE TABLE IF NOT EXISTS `WebStore`.`address_suggest` (
  `address_suggest_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `pincode` VARCHAR(45) NOT NULL,
  `locality` VARCHAR(255) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `created_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`address_suggest_id`),
  INDEX `idx_pincode` (`pincode` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `WebStore`.`customers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WebStore`.`customers` ;

CREATE TABLE IF NOT EXISTS `WebStore`.`customers` (
  `customer_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(254) NOT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `mobile` VARCHAR(45) NULL DEFAULT NULL,
  `start_date` DATE NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `status` VARCHAR(20) NOT NULL DEFAULT 'UNVERIFIED',
  `last_password_reset_date` DATETIME NOT NULL,
  `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `Email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `WebStore`.`customer_addresses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WebStore`.`customer_addresses` ;

CREATE TABLE IF NOT EXISTS `WebStore`.`customer_addresses` (
  `customer_address_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `address_line1` VARCHAR(255) NOT NULL,
  `address_line2` VARCHAR(255) NULL DEFAULT NULL,
  `city` VARCHAR(255) NOT NULL,
  `state` VARCHAR(255) NOT NULL,
  `country` VARCHAR(255) NOT NULL,
  `postal_code` VARCHAR(20) NULL DEFAULT NULL,
  `customer_id` INT(10) UNSIGNED NOT NULL,
  `address_ordinal` INT(11) NULL DEFAULT NULL,
  `status` ENUM('ACTIVE', 'DELETED') NOT NULL DEFAULT 'ACTIVE',
  `mobile` VARCHAR(20) NOT NULL,
  `created_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`customer_address_id`),
  INDEX `fk_CustomerAddresses_Customers_idx` (`customer_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
