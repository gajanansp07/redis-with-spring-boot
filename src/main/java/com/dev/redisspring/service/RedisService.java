package com.dev.redisspring.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class RedisService {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	RedisTemplate redisTemplate;
	private ObjectMapper mapper = new ObjectMapper();
	
	public <T> T get(String key,Class<T> respClass) {
		Object o = redisTemplate.opsForValue().get(key);
		try {
			return mapper.readValue(o.toString(), respClass);
		} catch (JsonProcessingException e) {
			log.error("Redis value Processing Exception: {}",e);
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void set(String key, Object value, Long ttl) {
		try {
			String val = mapper.writeValueAsString(value);
			redisTemplate.opsForValue().set(key, val,ttl,TimeUnit.SECONDS);
		}catch (Exception e) {
			log.error("Exception to Set Redis value: {}",e);
		}
	}

}
