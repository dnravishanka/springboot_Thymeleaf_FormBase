package com.example.springformbase_thymeleaf.adviser;

//import com.example.springboot2.handler.AppException;
import com.example.springformbase_thymeleaf.handler.AppException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppAdviser {
    @ExceptionHandler({Exception.class})
    public String handleMyException(Exception exception) {
        return exception.getMessage();
    }

    @ExceptionHandler({AppException.class})
    public String handlerException2(AppException appException) {
        return appException.getError();
    }
}
