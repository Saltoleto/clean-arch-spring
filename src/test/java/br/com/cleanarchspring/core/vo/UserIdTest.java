package br.com.cleanarchspring.core.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Fernando Saltoleto
 */
class UserIdTest {

    @Test
    void sholdThrowNullPointerExceptioWhenIdIsNull(){
        assertThatThrownBy(() -> UserId.from(null))
                .hasMessage("Id number cant be null");
    }

    @Test
    void sholdCreateUserId(){
        assertThat(UserId.from(1).getId())
                .isNotNull()
                .isEqualTo(1);
    }
}