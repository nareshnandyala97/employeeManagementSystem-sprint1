package com.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private String resouceName;
	private String fileName;
	private Object fieldValue;
	
	
	
	public ResourceNotFoundException(String resourceName,String fileName,Object fieldValue) {
		super(String.format("%s not found with %s ,'%s ",resourceName,fileName,fieldValue));
		this.resouceName=resourceName;
		this.fileName=fileName;
		this.fieldValue=fieldValue;
	}



	public String getResouceName() {
		return resouceName;
	}



	public void setResouceName(String resouceName) {
		this.resouceName = resouceName;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public Object getFieldValue() {
		return fieldValue;
	}



	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
	
	
	

}
