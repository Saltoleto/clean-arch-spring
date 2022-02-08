package br.com.cleanarchspring.core.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author Fernando Saltoleto
 */
@NoArgsConstructor
public class UserId {

    @Getter
    private Integer id;

    public static UserId from(Integer id) {
        return new UserId(id);
    }

    private UserId(final Integer id) {
        Objects.requireNonNull(id, "Id number cant be null");
        this.id = id;
    }
}
