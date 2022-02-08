package br.com.cleanarchspring.core.model;

import lombok.*;

/**
 * @author Fernando Saltoleto
 */
@Builder
@Data
@AllArgsConstructor
public class UserResponseModel {
    String name;
    String creationTime;
}
