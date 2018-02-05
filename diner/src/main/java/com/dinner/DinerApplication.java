package com.dinner;

import com.base.util.redis.RedisCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DinerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DinerApplication.class, args);
	}


	@Bean
	public RedisCache redisCache(){
		return new RedisCache();
	}
}
