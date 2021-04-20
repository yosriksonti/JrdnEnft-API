package tn.kindergarten.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileStorageProperties {
	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	public FileStorageProperties(String uploadDir) {
		super();
		this.uploadDir = uploadDir;
	}

	public FileStorageProperties() {
		super();
	}
	
}
