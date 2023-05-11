CREATE TABLE `tb_reservations` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `check_in` datetime,
  `check_out` datetime,
  `room_id` int,
  `guest_id` int
);

FOREIGN KEY (room_id, guest_id) REFERENCES tb_rooms,tb_guest (id,id)