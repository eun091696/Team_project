package com.teamproject.mvc20221004teamproject.api.advice;

import com.teamproject.mvc20221004teamproject.dto.CMRespDto;
import com.teamproject.mvc20221004teamproject.exception.CustomInternalServerException;
import com.teamproject.mvc20221004teamproject.exception.CustomValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class) //예외처리가 Mapping 역할
    public ResponseEntity<?> validationErrorException(CustomValidationException e) {

        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }

    @ExceptionHandler(CustomInternalServerException.class)
    public ResponseEntity<?> internalServerErrorException(CustomInternalServerException e) {

        return ResponseEntity.internalServerError().body(new CMRespDto<>(e.getMessage(), null));
    }


}
