package br.com.cleanarchspring.dataprovider;

import br.com.cleanarchspring.core.model.UserDsRequestModel;
import br.com.cleanarchspring.core.usecase.UserRegisterDsGateway;
import lombok.AllArgsConstructor;

/**
 * @author Fernando Saltoleto
 */
@AllArgsConstructor
public class JpaUser implements UserRegisterDsGateway {

    final JpaUserRepository repository;

    @Override
    public void register(UserDsRequestModel requestModel) {
        UserDataMapper dataMapper = UserDataMapper.builder()
                .firstName(requestModel.getName())
                .lastName(requestModel.getLasName())
                .age(requestModel.getAge()).build();
        repository.save(dataMapper);
    }

    @Override
    public boolean userAlreadyByNameAndAge(String name, Integer age) {
        return repository.findByFirstNameAndAge(name, age).isPresent();
    }


}
