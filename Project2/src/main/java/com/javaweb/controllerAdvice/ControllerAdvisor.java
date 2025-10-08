package com.javaweb.controllerAdvice;

import java.net.http.HttpHeaders;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.customeException.FieldRequiredException;
import com.javaweb.model.ErrorResponseDTO;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmeticException(
			ArithmeticException ex, WebRequest request){
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Không thể chia cho 0");
		errorResponseDTO.setDetail(details);
		return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<Object> handleFieldRequiredException(
			FieldRequiredException ex, WebRequest request){
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Kiểm tra lại name hoặc numberofbasement");
		errorResponseDTO.setDetail(details);
		return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
	}
	
}
