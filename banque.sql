SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema banque
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `banque` ;

-- -----------------------------------------------------
-- Schema banque
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `banque` DEFAULT CHARACTER SET utf8 ;
USE `banque` ;

-- -----------------------------------------------------
-- Table `banque`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `banque`.`User` ;

CREATE TABLE IF NOT EXISTS `banque`.`User` (
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `nom` VARCHAR(45) NULL,
  `prenom` VARCHAR(45) NULL,
  `adresse` VARCHAR(45) NULL,
  `est_admin` TINYINT NULL,
  PRIMARY KEY (`login`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banque`.`compte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `banque`.`compte` ;

CREATE TABLE IF NOT EXISTS `banque`.`compte` (
  `numero_compte` INT NOT NULL AUTO_INCREMENT,
  `decouvertmaximal` INT NULL,
  `debitmaximal` INT NULL,
  `solde` FLOAT NULL,
  `login_user` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`numero_compte`),
  INDEX `fk_compte_User_idx` (`login_user` ASC) VISIBLE,
  CONSTRAINT `fk_compte_User`
    FOREIGN KEY (`login_user`)
    REFERENCES `banque`.`User` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `banque`.`user`
(`login`,
`password`,
`nom`,
`prenom`,
`adresse`,
`est_admin`)
VALUES
("admin@admin",
"admin",
"Doe",
"John",
"xxxx",
1);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
commit ;
