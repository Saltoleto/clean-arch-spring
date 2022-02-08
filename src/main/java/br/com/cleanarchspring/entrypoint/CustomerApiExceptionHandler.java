package br.com.cleanarchspring.entrypoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fernando Saltoleto
 */
@ControllerAdvice
public class CustomerApiExceptionHandler extends ResponseEntityExceptionHandler {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseBody
    private ResponseEntity<?> exceptions(ResponseStatusException exception) {
        this.logger.error(exception.getMessage(), exception);
        Map<String,String> attributes = new HashMap<>() {{
            put("message", exception.getMessage());
        }};
        return new ResponseEntity<>(attributes, exception.getStatus());
    }
}
