//package com.dev.redisspring.service;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//
//@SpringBootTest
//public class RedisTest {
//	
//	@Autowired
//	RedisTemplate redisTemplate;
//	
//	@Test
//	void getSetValue() {
//		redisTemplate.opsForValue().set("email", "gajanansp07@gmail.com");
//		Object email = redisTemplate.opsForValue().get("email");
//		Object name = redisTemplate.opsForValue().get("name");
//		System.out.println(name);
//		//redisTemplate.opsForValue().set("name","Tulasi");
//	//	name = redisTemplate.opsForValue().get("name");
//		System.out.println(email);
//		System.out.println(name);
//		
//	}
//
//}
