package com.project.sparktea.bucket;

public enum BucketName {
	PROFILE_IMAGE("sparktea");
	
	private final String bucketName;
	
	BucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getBucketName() {
		return bucketName;
	}
	
	
}
