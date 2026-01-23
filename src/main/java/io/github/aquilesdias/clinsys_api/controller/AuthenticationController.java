package io.github.aquilesdias.clinsys_api.controller;

import io.github.aquilesdias.clinsys_api.controller.dto.AuthenticationDTO;
import io.github.aquilesdias.clinsys_api.controller.dto.LoginResponseDTO;
import io.github.aquilesdias.clinsys_api.controller.dto.RegisterDTO;
import io.github.aquilesdias.clinsys_api.domain.Usuario;
import io.github.aquilesdias.clinsys_api.infra.security.TokenService;
import io.github.aquilesdias.clinsys_api.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO loginDTO) {

        var usernamePassword = new UsernamePasswordAuthenticationToken( loginDTO.login(), loginDTO.password() );
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){

        if(this.usuarioRepository.findByLogin(registerDTO.login()) != null ) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());

        Usuario usuario = new Usuario(registerDTO.login(), encryptedPassword,  registerDTO.role());

        usuarioRepository.save(usuario);

        return ResponseEntity.ok().build();

    }
}
