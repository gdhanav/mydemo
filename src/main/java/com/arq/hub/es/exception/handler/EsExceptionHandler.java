package com.arq.hub.es.exception.handler;

import com.arq.hub.es.exception.EmployeeNotFound;
import com.arq.hub.es.exception.EmployeeServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EsExceptionHandler {

    @ExceptionHandler (value={EmployeeNotFound.class})
    public ResponseEntity<ErroMsg> handleNotFoundException(Exception ex){
        ErroMsg error = new ErroMsg(ex.getMessage(), HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(value={EmployeeServiceException.class})
    public ResponseEntity<ErroMsg> handleProcessingException(Exception ex){
        ErroMsg error = new ErroMsg(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.name());
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
