package com.jatson.mainApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JatsonApplication {//

	public static void main(String[] args) {
		SpringApplication.run(JatsonApplication.class, args);
		Vision vsn = new Vision("D:/NvidiaCourse/JatsonNvidia/jatson/src/main/java/com/jatson/mainApplication/Assets/imgs/img005.png", "D:\\NvidiaCourse\\JatsonNvidia\\jatson\\src\\main\\java\\com\\jatson\\mainApplication\\Assets\\outputImg\\", 768, "img005") ;
		vsn.loadPipeline() ;
	}
}
