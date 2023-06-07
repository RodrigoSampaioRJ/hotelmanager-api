package com.api.hotelmanager.exceptions.dto;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {

	private Integer status;
	private String type;
	private String title;
	private String details;
	private Instant timeStamp;
	private String	userMessage;
	
	private List<Field> fields;
	
	@Getter
	@Builder
	public static class Field {
		private String name;
		private String userMessage;
	}
}
