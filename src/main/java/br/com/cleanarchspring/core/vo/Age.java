package br.com.cleanarchspring.core.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author Fernando Saltoleto
 */
@NoArgsConstructor
public class Age {

    @Getter
    private Integer age;

    public static Age from(Integer age) {
        return new Age(age);
    }

    Age(final Integer age) {
        Objects.requireNonNull(age, "Age number cant be null");
        this.age = age;
    }

}