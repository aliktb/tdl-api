package com.example.tdl;

import com.example.tdl.ratelimiting.RateLimitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TDLApplication implements WebMvcConfigurer {

	@Autowired
	@Lazy
	private RateLimitInterceptor rateLimitInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(rateLimitInterceptor)
				.addPathPatterns("/tasks/**");
	}

	public static void main(String[] args) {
		SpringApplication.run(TDLApplication.class, args);
	}

}
