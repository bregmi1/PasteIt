package com.regmi.bijay.pasteit.controllers.exception.handlers;

import com.regmi.bijay.pasteit.Application;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.InvalidParameterException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public void entityNotFoundExceptionHandler(HttpServletResponse response, EntityNotFoundException e) throws Exception{
        response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(value = InvalidParameterException.class)
    public void invalidParameterExceptionHandler(HttpServletResponse response, InvalidParameterException e) throws Exception{
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
    }
}
