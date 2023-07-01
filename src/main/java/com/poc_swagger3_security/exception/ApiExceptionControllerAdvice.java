package com.poc_swagger3_security.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
public class ApiExceptionControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleException(Exception ex) {
        logger.error("Se produjo una excepción", ex);
        return createApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.dao.DuplicateKeyException.class,
            org.springframework.web.bind.support.WebExchangeBindException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class,
            org.springframework.web.server.ServerWebInputException.class
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleBadRequest(Exception ex) {
        logger.info("Manejando excepción de solicitud incorrecta");
        return createApiError(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFound(Exception ex) {
        logger.info("Manejando excepción de recurso no encontrado");
        return createApiError(HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BindingErrorsResponse handleValidationException(MethodArgumentNotValidException ex) {
        logger.info("Manejando excepción de validación");
        BindingErrorsResponse errorsResponse = new BindingErrorsResponse();
        errorsResponse.addAllErrors(ex.getBindingResult());
        return errorsResponse;
    }

    private ApiError createApiError(HttpStatus status, Exception ex) {
        return new ApiError(
                status.value(),
                ex.getClass().getName(),
                ex.getMessage()
        );
    }
}