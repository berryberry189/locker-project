package com.jpa.lendlocker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

/**
 * 공통 예외처리 클래스
 */
@Slf4j
@RestControllerAdvice
public class ExceptionController {

    /**
     * PK로 조회 시 결과 값이 없을 경우 응답코드 404 반환
     * @param e
     * @return
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entityNotFoundException(EntityNotFoundException e) {
        log.info("error", e);
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * 클라이언트 입력 값이 유효하지 않을 경우 응답코드 400 반환
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity illegalArgumentException(IllegalArgumentException e) {
        log.info("error", e);
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
