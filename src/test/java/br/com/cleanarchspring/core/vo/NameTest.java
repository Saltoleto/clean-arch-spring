package br.com.cleanarchspring.core.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Fernando Saltoleto
 */
class NameTest {

    @Test
    void sholdThrowNullPointerExceptioWhenNameIsNull(){
        assertThatThrownBy(() -> Name.from(null, "Saltoleto"))
                .hasMessage("Name cant be null");
    }


    @Test
    void sholdThrowNullPointerExceptioWhenLastNameIsNull(){
        assertThatThrownBy(() -> Name.from("Fernando",null ))
                .hasMessage("LastName cant be null");
    }

    @Test
    void sholdCreateNameWithNameAndLastName(){
        var name = "Fernando";
        var lastName = "Saltoleto";
        assertThat(Name.from(name,lastName).getName())
                .isNotNull()
                .isEqualTo(name);
        assertThat(Name.from(name,lastName).getLastName())
                .isNotNull()
                .isEqualTo(lastName);
    }

    @Test
    void sholdCreateNameWithNameAndLastNameAndGetFullName(){
        var name = "Fernando";
        var lastName = "Saltoleto";
        assertThat(Name.from(name,lastName).getFullName())
                .isNotNull()
                .isEqualTo(name.concat(" ").concat(lastName));
    }

}