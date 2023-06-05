-- hotelmanager.tb_hotels definition

CREATE TABLE `tb_hotel`
(
    `id`      bigint NOT NULL AUTO_INCREMENT,
    `address` varchar(255) DEFAULT NULL,
    `name`    varchar(255) DEFAULT NULL,
    `stars`   int          DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;