package com.mkd.adtools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * Hello world!
 *
 */

@SpringBootApplication
@MapperScan("com.mkd.adtools.mapper")
@EnableTransactionManagement
@EnableScheduling 
@ServletComponentScan 
public class App extends SpringBootServletInitializer
{
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
