package com.api.hotelmanager.entities;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_reservations")
@Data
public class Reservation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "guest_id")
	private Guest guest;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
	private Instant checkIn;
	private Instant checkOut;
	
	public Double totalCost() {
		return null;
	}
}
