package io.github.aquilesdias.clinsys_api.domain.enums;

import lombok.Getter;

@Getter
public enum UserRole {

    ROLE_ADMIN("admin"),
    ROLE_SECRETARIA("secretaria"),
    ROLE_MEDICO("medico"),
    ROLE_PACIENTE("paciente");

    private String role;

    UserRole(String role ) {
        this.role = role;
    }
}
