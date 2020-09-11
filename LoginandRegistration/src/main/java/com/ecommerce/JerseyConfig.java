package com.ecommerce;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ecommerce.rest.services.RestAPI;
import com.ecommerce.util.CORSResponseFilter;

@Configuration
@EnableAutoConfiguration
//@ComponentScan(basePackages= "com.topper.education.*")
//@EntityScan("com.topper.education.dto")
//@EnableJpaRepositories("com.topper.education.Repo")
public class JerseyConfig extends ResourceConfig{
    
	public JerseyConfig()
	{
		register(RestAPI.class);
		register(CORSResponseFilter.class);
	}
}
