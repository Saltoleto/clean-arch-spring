package br.com.cleanarchspring.core.usecase;

import br.com.cleanarchspring.core.model.UserDsRequestModel;

/**
 * @author Fernando Saltoleto
 */
public interface UserRegisterDsGateway {

    void register(UserDsRequestModel requestModel);

    boolean userAlreadyByNameAndAge(String name, Integer age);
}
