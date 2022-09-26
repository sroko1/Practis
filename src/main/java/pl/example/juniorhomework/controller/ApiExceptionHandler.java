package pl.example.juniorhomework.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.example.juniorhomework.exception.CustomErrorResponse;
import pl.example.juniorhomework.exception.UsernameNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {
    private final String responseCode;
    private final String msg;

    public ApiExceptionHandler(
            @Value("responseCode") String responseCode,
            @Value("whyHasItHappened") String msg) {
        this.responseCode = responseCode;
        this.msg = msg;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleApiException(
            UsernameNotFoundException eu) {
        CustomErrorResponse response =
                new CustomErrorResponse(responseCode + " : " + HttpStatus.valueOf(404),
                        msg);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}