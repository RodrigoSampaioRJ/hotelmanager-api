package com.api.hotelmanager.modules.guest.entity;

import java.io.Serializable;
import java.util.List;

import com.api.hotelmanager.modules.reservation.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Entity
@Table(name = "tb_guest")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Guest implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String name;
	private String email;
	private String phone;
	
	@OneToMany(mappedBy = "guest",cascade = CascadeType.ALL)
	@Singular
	@JsonManagedReference
	private List<Reservation> reservations;

}
