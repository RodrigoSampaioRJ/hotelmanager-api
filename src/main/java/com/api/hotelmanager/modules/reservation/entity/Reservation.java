package com.api.hotelmanager.modules.reservation.entity;

import com.api.hotelmanager.modules.guest.entity.Guest;
import com.api.hotelmanager.modules.room.entity.Room;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_reservation")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Reservation implements Serializable{
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "guest_id")
	@JsonBackReference
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Guest guest;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	@JsonBackReference
	private Room room;
	
	private Instant checkIn;
	
	private Instant checkOut;
	
	public Double totalCost() {
		return null;
	}
}
