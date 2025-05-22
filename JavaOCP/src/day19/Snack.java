package day19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Snack {
	private String name;
	private String description;
	private Integer price;
	private String location;
	private String type;
	
}
