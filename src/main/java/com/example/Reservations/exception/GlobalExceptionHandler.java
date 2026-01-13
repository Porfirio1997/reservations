package com.example.Reservations.exception;
import com.example.Reservations.dto.exception.ErrorObjectDTO;
import com.example.Reservations.dto.exception.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final static String MESSAGE_ERROR_DTO = "Request has invalid fields";
    private final static String MESSAGE_ERROR_DTO_KEY = "request.invalid.fields";

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        var response  = new ErrorResponseDTO(ex.getMessage(),MESSAGE_ERROR_DTO_KEY, "", null);
        return new ResponseEntity<>(response, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ErrorObjectDTO> errors = getErrors(ex);
        ErrorResponseDTO errorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorResponseDTO getErrorResponse(MethodArgumentNotValidException ex, HttpStatusCode status, List<ErrorObjectDTO> errors) {
        return new ErrorResponseDTO(MESSAGE_ERROR_DTO,MESSAGE_ERROR_DTO_KEY, ex.getBindingResult().getObjectName(), errors);
    }

    private List<ErrorObjectDTO> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObjectDTO(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }

}