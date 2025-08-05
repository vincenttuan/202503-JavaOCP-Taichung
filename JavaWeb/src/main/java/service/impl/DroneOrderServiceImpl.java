package service.impl;

import java.util.List;

import dao.DroneOrderDao;
import dao.impl.DroneOrderDaoImpl;
import model.DroneOrder;
import service.DroneOrderService;

public class DroneOrderServiceImpl implements DroneOrderService {
	
	private DroneOrderDao dao = new DroneOrderDaoImpl();
	
	@Override
	public List<DroneOrder> findAll(String orderByName, boolean asc) {
		return dao.findAll(orderByName, asc);
	}

	@Override
	public List<DroneOrder> findAll(String orderByName) {
		return findAll(orderByName, true);
	}

	@Override
	public List<DroneOrder> findAll() {
		return findAll("order_id", true);
	}

}
