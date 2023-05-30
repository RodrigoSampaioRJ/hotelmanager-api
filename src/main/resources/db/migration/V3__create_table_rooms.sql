-- hotelmanager.tb_rooms definition

CREATE TABLE `tb_rooms`
(
    `id`       bigint NOT NULL AUTO_INCREMENT,
    `number`   int          DEFAULT NULL,
    `price`    double       DEFAULT NULL,
    `type`     varchar(255) DEFAULT NULL,
    `hotel_id` bigint       DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK4cg8dh2icnva6lu4p5ig6ro6j` (`hotel_id`),
    CONSTRAINT `FK4cg8dh2icnva6lu4p5ig6ro6j` FOREIGN KEY (`hotel_id`) REFERENCES `tb_hotels` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;