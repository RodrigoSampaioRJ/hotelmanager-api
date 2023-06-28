package com.api.hotelmanager.modules.hotel.entity;

import com.api.hotelmanager.modules.room.entity.Room;
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
import java.util.List;

@Entity
@Table(name = "tb_hotel")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Hotel implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private Integer stars;
	
    @OneToMany(mappedBy = "hotel")
    @JsonBackReference
	@JsonManagedReference
	@JsonProperty
    private List<Room> rooms;

}
