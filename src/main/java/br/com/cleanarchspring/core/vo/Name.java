package br.com.cleanarchspring.core.vo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author Fernando Saltoleto
 */
@Data
@NoArgsConstructor
public class Name {

    @Getter
    private String name;
    @Getter
    private String lastName;

    public static Name from(String name, String lastName) {
        return new Name(name,lastName);
    }

     Name(final String name, final String lastName) {
         Objects.requireNonNull(name, "Name cant be null");
         Objects.requireNonNull(name, "LastName cant be null");
         this.name = name;
         this.lastName = lastName;
    }

    public String getFullName(){
        return this.name.concat(" ").concat(this.lastName);
    }


}
