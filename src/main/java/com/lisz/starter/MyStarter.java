package com.lisz.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "enabled.autoConfiguration", matchIfMissing = true)
public class MyStarter {

	static {
		System.out.println("MyStarter inited ... ");
	}

	@Bean
	public Person person(){
		return new Person();
	}
}
