package br.com.cleanarchspring.dataprovider;

import br.com.cleanarchspring.dataprovider.UserDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Fernando Saltoleto
 */
public interface JpaUserRepository extends JpaRepository<UserDataMapper, String> {
    Optional<UserDataMapper> findByFirstNameAndAge(String firstName, Integer age);
}
