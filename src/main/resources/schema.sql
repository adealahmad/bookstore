SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `book_types`;

CREATE TABLE `book_types` (
  `book_type_id` bigint NOT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `type_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `book_id` bigint NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` text,
  `isbn` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `book_type_id` bigint DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `book_type_id_fk` (`book_type_id`),
  CONSTRAINT `book_type_id_fk` FOREIGN KEY (`book_type_id`) REFERENCES `book_types` (`book_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `promotions`;

CREATE TABLE `promotions` (
  `promo_id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `promo_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`promo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `discounts`;

CREATE TABLE `discounts` (
  `discount_id` bigint NOT NULL,
  `book_type_id` bigint DEFAULT NULL,
  `discount_percentage` int DEFAULT NULL,
  `promo_id` bigint DEFAULT NULL,
  PRIMARY KEY (`discount_id`),
  KEY `discount_book_type_id_fk` (`book_type_id`),
  KEY `promo_id_fk` (`promo_id`),
  CONSTRAINT `discount_book_type_id_fk` FOREIGN KEY (`book_type_id`) REFERENCES `book_types` (`book_type_id`),
  CONSTRAINT `promo_id_fk` FOREIGN KEY (`promo_id`) REFERENCES `promotions` (`promo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


SET FOREIGN_KEY_CHECKS = 1;






