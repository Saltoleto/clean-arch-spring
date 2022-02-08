package br.com.cleanarchspring.core.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Fernando Saltoleto
 */
@Builder
@ToString
@Getter
@EqualsAndHashCode
public class UserRequestModel {
    String name;
    String lastName;
    Integer age;
}
