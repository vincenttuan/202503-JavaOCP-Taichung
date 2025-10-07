package com.example.demo.cart.model.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`user`")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, unique = true, nullable = false)
	private String username;
	
	@Column(length = 255, nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Order> orders;
	
	// 建立用戶可以關注商品的多對多關係
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "user_product",
		joinColumns = @JoinColumn(name = "user_id"), // user 主鍵
		inverseJoinColumns = @JoinColumn(name = "product_id") // product 主鍵
	)
	private Set<Product> favoriteProducts;
	
}
