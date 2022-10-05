package com.infinira.ems.customexception;

public class EMSException extends RuntimeException{
	public EMSException(String message,Throwable th) {
		super(message,th);
	}
}