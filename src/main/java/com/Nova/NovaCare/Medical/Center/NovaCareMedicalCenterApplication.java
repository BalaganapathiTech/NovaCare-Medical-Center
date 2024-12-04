package com.Nova.NovaCare.Medical.Center;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

import java.util.Collections;
@SpringBootApplication
public class NovaCareMedicalCenterApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(NovaCareMedicalCenterApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", System.getenv("PORT")));
		app.run(args);
	}
}