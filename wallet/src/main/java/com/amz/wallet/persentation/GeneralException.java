//package com.amz.wallet.persentation;
//
//import com.amz.wallet.application.WalletNotFoundException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@RestControllerAdvice
//@Slf4j
//public class GeneralException extends ResponseEntityExceptionHandler {
//
//    public ResponseEntity<ErrorResponse>
//    handleWalletException(WalletNotFoundException exception, WebRequest request) {
//        log.error("WalletNotFoundException : {} ", exception.getMessage());
//
//    }
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex,
//            HttpHeaders headers,
//            HttpStatusCode status,
//            WebRequest request) {
//
//        log.warn("Validation error: {}", ex.getMessage());
//
//        Map<String, String> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
//                .collect(Collectors.toMap(
//                        FieldError::getField,
//                        fieldError -> fieldError.getDefaultMessage() == null ? "Invalid value" : fieldError.getDefaultMessage(),
//                        (error1, error2) -> error1 + ", " + error2));
//
//        ErrorResponse errorResponse = buildErrorResponse(
//                HttpStatus.BAD_REQUEST.value(),
//                ErrorType.VALIDATION_ERROR.getErrorCode(),
//                ErrorType.VALIDATION_ERROR.name(),
//                ErrorType.VALIDATION_ERROR.getDefaultMessage(),
//                request.getDescription(false)
//        );
//        errorResponse.setValidationErrors(fieldErrors);
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
//}
