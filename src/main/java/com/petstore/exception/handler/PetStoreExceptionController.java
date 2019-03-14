package com.petstore.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.petstore.controller.PetController;
import com.petstore.controller.util.ApiErrorVO;
import com.petstore.exception.NoDataFoundException;
import com.petstore.exception.PetStoreCustomException;
import com.petstore.exception.UserAuthenticationException;

@ControllerAdvice
public class PetStoreExceptionController {
	
	Logger logger = LoggerFactory.getLogger(PetStoreExceptionController.class);

	@ExceptionHandler(value = PetStoreCustomException.class)
	public ResponseEntity<Object> petStoreCustomExceptionHandler(PetStoreCustomException exception) {
		String message = exception.getLocalizedMessage();
		message = (message == null ? exception.getMessage():message);
		HttpStatus status = exception.getStatus() == null ? HttpStatus.BAD_REQUEST : exception.getStatus();
		return new ResponseEntity<>(message, status);
	}
	
	@ExceptionHandler(value = {NoDataFoundException.class})
	public ResponseEntity<Object> noDataFoundExceptionHandler(NoDataFoundException exception) {
		String message = exception.getLocalizedMessage();
		message = (message == null ? exception.getMessage():message);
		HttpStatus status = exception.getStatus() == null ? HttpStatus.NOT_FOUND : exception.getStatus();
		return new ResponseEntity<>(message, status);
	}
	
	@ExceptionHandler(value = UserAuthenticationException.class)
	public ResponseEntity<Object> UserAuthenticationException(UserAuthenticationException exception) {
		String message = exception.getLocalizedMessage();
		message = (message == null ? exception.getMessage():message);
		HttpStatus status = exception.getStatus() == null ? HttpStatus.UNAUTHORIZED : exception.getStatus();
		return new ResponseEntity<>(message, status);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorVO> handleValidationError(MethodArgumentNotValidException ex) {
		logger.info("handleValidationError");
        BindingResult bindingResult = ex.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        ApiErrorVO apiErrorVO = new ApiErrorVO("VALIDATION_FAILED", defaultMessage);
        return new ResponseEntity<ApiErrorVO>(apiErrorVO, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> defaultExceptionHandler(Exception ex) {
		logger.info("handleValidationError");
        String defaultMessage = ex.getMessage();
        return new ResponseEntity<Object>(defaultMessage, HttpStatus.BAD_REQUEST);
    }
	
}
