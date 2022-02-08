package br.com.cleanarchspring.core.entities;

import br.com.cleanarchspring.core.model.UserRequestModel;
import br.com.cleanarchspring.core.vo.Age;
import br.com.cleanarchspring.core.vo.Name;

/**
 * @author Fernando Saltoleto
 */
public class CommonUserFactory implements UserFactory {
    @Override
    public CommonUser create(UserRequestModel userRequestModel) {
        return CommonUser.builder()
                .name(Name.from(userRequestModel.getName(), userRequestModel.getLastName()))
                .age(Age.from(userRequestModel.getAge())).build();
    }
}
