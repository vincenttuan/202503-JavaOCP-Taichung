package model;

import lombok.Data;

@Data
public class Ticket {
	private int id;
	private String departure;
	private String location;
	private String clazz;
	private String airline;
	private int price;
}
