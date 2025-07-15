package model;

import lombok.Data;

// 使用者資料
/**
use web;
create table if not exists user (
	id int auto_increment primary key,
    username varchar(50) not null unique,
    hash varchar(255) not null,
    salt varchar(255) not null
);
 */
@Data
public class User {
	private Integer id;
	private String username;
	private String hash;
	private String salt;
	
}
