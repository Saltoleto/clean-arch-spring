package br.com.cleanarchspring.presenter;

import br.com.cleanarchspring.core.model.UserResponseModel;

/**
 * @author Fernando Saltoleto
 */
public interface UserPresenter {
    UserResponseModel prepareSuccessView(UserResponseModel user);

    UserResponseModel prepareFailView(String error);
}
