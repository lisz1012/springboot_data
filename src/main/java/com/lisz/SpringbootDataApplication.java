package com.lisz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //避免循环引用
// 各种Component类，必须放在比这个main Class级别更低的包里，否则就要加@ComponentScan来指定
// SpringBootApplication类的注解怎么最后把选择器拿出来，是要解决的问题
// SpringApplication类中的prepareContext()和refreshContext()是重点，在Spring源码中也有涉及
// 如果Springboot的banner/logo没有打印出来就出错，基本可以断定，在prepare（Listener处理prepareEvent）的时候出错了，比如：
// Log在写启动日志的时候，并没有写权限，或者找不到目标目录等，就会折在这里。Banner是否打印出来其实也可以作为一个大致判断出错位置的标记
// PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors()比较核心 -> invokeBeanDefinitionRegistryPostProcessor() 最核心的整体处理环节
// 循环中会加载启动类
// componentScanParser.parse(componentScan, sourceClass.getMetadata().getClassName()); 扫描到了所有被Spring自动装配的类
// ImportSelector是按照主类的标签，挨个递归查找的，所有@Import后面括号里的类都加进去
// Springboot内嵌的Tomcat是在AbstractApplicationContext.onRefresh的时候加载的,里面有个createWebServer方法，其中的
// this.webServer = factory.getWebServer(getSelfInitializer());中便有创建Tomcatwebserver的代码
// SpringApplication.prepareContext() 会把启动类加载到上下文应用环境里面（load方法）

// 简而言之就是读取spring.factories这个文件，在某些配置的类上面添加一些注解，让他们能够被扫描到
// AutoConfigurationImportSelector.getCandidateConfigurations()方法中，加载了spring.factories中的类
// Program Arguments的 --debug参数可以使得Springboot在启动的时候，把自动装配的类都打印出来
public class SpringbootDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataApplication.class, args);
	}

}
