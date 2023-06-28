package com.api.hotelmanager.modules.guest.entity;

import com.api.hotelmanager.modules.reservation.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_guest")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Guest implements Serializable{
	 
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	
	@OneToMany(mappedBy = "guest",cascade = CascadeType.ALL)
	@Singular
	@JsonManagedReference
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private List<Reservation> reservations;

}
