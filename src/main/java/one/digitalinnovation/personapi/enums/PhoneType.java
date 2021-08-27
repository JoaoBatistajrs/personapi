package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

        HOME ("home"),
        MOBILE ("Mobile"),
        COMMERCIAL("Comercial");

        private final String description;

}
