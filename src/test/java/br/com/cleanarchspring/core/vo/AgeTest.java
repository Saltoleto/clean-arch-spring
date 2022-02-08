package br.com.cleanarchspring.core.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Fernando Saltoleto
 */
class AgeTest {

    @Test
    void sholdThrowNullPointerExceptioWhenNameIsNull(){
        assertThatThrownBy(() -> Age.from(null))
                .hasMessage("Age number cant be null");
    }

    @Test
    void sholdCreateAge(){
        assertThat(Age.from(38).getAge())
                .isNotNull()
                .isEqualTo(38);
    }

}