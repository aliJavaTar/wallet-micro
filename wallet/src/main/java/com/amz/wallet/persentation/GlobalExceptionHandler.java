package com.amz.wallet.persentation;

import com.amz.wallet.application.ApplicationException;
import com.amz.wallet.application.ErrorType;
import com.amz.wallet.persentation.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException exception, WebRequest request) {
        log.error("Application Exception occurred", exception);

        ErrorType errorType = exception.getErrorType();
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();

        var errorResponse = buildErrorResponse(errorType.getHttpStatus().value(),
                errorType.getErrorCode(), errorType.name(),
                exception.getMessage(), path);

        return ResponseEntity.status(errorType.getHttpStatus()).body(errorResponse);
    }

    private ErrorResponse buildErrorResponse(int status, int errorCode, String errorType, String message, String path) {
        return ErrorResponse.builder()
                .status(status)
                .errorCode(errorCode)
                .errorType(errorType)
                .message(message)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
