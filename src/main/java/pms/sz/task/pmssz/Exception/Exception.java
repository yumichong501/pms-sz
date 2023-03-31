package pms.sz.task.pmssz.Exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pms.sz.task.pmssz.Utils.ResponseUtils;

import java.util.HashMap;
import java.util.stream.Collectors;

@RestControllerAdvice
public class Exception {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public JsonResponseInfo handleValidException(MethodArgumentNotValidException e){
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResponseUtils.ExceptionReturn(1,objectError.getDefaultMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public JsonResponseInfo handleConstraintViolationException(ConstraintViolationException e){
        return ResponseUtils.ExceptionReturn(
                1,
                e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList()).get(0)
        );
    }

    @ExceptionHandler(value = java.lang.Exception.class)
    public JsonResponseInfo handleException(java.lang.Exception e){
        return ResponseUtils.ExceptionReturn(1,e.getMessage());
    }
}
