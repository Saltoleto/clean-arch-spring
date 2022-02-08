package br.com.cleanarchspring.core.usecase;

import br.com.cleanarchspring.core.entities.CommonUser;
import br.com.cleanarchspring.core.entities.CommonUserFactory;
import br.com.cleanarchspring.core.model.UserRequestModel;
import br.com.cleanarchspring.core.model.UserResponseModel;
import br.com.cleanarchspring.core.vo.Age;
import br.com.cleanarchspring.core.vo.Name;
import br.com.cleanarchspring.presenter.UserPresenter;
import br.com.cleanarchspring.presenter.UserResponseFormatter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

/**
 * @author Fernando Saltoleto
 */
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserCreateRegisterUseCaseTest {

    @Mock
    private UserRegisterDsGateway userDsGateway;

    String name = "Fernando";
    String lastName = "Saltoleto";
    Integer age = 38;
    UserPresenter userPresenter;
    CommonUserFactory userFactory;
    UserResponseModel userResponseModel;
    UserRequestModel userRequestModel;
    CommonUser commonUser;
    UserCreateRegisterUseCase useCase;

    @BeforeAll
    public void iniciar() {
        this.userPresenter = new UserResponseFormatter();
        this.userFactory = new CommonUserFactory();
        this.userResponseModel = UserResponseModel.builder()
                .name(name)
                .creationTime(LocalDateTime.now().toString())
                .build();
        this.userRequestModel = UserRequestModel.builder()
                .name(name)
                .lastName(lastName)
                .age(age).build();
        this.commonUser = CommonUser.builder()
                .name(Name.from(name, lastName))
                .age(Age.from(age))
                .build();
    }


    @Test
    void sholdRegisterUser(){
        useCase = new UserCreateRegisterUseCase(userDsGateway, userPresenter, userFactory);
        UserResponseModel register = useCase.register(userRequestModel);
        System.out.println(register);
    }


    @Test
    void sholdThrowResponseStatusExceptionWhenUserAlreadyByNameAndAge() {
        useCase = new UserCreateRegisterUseCase(userDsGateway, userPresenter, userFactory);
        when(userDsGateway.userAlreadyByNameAndAge(name, age)).thenReturn(true);
        assertThatThrownBy(() -> useCase.register(userRequestModel))
                .isInstanceOf(ResponseStatusException.class);
    }

}