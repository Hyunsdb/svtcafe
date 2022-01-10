package com.hyuns.svtcafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SvtcafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvtcafeApplication.class, args);
	}

}
