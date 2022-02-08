package br.com.cleanarchspring.core.entities;

import br.com.cleanarchspring.core.vo.Age;
import br.com.cleanarchspring.core.vo.Name;

/**
 * @author Fernando Saltoleto
 */
public interface User {
    Age getAge();

    Name getName();

}
