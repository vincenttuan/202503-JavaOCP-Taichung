package service;

import java.util.List;

import model.DroneOrder;

public interface DroneOrderService {
	
	public List<DroneOrder> findAll(String orderByName, boolean asc);
	public List<DroneOrder> findAll();
	
}
