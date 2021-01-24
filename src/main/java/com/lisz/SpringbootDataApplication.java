package com.lisz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //避免循环引用
// 各种Component类，必须放在比这个main Class级别更低的包里，否则就要加@ComponentScan来指定
// SpringBootApplication类的注解怎么最后把选择器拿出来，是要解决的问题
// SpringApplication类中的prepareContext()和refreshContext()是重点，在Spring源码中也有涉及
// 如果Springboot的banner/logo没有打印出来就出错，基本可以断定，在prepare（Listener处理prepareEvent）的时候出错了
public class SpringbootDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataApplication.class, args);
	}

}
