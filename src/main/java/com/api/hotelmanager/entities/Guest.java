package com.api.hotelmanager.entities;

import java.io.Serializable;
import java.util.List;

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
@Table(name = "tb_guests")
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
	private List<Reservation> reservations;

}
