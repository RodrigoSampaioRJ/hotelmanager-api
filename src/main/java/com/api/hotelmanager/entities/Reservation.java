package com.api.hotelmanager.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_reservation")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Reservation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "guest_id")
	@JsonBackReference
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
