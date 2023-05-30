CREATE TABLE `tb_user_profiles`
(
    `user_id`   bigint NOT NULL,
    `profile_id` bigint NOT NULL,
    PRIMARY KEY (`user_id`,`profile_id`),
    FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;