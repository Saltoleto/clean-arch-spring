package br.com.cleanarchspring.core.usecase;

import br.com.cleanarchspring.core.model.UserRequestModel;
import br.com.cleanarchspring.core.model.UserResponseModel;
import org.hibernate.service.spi.InjectService;
import org.springframework.stereotype.Component;

/**
 * @author Fernando Saltoleto
 */
public interface UserCreateInputBoundary {
    UserResponseModel register(UserRequestModel requestModel);
}
