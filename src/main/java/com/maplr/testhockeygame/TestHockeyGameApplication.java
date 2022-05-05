package com.maplr.testhockeygame;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestHockeyGameApplication implements InitializingBean {

	public static void main(String[] args) {
		SpringApplication.run(TestHockeyGameApplication.class, args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}
}
