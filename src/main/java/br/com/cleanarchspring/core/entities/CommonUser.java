package br.com.cleanarchspring.core.entities;

import br.com.cleanarchspring.core.vo.Age;
import br.com.cleanarchspring.core.vo.Name;
import br.com.cleanarchspring.core.vo.UserId;
import lombok.*;

/**
 * @author Fernando Saltoleto
 */
@Builder
@ToString
@Getter
@EqualsAndHashCode
public class CommonUser implements User{
    private final UserId userId;
    private final Name name;
    private final Age age;
}
