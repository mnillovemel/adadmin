package com.mkd.adtools.configs;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 跨域设置
 * @author d
 *
 */
@Configuration
public class CorsWebAppConfig extends WebMvcConfigurerAdapter {

		@Bean
		public FilterRegistrationBean corsFilter() {
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowCredentials(true);
			config.addAllowedOrigin("*");
			config.addAllowedHeader("*");
			config.addAllowedMethod("*");
			source.registerCorsConfiguration("/**", config);
			FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
			bean.setOrder(0);
			return bean;
		}
		
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("*","*")
	                .allowCredentials(true)
	                .allowedMethods("GET", "POST", "DELETE", "PUT","OPTIONS")
	                .maxAge(3600);
	    }


}
