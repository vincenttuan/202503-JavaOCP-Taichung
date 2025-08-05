package dao;

import java.util.List;

public interface DroneOrderDao {
	
	// orderByName: 排序欄位
	// asc: true(由小到大 = asc) false(由大到小 = desc)
	List<DroneOrderDao> findAll(String orderByName, boolean asc);
	
	// 預設 orderByName: order_id
	// 預設 asc: true
	List<DroneOrderDao> findAll();
	
}
