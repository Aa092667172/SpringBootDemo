package com.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handle(RuntimeException exception){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("RuntimeException:"+ exception.getMessage());
    }

//    /**
//     * 有繼承關係 如無IllegalArgumentException會去尋找有否處理父類的
//     * @param exception
//     * @return
//     */
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<String> handle(IllegalArgumentException exception){
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body("RuntimeException:"+ exception.getMessage());
//    }
}
