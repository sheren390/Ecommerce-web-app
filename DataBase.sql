-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema healthifyme
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema healthifyme
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `healthifyme` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `healthifyme` ;

-- -----------------------------------------------------
-- Table `healthifyme`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `healthifyme`.`product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(150) NULL DEFAULT NULL,
  `quantity` INT NOT NULL,
  `price` DECIMAL(10,0) NOT NULL,
  `image` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `product_id_UNIQUE` (`product_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `healthifyme`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `healthifyme`.`category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `image` VARCHAR(150) NULL DEFAULT NULL,
  `description` VARCHAR(150) NULL DEFAULT NULL,
  `product_product_id` INT NOT NULL,
  PRIMARY KEY (`category_id`, `product_product_id`),
  UNIQUE INDEX `category_id_UNIQUE` (`category_id` ASC) VISIBLE,
  INDEX `fk_category_product1_idx` (`product_product_id` ASC) VISIBLE,
  CONSTRAINT `fk_category_product1`
    FOREIGN KEY (`product_product_id`)
    REFERENCES `healthifyme`.`product` (`product_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `healthifyme`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `healthifyme`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `wallet_balance` DECIMAL(10,0) NULL DEFAULT NULL,
  `address` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `healthifyme`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `healthifyme`.`order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `total_price` DECIMAL(10,0) NOT NULL,
  `order_status` VARCHAR(45) NOT NULL,
  `user_user_id` INT NOT NULL,
  PRIMARY KEY (`order_id`, `user_user_id`),
  UNIQUE INDEX `order_id_UNIQUE` (`order_id` ASC) VISIBLE,
  INDEX `fk_order_user1_idx` (`user_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`user_user_id`)
    REFERENCES `healthifyme`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `healthifyme`.`order_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `healthifyme`.`order_has_product` (
  `order_order_id` INT NOT NULL,
  `order_user_user_id` INT NOT NULL,
  `product_product_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`order_order_id`, `order_user_user_id`, `product_product_id`),
  INDEX `fk_order_has_product_product1_idx` (`product_product_id` ASC) VISIBLE,
  INDEX `fk_order_has_product_order1_idx` (`order_order_id` ASC, `order_user_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_has_product_order1`
    FOREIGN KEY (`order_order_id` , `order_user_user_id`)
    REFERENCES `healthifyme`.`order` (`order_id` , `user_user_id`),
  CONSTRAINT `fk_order_has_product_product1`
    FOREIGN KEY (`product_product_id`)
    REFERENCES `healthifyme`.`product` (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `healthifyme`.`user_make_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `healthifyme`.`user_make_product` (
  `product_product_id` INT NOT NULL,
  `user_user_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`product_product_id`, `user_user_id`),
  INDEX `fk_product_has_user_user1_idx` (`user_user_id` ASC) VISIBLE,
  INDEX `fk_product_has_user_product_idx` (`product_product_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_has_user_product`
    FOREIGN KEY (`product_product_id`)
    REFERENCES `healthifyme`.`product` (`product_id`),
  CONSTRAINT `fk_product_has_user_user1`
    FOREIGN KEY (`user_user_id`)
    REFERENCES `healthifyme`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
