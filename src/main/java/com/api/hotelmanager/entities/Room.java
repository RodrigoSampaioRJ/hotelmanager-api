package com.api.hotelmanager.entities;

import java.io.Serializable;

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
@Table(name = "tb_rooms")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Room implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer number;
	private String type;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	public Boolean isAvailable() {
		return null;
	}

}
