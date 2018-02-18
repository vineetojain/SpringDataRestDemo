package com.example.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.exceptions.EmployeeNotFoundException;
import com.example.exceptions.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Employee Not Found")
	@ExceptionHandler(EmployeeNotFoundException.class)
	public @ResponseBody ErrorInfo handleException(HttpServletRequest req, 
										EmployeeNotFoundException e) {
		System.out.println("Inside Global Exception Handler");
		System.out.println(req.getRequestURI() + " : " + e.getMessage());
		return new ErrorInfo(req.getRequestURI(),e.getMessage());
	}
}
