package com.expensetracker.management.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.expensetracker.management.dto.RestResponse;

@Service
public class ErrorResponse {
	public ResponseEntity<Object> setValidationErrorResponse(BindingResult bindingResult) {
		List<Map<String, Object>> errors = new ArrayList<Map<String, Object>>();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		Map<String, Object> error;

		for (FieldError fieldError : fieldErrors) {
			error = new HashMap<String, Object>();
			error.put("field", fieldError.getField());
			error.put("message", fieldError.getDefaultMessage());
			errors.add(error);
		}

		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> setExceptionResponse(Exception e) {
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", e.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Object> setMandatoryDataValidationResponse() {
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Please select data");
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> setResponse(String message, HttpStatus status) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", message);
		return new ResponseEntity<Object>(response, status);
	}

	public RestResponse setRestResponse(String message, HttpStatus httpStatus) {
		RestResponse dataServicesRestResponse = new RestResponse();

		if (null != message && !message.isBlank() && !message.isEmpty())
			dataServicesRestResponse.setResponseBody(message);
		dataServicesRestResponse.setStatus(httpStatus);

		return dataServicesRestResponse;
	}

}
