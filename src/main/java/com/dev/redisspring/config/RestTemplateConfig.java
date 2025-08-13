package com.dev.redisspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	public static RestTemplate rst=null;
	
	@Bean
	public RestTemplate getRestTemplate() {
		if(rst==null) {
			if(ObjectUtils.isEmpty(rst)) {
				rst = new RestTemplate();
			}
		}
		return rst;
	}

}
