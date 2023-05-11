
CREATE TABLE `tb_rooms` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `number` int,
  `type` varchar(255),
  `price` double,
  `hotel_id` int
);
FOREIGN KEY (hotel_id) REFERENCES tb_hotels (id)



