package com.jatson.mainApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JatsonApplicationTests {

	@Test
	void contextLoads() throws IOException {
		String current_dir = System.getProperty("user.dir");
		File fi = new File(current_dir+"\\src\\main\\resources\\static\\upload\\DetectedImg\\detectedImg.png");
		byte[] bytes = Files.readAllBytes(fi.toPath());
		String base64Img = Base64.getEncoder().encodeToString(bytes) ;
		System.out.println(base64Img) ;
	}

}
