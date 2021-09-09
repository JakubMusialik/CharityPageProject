package pl.coderslab.charity.validator;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {
    private final String name;
    private final String surname;
    private final String email;
    private final String password;

}
