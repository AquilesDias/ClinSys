package io.github.aquilesdias.clinsys_api.controller.dto;

import io.github.aquilesdias.clinsys_api.domain.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
