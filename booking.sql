-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema booking_project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema booking_project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `booking_project` DEFAULT CHARACTER SET latin1 ;
USE `booking_project` ;

-- -----------------------------------------------------
-- Table `booking_project`.`aircraft`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`aircraft` (
  `aircraft_id` VARCHAR(50) NOT NULL,
  `manufacturer_id` VARCHAR(50) NULL DEFAULT NULL,
  `model` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`aircraft_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking_project`.`aircraft_manufacturer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`aircraft_manufacturer` (
  `manufacturer_id` VARCHAR(50) NOT NULL,
  `manufacturer_name` VARCHAR(50) NULL DEFAULT NULL,
  `description` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`manufacturer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking_project`.`aircraft_seat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`aircraft_seat` (
  `seat_id` VARCHAR(50) CHARACTER SET 'utf8' NOT NULL,
  `aircraft_id` VARCHAR(50) NULL DEFAULT NULL,
  `class` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`seat_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking_project`.`airport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`airport` (
  `airport_id` VARCHAR(10) NOT NULL,
  `airport_name` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `country_code` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`airport_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking_project`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`booking` (
  `booking_id` VARCHAR(50) NOT NULL,
  `unregistered_name` VARCHAR(50) NULL DEFAULT NULL,
  `registered_name` VARCHAR(50) NULL DEFAULT NULL,
  `phone` INT(11) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `passengers_name` VARCHAR(50) NULL DEFAULT NULL,
  `passengers_surname` VARCHAR(50) NULL DEFAULT NULL,
  `passengers_sex` VARCHAR(5) NULL DEFAULT NULL,
  `passengers_dob` DATETIME NULL DEFAULT NULL,
  `passenger_categories` VARCHAR(10) NULL DEFAULT NULL,
  `citizenship` VARCHAR(45) NULL DEFAULT NULL,
  `passport` VARCHAR(45) NULL DEFAULT NULL,
  `identity_card` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`booking_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking_project`.`countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`countries` (
  `country_id` VARCHAR(3) NOT NULL,
  `country_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`country_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking_project`.`credit_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`credit_card` (
  `id` INT(11) NOT NULL,
  `card_number` VARCHAR(50) NULL DEFAULT NULL,
  `balance` DECIMAL(19,4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking_project`.`direction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`direction` (
  `origin_id` VARCHAR(10) NOT NULL,
  `destination_id` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`origin_id`, `destination_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking_project`.`flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`flight` (
  `flight_id` VARCHAR(50) NOT NULL,
  `flight_schedule_id` VARCHAR(45) NOT NULL,
  `seat_id` VARCHAR(45) NOT NULL,
  `limit_baggage_weight` VARCHAR(45) NULL DEFAULT NULL,
  `total_fee` DECIMAL(14,4) NULL DEFAULT NULL,
  PRIMARY KEY (`flight_id`, `flight_schedule_id`, `seat_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking_project`.`flight_schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`flight_schedule` (
  `flight_schedule_id` VARCHAR(50) NOT NULL,
  `from` VARCHAR(10) NULL DEFAULT NULL,
  `to` VARCHAR(10) NULL DEFAULT NULL,
  `departure_date` DATETIME NULL DEFAULT NULL,
  `departure_time` VARCHAR(10) NULL DEFAULT NULL,
  `arrival_date` DATETIME NULL DEFAULT NULL,
  `arrival_time` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`flight_schedule_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking_project`.`profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`profile` (
  `username` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(50) NULL DEFAULT NULL,
  `last_name` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `phone_number` VARCHAR(50) NULL DEFAULT NULL,
  `passport` VARCHAR(50) NULL DEFAULT NULL,
  `identity_card` VARCHAR(100) NULL DEFAULT NULL,
  `address` VARCHAR(100) NULL DEFAULT NULL,
  `city` VARCHAR(50) NULL DEFAULT NULL,
  `state` VARCHAR(50) NULL DEFAULT NULL,
  `postal_code` VARCHAR(50) NULL DEFAULT NULL,
  `country` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking_project`.`register`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`register` (
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(500) NULL DEFAULT NULL,
  `salt` VARBINARY(5000) NULL DEFAULT NULL,
  `permisstion` VARCHAR(50) NULL DEFAULT NULL,
  `create_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking_project`.`transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_project`.`transaction` (
  `payment_id` INT(11) NOT NULL,
  `booking_id` VARCHAR(45) NOT NULL,
  `credit_card_type` VARCHAR(50) NULL DEFAULT NULL,
  `holder_name` VARCHAR(50) NULL DEFAULT NULL,
  `card_number` VARCHAR(100) NULL DEFAULT NULL,
  `card_identification_number` VARCHAR(100) NULL DEFAULT NULL,
  `expiration_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`payment_id`, `booking_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
