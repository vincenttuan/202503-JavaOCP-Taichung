package model;

import lombok.Data;

// 使用者資料
/**
use web;
create table if not exists user (
	id int auto_increment primary key,
    username varchar(50) not null unique,
    hash varchar(255) not null,
    salt varchar(255) not null,
    priority int default 0
);

-- 密碼: 1234
insert into user(username, hash, salt, priority) values('admin', '111653b39e04eb80eb6c0930958d12fc56fed6153220cc9e02ccaae083503730', 'ISM8mSa12m9h+R0r+6yt5g==', 1);
-- 密碼: 5678
insert into user(username, hash, salt, priority) values('john', '68dd9b4ca9415b2561ec59ca1223c505f7443ff9fda319c71930c536beeb08b6', '9CyhyLRwuuEqbjiSXjnFTw==', 0);
-- 密碼: 1234
insert into user(username, hash, salt, priority) values('mary', '9433fbf4253225f316a4141e3c50404ba86282b2562dec6660cd52e5bcb20e15', 'J1itVt9sJrP7iMWJd6e9pA==', 0);

 */
@Data
public class User {
	private Integer id;
	private String username;
	private String hash;
	private String salt;
	private Integer priority;
}
