package com.portafolio.gcs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class Credentials {
	
	@Value("${gcs.project.id}")
    private String ProjectId;
	
    @Value("${gcs.bucket.name}")
    private String BucketName;

	public String getProjectId() {
		return ProjectId;
	}

	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}

	public String getBucketName() {
		return BucketName;
	}

	public void setBucketName(String bucketName) {
		BucketName = bucketName;
	}

}
