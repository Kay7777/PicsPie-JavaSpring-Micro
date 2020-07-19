package com.kaysong.picspieeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PicspieEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicspieEurekaApplication.class, args);
	}

}
