package br.com.cleanarchspring.core.entities;

import br.com.cleanarchspring.core.model.UserRequestModel;

/**
 * @author Fernando Saltoleto
 */
public interface UserFactory {
    CommonUser create(UserRequestModel userRequestModel);
}
