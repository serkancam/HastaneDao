-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hastatakip
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hastatakip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hastatakip` DEFAULT CHARACTER SET utf8 COLLATE utf8_turkish_ci ;
USE `hastatakip` ;

-- -----------------------------------------------------
-- Table `hastatakip`.`hasta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hastatakip`.`hasta` (
  `hastaTC` CHAR(11) NOT NULL,
  `hastaAdi` VARCHAR(45) NOT NULL,
  `hastaSoyadi` VARCHAR(45) NOT NULL,
  `hastaDogumTarihi` DATE NOT NULL,
  PRIMARY KEY (`hastaTC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hastatakip`.`doktorUzmanlik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hastatakip`.`doktorUzmanlik` (
  `doktorUzmanlikId` TINYINT NOT NULL AUTO_INCREMENT,
  `doktorUzmanlikAdi` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`doktorUzmanlikId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hastatakip`.`doktor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hastatakip`.`doktor` (
  `doktorTC` CHAR(11) NOT NULL,
  `doktorAdi` VARCHAR(45) NOT NULL,
  `doktorSoyadi` VARCHAR(45) NOT NULL,
  `doktorDogumTarihi` DATE NULL,
  `doktorUzmanlik` TINYINT NULL,
  PRIMARY KEY (`doktorTC`),
  INDEX `fk_doktor_1_idx` (`doktorUzmanlik` ASC),
  CONSTRAINT `fk_doktor_1`
    FOREIGN KEY (`doktorUzmanlik`)
    REFERENCES `hastatakip`.`doktorUzmanlik` (`doktorUzmanlikId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hastatakip`.`muayene`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hastatakip`.`muayene` (
  `muayeneId` INT NOT NULL AUTO_INCREMENT,
  `muayeneTarihi` DATE NOT NULL,
  `hastaTC` CHAR(11) NOT NULL,
  `doktorTC` CHAR(11) NOT NULL,
  PRIMARY KEY (`muayeneId`),
  INDEX `fk_muayene_1_idx` (`hastaTC` ASC),
  INDEX `fk_muayene_2_idx` (`doktorTC` ASC),
  CONSTRAINT `fk_muayene_1`
    FOREIGN KEY (`hastaTC`)
    REFERENCES `hastatakip`.`hasta` (`hastaTC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_muayene_2`
    FOREIGN KEY (`doktorTC`)
    REFERENCES `hastatakip`.`doktor` (`doktorTC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hastatakip`.`ilac`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hastatakip`.`ilac` (
  `ilacId` INT NOT NULL AUTO_INCREMENT,
  `ilacAdi` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ilacId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hastatakip`.`verilenIlac`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hastatakip`.`verilenIlac` (
  `ilacId` INT NULL,
  `muayeneId` INT NULL,
  INDEX `fk_verilenIlac_1_idx` (`ilacId` ASC),
  INDEX `fk_verilenIlac_2_idx` (`muayeneId` ASC),
  CONSTRAINT `fk_verilenIlac_1`
    FOREIGN KEY (`ilacId`)
    REFERENCES `hastatakip`.`ilac` (`ilacId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_verilenIlac_2`
    FOREIGN KEY (`muayeneId`)
    REFERENCES `hastatakip`.`muayene` (`muayeneId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hastatakip`.`teshis`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hastatakip`.`teshis` (
  `teshisId` INT NOT NULL AUTO_INCREMENT,
  `muayeneId` INT NOT NULL,
  `teshisAciklama` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`teshisId`),
  INDEX `fk_teshis_1_idx` (`muayeneId` ASC),
  CONSTRAINT `fk_teshis_1`
    FOREIGN KEY (`muayeneId`)
    REFERENCES `hastatakip`.`muayene` (`muayeneId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

