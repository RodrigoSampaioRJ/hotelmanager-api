-- hotelmanager.tb_reservations definition

CREATE TABLE `tb_reservation`
(
    `id`        bigint NOT NULL AUTO_INCREMENT,
    `check_in`  datetime(6)  DEFAULT NULL,
    `check_out` datetime(6)  DEFAULT NULL,
    `guest_id`  varchar(255) DEFAULT NULL,
    `room_id`   bigint       DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKgbjjdnqdownwt6suhgqh3vwa` (`guest_id`),
    KEY `FKmk7oosf019u27lbtpfiuofhcu` (`room_id`),
    CONSTRAINT `FKgbjjdnqdownwt6suhgqh3vwa` FOREIGN KEY (`guest_id`) REFERENCES `tb_guest` (`id`),
    CONSTRAINT `FKmk7oosf019u27lbtpfiuofhcu` FOREIGN KEY (`room_id`) REFERENCES `tb_room` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;