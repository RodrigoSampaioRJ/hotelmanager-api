package com.api.hotelmanager.modules.room.entity;

import com.api.hotelmanager.modules.hotel.entity.Hotel;
import com.api.hotelmanager.modules.reservation.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "tb_room")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Room implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer number;
	private String type;
	private Double price;
	
	@ManyToOne(targetEntity = Hotel.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "hotel_id")
	@JsonBackReference
	private Hotel hotel;

	@OneToMany(mappedBy = "room")
	@JsonManagedReference
	private List<Reservation> reservations;
	
	public Boolean isAvailable(Instant checkIn, Instant checkOut) {
		return this.reservations.stream()
				.noneMatch(reservation -> reservation.getCheckIn().isBefore(checkOut)
						&& reservation.getCheckOut().isAfter(checkIn));
	}

}
