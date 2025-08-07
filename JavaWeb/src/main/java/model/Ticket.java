package model;

import lombok.Data;

@Data
public class Ticket {
	private Integer id;
	private String departure;
	private String location;
	private String clazz;
	private String airline;
	private Integer price;
}
