package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.DroneOrderDao;
import model.DroneOrder;

public class DroneOrderDaoImpl extends BaseDao implements DroneOrderDao {

	@Override
	public List<DroneOrder> findAll(String orderByName, boolean asc) {
		String sql = """
				select order_id, customer_name, drone_model, height, speed, quantity, price, order_date, status 
				from drone_order
				order by %s %s
				""";
		sql = String.format(sql.trim(), orderByName, asc?"asc":"desc");
		List<DroneOrder> droneOrders = new ArrayList<>();
		
		try(Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				DroneOrder droneOrder = new DroneOrder();
				droneOrder.setOrderId(rs.getInt("order_id"));
				droneOrder.setCustomerName(rs.getString("customer_name"));
				droneOrder.setDroneModel(rs.getString("drone_model"));
				droneOrder.setHeight(rs.getInt("height"));
				droneOrder.setSpeed(rs.getInt("speed"));
				droneOrder.setQuantity(rs.getInt("quantity"));
				droneOrder.setPrice(rs.getInt("price"));
				droneOrder.setOrderDate(rs.getDate("order_date"));
				droneOrder.setStatus(rs.getString("status"));
				// 注入到集合中保存
				droneOrders.add(droneOrder);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("查詢失敗: " + e);
		}
		
		return droneOrders;
	}

	@Override
	public List<DroneOrder> findAll() {
		return findAll("order_id", true); // 輸入預設參數
	}

}
