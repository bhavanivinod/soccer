package com.htc.SoccerApp.Exception;

import org.springframework.http.HttpStatus;
public class TaskHandler extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;
    private HttpStatus httpStatus;
    public TaskHandler(String message, HttpStatus httpStatus)
    {
        super();
        this.message = message;
        this.httpStatus = httpStatus;
    }
    public TaskHandler(String message)
    {
        super();
        this.message = message;
    }
    public TaskHandler(HttpStatus httpStatus)
    {
        super();
        this.httpStatus = httpStatus;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
	@Override
	public String toString() {
		return "TaskHandler [message=" + message + ", httpStatus=" + httpStatus + "]";
	}
}
