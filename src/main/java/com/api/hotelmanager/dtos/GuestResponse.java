package com.api.hotelmanager.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GuestResponse {
	
	private String name;
	private String email;
	private String phone;

}
