-- hotelmanager.tb_guests definition

CREATE TABLE `tb_guests`
(
    `id`    varchar(255) NOT NULL,
    `email` varchar(255) DEFAULT NULL,
    `name`  varchar(255) DEFAULT NULL,
    `phone` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;