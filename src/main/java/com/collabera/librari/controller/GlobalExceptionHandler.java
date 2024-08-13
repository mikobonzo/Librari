/**
 * 
 */
package com.collabera.librari.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author User
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleMissingParams(MissingServletRequestParameterException ex) {
        String parameterName = ex.getParameterName();
        String message = "The required parameter '" + parameterName + "' is missing.";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

}
