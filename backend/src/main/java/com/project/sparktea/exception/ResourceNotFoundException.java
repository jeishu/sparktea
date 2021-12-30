package com.project.sparktea.exception;

<<<<<<< HEAD
=======
import lombok.Data;

>>>>>>> main
public @Data class  ResourceNotFoundException extends RuntimeException{
private String resourceName;
private String fieldName;
private Object fieldValue;

	public ResourceNotFoundException(String resourceName,String fieldName,Object fieldValue) {
		super(String.format("% not found with %s : '%s'", resourceName,fieldName, fieldValue));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;
	
	}

}
