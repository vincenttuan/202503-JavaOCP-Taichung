package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIResponse<T> {
	private boolean success;
	private T data;
	private String message;
}
