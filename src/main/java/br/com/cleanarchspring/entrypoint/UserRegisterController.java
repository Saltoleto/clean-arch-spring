package br.com.cleanarchspring.entrypoint;

import br.com.cleanarchspring.core.model.UserRequestModel;
import br.com.cleanarchspring.core.model.UserResponseModel;
import br.com.cleanarchspring.core.usecase.UserCreateInputBoundary;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fernando Saltoleto
 */
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserRegisterController {

    final UserCreateInputBoundary accountGateway;

    @PostMapping("/user")
    UserResponseModel create(@RequestBody UserRequestModel requestModel) {
        return accountGateway.register(requestModel);
    }
}
