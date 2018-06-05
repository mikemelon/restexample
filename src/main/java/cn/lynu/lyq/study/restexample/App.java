package cn.lynu.lyq.study.restexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class App extends SpringBootServletInitializer{
	
	//为支持war方式打包（在pom.xml中修改，并运行mvn package）而重写的方法
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}
	
	//支持直接运行或jar方式运行
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
