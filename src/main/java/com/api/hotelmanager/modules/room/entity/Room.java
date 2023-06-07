package com.api.hotelmanager.modules.room.entity;

import com.api.hotelmanager.modules.hotel.entity.Hotel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "tb_room")
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
	@JsonBackReference
	private Hotel hotel;
	
	public Boolean isAvailable() {
		return null;
	}

}
