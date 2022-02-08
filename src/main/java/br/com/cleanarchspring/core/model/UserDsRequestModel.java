package br.com.cleanarchspring.core.model;

import br.com.cleanarchspring.core.entities.CommonUser;
import br.com.cleanarchspring.core.entities.User;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author Fernando Saltoleto
 */
@ToString
@Getter
@EqualsAndHashCode
public class UserDsRequestModel {
    String name;
    String lasName;
    Integer age;
    LocalDateTime creationTime = LocalDateTime.now();

    public UserDsRequestModel(String name, String lasName, Integer age) {
        this.name = name;
        this.lasName = lasName;
        this.age = age;
    }

    public static UserDsRequestModel fromUser(User user){
        return new UserDsRequestModel(user.getName().getName(), user.getName().getLastName(), user.getAge().getAge());
    }

}
