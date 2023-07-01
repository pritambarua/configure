package com.example.configure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.example.configure.search")
public class ConfigureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigureApplication.class, args);
	}

}
