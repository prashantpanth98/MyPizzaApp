package com.niit.PizzaService;

import com.niit.PizzaService.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class PizzaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PizzaServiceApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean filterRegBean=new FilterRegistrationBean();
		filterRegBean.setFilter(new JwtFilter());
		filterRegBean.addUrlPatterns("/api/v2/*");

		return filterRegBean;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		final UrlBasedCorsConfigurationSource corsConfigSource = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration corsConfig=new CorsConfiguration();

		corsConfig.setAllowCredentials(true);
		corsConfig.addAllowedOrigin("http://localhost:4200");
		corsConfig.addAllowedHeader("*");
		corsConfig.addAllowedMethod("*");

		corsConfigSource.registerCorsConfiguration("/**",corsConfig);
		FilterRegistrationBean fRegBean=new FilterRegistrationBean(new CorsFilter(corsConfigSource));
		fRegBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return fRegBean;
	}
}



