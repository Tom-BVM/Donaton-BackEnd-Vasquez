package com.Donaton.MicroS_Auth.Controller;

import com.Donaton.MicroS_Auth.Model.Usuario;
import com.Donaton.MicroS_Auth.Service.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return usuarioService.registrar(usuario);
    }

    @PostMapping("/iniciar-sesion")
    public ResponseEntity<?> iniciarSesion(@RequestBody Usuario usuario) {
        Usuario u = usuarioService.buscarPorCorreo(usuario.getCorreo());
        if (u != null && u.getContraseña().equals(usuario.getContraseña())) {
            return ResponseEntity.ok("Inicio de sesión correcto");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }
}
