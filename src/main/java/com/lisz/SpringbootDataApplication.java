package com.lisz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //避免循环引用
public class SpringbootDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataApplication.class, args);
	}

}
