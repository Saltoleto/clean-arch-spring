package br.com.cleanarchspring.core.usecase;

import br.com.cleanarchspring.core.entities.User;
import br.com.cleanarchspring.core.model.UserDsRequestModel;
import br.com.cleanarchspring.core.entities.UserFactory;
import br.com.cleanarchspring.core.model.UserRequestModel;
import br.com.cleanarchspring.core.model.UserResponseModel;
import br.com.cleanarchspring.presenter.UserPresenter;

import java.time.LocalDateTime;

/**
 * @author Fernando Saltoleto
 */
public class UserCreateRegisterUseCase implements UserCreateInputBoundary {

    final UserRegisterDsGateway userDsGateway;
    final UserPresenter userPresenter;
    final UserFactory userFactory;

    UserCreateRegisterUseCase(UserRegisterDsGateway userRegisterDfGateway, UserPresenter userPresenter,
                              UserFactory userFactory) {
        this.userDsGateway = userRegisterDfGateway;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }

    @Override
    public UserResponseModel register(UserRequestModel requestModel) {
        if (userDsGateway.userAlreadyByNameAndAge(requestModel.getName(),requestModel.getAge())) {
            return userPresenter.prepareFailView("CommonUser already exists.");
        }
        User user = userFactory.create(requestModel);

        UserDsRequestModel userDsModel =  UserDsRequestModel.fromUser(user);

        userDsGateway.register(userDsModel);

        UserResponseModel accountResponseModel = new UserResponseModel(user.getName().getName(), LocalDateTime.now().toString());
        return userPresenter.prepareSuccessView(accountResponseModel);
    }

}
